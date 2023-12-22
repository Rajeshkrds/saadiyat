package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import BaseClass.webutilities;
import pomPages.Header_menus;
import pomPages.HomePage;

public class homePage extends BaseClass {

	webutilities u = new webutilities();

	@Test
	public void homePage_tc() throws IOException, InterruptedException {
		HomePage home = new HomePage(driver);
		// home.check_broken_links();
//		home.signup_button();
//		u.assertion(driver.getTitle(), "Campaign - Saadiyat");
//		home.get_your_transport();
//		u.assertion(driver.getTitle(), "Transportation – Coming from Dubai - Saadiyat");
//		home.aboutUs();
//		u.assertion(driver.getTitle(), "About us - Saadiyat");
//		home.exploreStays(driver);
//		home.exploreDine(driver);
//		home.exploreExperiences(driver);
		home.exploreLearn(driver);

	}

	@Test
	public void header_menu_functionality() throws InterruptedException, IOException {
		Header_menus menu = new Header_menus(driver);
		menu.menu_options(driver);
		menu.stay_menus(driver);

	}
}
