package com.kazm.translate.ctrl.user;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kazm.translate.dict.OrderStatusEnum;
import com.kazm.translate.manager.DaoManager;
import com.kazm.translate.manager.UserPageManager;
import com.kazm.translate.model.DocumentModel;
import com.kazm.translate.model.OrderModel;
import com.kazm.translate.model.UserModel;

@Controller
@Transactional
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	DaoManager mana;

	public DaoManager getMana() {
		return mana;
	}

	@Autowired
	UserPageManager userPageMana;

	public UserPageManager getUserPageMana() {
		return userPageMana;
	}

	public void setUserPageMana(UserPageManager userPageMana) {
		this.userPageMana = userPageMana;
	}

	@RequestMapping(value = "")
	public String main(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			getUserPageMana().setUserPageModel(model, auth);
		}
		return "user/main";
	}

	@RequestMapping(value = "/order")
	public String order(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			getUserPageMana().setUserPageModel(model, auth);
		}
		return "user/addOrder";
	}

	@RequestMapping(value = "/orderList")
	public String orderList(Model model) {
		getUserPageMana().setOrderListPage(model);
		return "user/orderList";
	}

	@RequestMapping(value = "/orderAction", method = RequestMethod.POST)
	public String orderAction(Model model, OrderModel order,
			@RequestParam("file") MultipartFile file) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String username = auth.getName();
			DocumentModel document = new DocumentModel();
			UserModel client = getMana().getUserDao().findByUsername(username);
			try {
				byte[] bytes = file.getBytes();
				document.setName(file.getOriginalFilename());
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "media"
						+ File.separator + "documents");
				if (!dir.exists())
					dir.mkdirs();
				String fileName = file.getOriginalFilename();
				String filePath = dir.getAbsolutePath() + File.separator
						+ fileName;
				File serverFile = new File(filePath);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());

				document.setName(fileName);
				document.setPath(filePath);

				document = getMana().getDocumentDao().save(document);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			order.setClient(client);
			order.setStatus(OrderStatusEnum.OPEN);
			order.setDocument(document);

			order = getMana().getOrderDao().save(order);

			getUserPageMana().setUserPageModel(model, auth);
		}
		return "user/addOrder";
	}
}
