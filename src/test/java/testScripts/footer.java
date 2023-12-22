package testScripts;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.footer_menu;

public class footer extends BaseClass {

	@Test
	public void footer_menus() throws InterruptedException {
		footer_menu footer = new footer_menu(driver);
		// footer.check_footer_links(driver);
		footer.check_social_links(driver);
		footer.emailSubscription();
	}
}
