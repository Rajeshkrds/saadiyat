package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.saadiyat_dine;

public class dine_page extends BaseClass {

	@Test
	public void dine_Page_tc() throws IOException, InterruptedException {
		saadiyat_dine dine = new saadiyat_dine(driver);
		dine.dine_Page(driver);
		dine.dine_menus(driver);
	}

	@Test
	public void dine_carousel_fun_tc() throws IOException, InterruptedException {
		saadiyat_dine dine = new saadiyat_dine(driver);
		dine.carousel(driver);
	}
}
