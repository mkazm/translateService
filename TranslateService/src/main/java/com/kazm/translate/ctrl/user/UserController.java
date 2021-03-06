package com.kazm.translate.ctrl.user;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kazm.translate.dict.OrderStatusEnum;
import com.kazm.translate.manager.DaoManager;
import com.kazm.translate.manager.UserPageManager;
import com.kazm.translate.model.BalanceHistoryModel;
import com.kazm.translate.model.DocumentModel;
import com.kazm.translate.model.OrderModel;
import com.kazm.translate.model.PriceModel;
import com.kazm.translate.model.UserModel;
import com.kazm.translate.tools.Dictionary;
import com.kazm.translate.tools.Tools;

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
			getUserPageMana().setAddOrderPage(model);
		}
		return "user/addOrder";
	}

	@RequestMapping(value = "/orderList")
	public String orderList(Model model) {
		getUserPageMana().setOrderListPage(model);
		return "user/orderList";
	}

	@RequestMapping(value = "/clientOrderList")
	public String clientOrderList(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String username = auth.getName();
			UserModel user = getMana().getUserDao().findByUsername(username);
			getUserPageMana().setClientOrderListPage(model, user.getId());
		}
		return "user/clientOrderList";
	}

	@RequestMapping(value = "/translatingList")
	public String translatingList(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String username = auth.getName();
			UserModel user = mana.getUserDao().findByUsername(username);
			getUserPageMana().setTranslatingListPage(model, user.getId());
		}
		return "user/translateList";
	}

	@RequestMapping(value = "/translateAction/{id}")
	public String translateAction(Model model, @PathVariable Long id) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String username = auth.getName();
			UserModel user = mana.getUserDao().findByUsername(username);
			OrderModel order = mana.getOrderDao().findById(id);
			order.setWorker(user);
			order.setStatus(OrderStatusEnum.IN_PROGRESS);
			mana.getOrderDao().update(order);
			getUserPageMana().setTranslatingListPage(model, user.getId());
		}
		return "user/translateList";
	}

	@RequestMapping(value = "/cancelTranslateAction/{id}")
	public String cancelTranslateAction(Model model, @PathVariable Long id) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String username = auth.getName();
			UserModel user = mana.getUserDao().findByUsername(username);
			OrderModel order = mana.getOrderDao().findById(id);
			if (order.getWorker().getId().equals(user.getId())) {
				order.setWorker(null);
				order.setStatus(OrderStatusEnum.OPEN);
				if (order.getTranslation() != null) {
					String rootPath = System.getProperty("catalina.home");
					DocumentModel documentModel = order.getTranslation();
					String filePath = rootPath + documentModel.getPath();
					try {
						File file = new File(filePath);
						if (file.delete()) {
							System.out.println(file.getName() + " is deleted!");
						} else {
							System.out.println("Delete operation is failed.");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					order.setTranslation(null);
					getMana().getOrderDao().update(order);
					getMana().getDocumentDao().delete(documentModel);
				} else {
					mana.getOrderDao().update(order);
				}

			}
			getUserPageMana().setTranslatingListPage(model, user.getId());
		}
		return "user/translateList";
	}

	@RequestMapping(value = "/balance", method = RequestMethod.GET)
	public String balance(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String username = auth.getName();
			UserModel user = mana.getUserDao().findByUsername(username);
			getUserPageMana().setBalancePage(model, user.getId());
		}
		return "user/balance";
	}

	@RequestMapping(value = "/orderAction", method = RequestMethod.POST)
	public String orderAction(Model model, OrderModel order,
			@RequestParam("file") MultipartFile file) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			if (order.getDocumentLanguage().equals(
					order.getTranslationLanguage())) {
				model.addAttribute("error", Dictionary.EQUAL_LANGUAGE_WARNING);
				return "user/addOrder";
			}
			String filename = file.getOriginalFilename();
			if (!filename.endsWith(".txt")) {
				model.addAttribute("error", Dictionary.TXT_FILE_WARNING);
				return "user/addOrder";
			}
			PriceModel price = getMana().getPriceDao().getPrice(
					order.getDocumentLanguage(),
					order.getTranslationLanguage(), order.getDocumentType());
			if (price == null) {
				model.addAttribute("info", Dictionary.PRICE_NOT_ADDED_WARNING);
				return "user/addOrder";
			}
			String username = auth.getName();
			DocumentModel document = new DocumentModel();
			UserModel client = getMana().getUserDao().findByUsername(username);
			try {
				byte[] bytes = file.getBytes();
				String text = new String(bytes, "UTF-8");
				BigDecimal wordNumber = new BigDecimal(Tools.wordCount(text));
				BigDecimal finalPrice = price.getPrice().multiply(wordNumber);
				document = getMana().getDocumentDao().save(document);
				if (finalPrice.compareTo(client.getBalance()) > 0) {
					model.addAttribute("info", Dictionary.PRICE_TOO_HIGH
							+ " Cena: " + finalPrice + "z�" + " Saldo: "
							+ client.getBalance() + "z�");
					return "user/addOrder";
				}
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "media"
						+ File.separator + "documents");
				if (!dir.exists())
					dir.mkdirs();
				String fileName = document.getId() + "_"
						+ file.getOriginalFilename();
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
				document.setPath(filePath.replace(rootPath, ""));

				document = getMana().getDocumentDao().update(document);

				getMana().getUserDao().update(client);
				order.setClient(client);
				order.setStatus(OrderStatusEnum.OPEN);
				order.setDocument(document);
				order.setWords(wordNumber);
				order.setPrice(finalPrice);

				order = getMana().getOrderDao().save(order);
				BigDecimal newBalance = client.getBalance().add(
						finalPrice.negate());
				client.setBalance(newBalance);

				BalanceHistoryModel balanceHist = new BalanceHistoryModel();
				balanceHist.setUser(client);
				balanceHist.setDateStamp(new DateTime());
				balanceHist.setBalance(newBalance);
				balanceHist.setOperation(finalPrice.negate());
				getMana().getBalanceHistoryDao().save(balanceHist);
				getMana().getUserDao().save(client);

				getUserPageMana().setUserPageModel(model, auth);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/user/clientOrderList";
	}

	@RequestMapping(value = "/orderTranslateAction", method = RequestMethod.POST)
	public String orderTranslateAction(Model model, @RequestParam Long id,
			@RequestParam("file") MultipartFile file) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String username = auth.getName();
			UserModel user = getMana().getUserDao().findByUsername(username);
			OrderModel orderModel = getMana().getOrderDao().findById(id);
			String filename = file.getOriginalFilename();
			if (!filename.endsWith(".txt")) {
				getUserPageMana().setTranslatingListPage(model, user.getId());
				model.addAttribute("error", Dictionary.TXT_FILE_WARNING);
				return "user/addOrder";
			}
			DocumentModel document = new DocumentModel();
			document.setName(file.getOriginalFilename());
			byte[] bytes = null;
			try {
				bytes = file.getBytes();
				document = getMana().getDocumentDao().save(document);

				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "media"
						+ File.separator + "documents");
				if (!dir.exists())
					dir.mkdirs();
				String fileName = document.getId() + "_"
						+ file.getOriginalFilename();
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
				document.setPath(filePath.replace(rootPath, ""));
				document = getMana().getDocumentDao().update(document);

				orderModel.setTranslation(document);
				orderModel.setStatus(OrderStatusEnum.FINISHED);
				getMana().getOrderDao().update(orderModel);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/user/translatingList";
	}

	@RequestMapping(value = "/orderTranslateRemoveAction/{id}", method = RequestMethod.GET)
	public String orderTranslateRemoveAction(Model model, @PathVariable Long id) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String rootPath = System.getProperty("catalina.home");
			OrderModel orderModel = getMana().getOrderDao().findById(id);
			DocumentModel documentModel = orderModel.getTranslation();
			String filePath = rootPath + documentModel.getPath();
			try {
				File file = new File(filePath);
				if (file.delete()) {
					System.out.println(file.getName() + " is deleted!");
				} else {
					System.out.println("Delete operation is failed.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			orderModel.setTranslation(null);
			orderModel.setStatus(OrderStatusEnum.IN_PROGRESS);
			getMana().getOrderDao().update(orderModel);
			getMana().getDocumentDao().delete(documentModel);
		}

		return "redirect:/user/translatingList";
	}

	@RequestMapping(value = "/orderConfirmAction/{id}", method = RequestMethod.GET)
	public String orderConfirm(Model model, @PathVariable Long id) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			OrderModel order = mana.getOrderDao().findById(id);
			UserModel user = order.getWorker();
			order.setStatus(OrderStatusEnum.CLOSED);
			BigDecimal adminBanance = order.getPrice()
					.multiply(new BigDecimal(10))
					.divide(new BigDecimal(100), 2, BigDecimal.ROUND_UP);
			UserModel admin = mana.getUserDao().findByUsername("admin");
			BigDecimal adminFinalBalance = admin.getBalance().add(adminBanance);
			admin.setBalance(adminFinalBalance);
			BigDecimal finalBalance = user.getBalance().add(
					order.getPrice().add(adminBanance.negate()));
			user.setBalance(finalBalance);

			BalanceHistoryModel balanceHist = new BalanceHistoryModel();
			balanceHist.setUser(user);
			balanceHist.setDateStamp(new DateTime());
			balanceHist.setBalance(finalBalance);
			balanceHist.setOperation(order.getPrice()
					.add(adminBanance.negate()));
			getMana().getBalanceHistoryDao().save(balanceHist);

			BalanceHistoryModel adminBalanceHist = new BalanceHistoryModel();
			adminBalanceHist.setUser(admin);
			adminBalanceHist.setDateStamp(new DateTime());
			adminBalanceHist.setBalance(adminFinalBalance);
			adminBalanceHist.setOperation(adminBanance);
			getMana().getBalanceHistoryDao().save(adminBalanceHist);

			getMana().getUserDao().save(user);
			getMana().getUserDao().save(admin);
			getMana().getOrderDao().save(order);
		}

		return "redirect:/user/clientOrderList";
	}

	@RequestMapping(value = "/orderRemoveAction/{id}", method = RequestMethod.GET)
	public String orderRemoveAction(Model model, @PathVariable Long id) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String rootPath = System.getProperty("catalina.home");
			OrderModel orderModel = getMana().getOrderDao().findById(id);
			if (orderModel.getStatus().equals(OrderStatusEnum.OPEN)) {
				DocumentModel documentModel = orderModel.getDocument();
				String filePath = rootPath + documentModel.getPath();
				try {
					File file = new File(filePath);
					if (file.delete()) {
						System.out.println(file.getName() + " is deleted!");
					} else {
						System.out.println("Delete operation is failed.");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				String username = auth.getName();
				UserModel client = getMana().getUserDao().findByUsername(
						username);
				BigDecimal finalPrice = orderModel.getPrice();
				orderModel.setTranslation(null);
				getMana().getOrderDao().delete(orderModel);
				getMana().getDocumentDao().delete(documentModel);
				BigDecimal newBalance = client.getBalance().add(finalPrice);

				BalanceHistoryModel balanceHist = new BalanceHistoryModel();
				balanceHist.setUser(client);
				balanceHist.setDateStamp(new DateTime());
				balanceHist.setBalance(newBalance);
				balanceHist.setOperation(finalPrice);
				getMana().getBalanceHistoryDao().save(balanceHist);

				client.setBalance(newBalance);
				getMana().getUserDao().update(client);
			}
		}

		return "redirect:/user/clientOrderList";
	}

}
