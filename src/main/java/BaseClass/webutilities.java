package BaseClass;

import org.testng.asserts.SoftAssert;

public class webutilities {

	public void assertion(String actual, String expected) {
		SoftAssert a = new SoftAssert();
		a.assertEquals(actual, expected);
	}
}
