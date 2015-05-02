import org.junit.Test;

import com.kazm.translate.tools.Tools;

public class UtilTest {
	@Test
	public void wordCountTest() {
		String txt = "cos cos cos a";
		int number = Tools.wordCount(txt);
		System.out.println(number);
	}
}
