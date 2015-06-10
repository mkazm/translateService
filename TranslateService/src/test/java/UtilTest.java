import java.math.BigDecimal;

import org.junit.Test;

import com.kazm.translate.tools.Tools;

public class UtilTest {
	@Test
	public void wordCountTest() {
		String txt = "cos cos cos a";
		int number = Tools.wordCount(txt);
		System.out.println(number);
	}

	@Test
	public void cashTest() {
		BigDecimal adminBalance = null;
		BigDecimal price = new BigDecimal(10000.05);
		BigDecimal temp = price.multiply(new BigDecimal(10));
		adminBalance = temp.divide(new BigDecimal(100), 2, BigDecimal.ROUND_UP);
		BigDecimal rest = price.add(adminBalance.negate());
		System.out.println(price);
		System.out.println(adminBalance);
		System.out.println(rest);
	}
}
