package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.saadiyat_learn;

public class learn_Page extends BaseClass {

	@Test
	public void learn_Page_tc() throws IOException, InterruptedException {
		saadiyat_learn learn = new saadiyat_learn(driver);
		learn.learn_menu(driver);
		learn.learn_sub_menu_pages(driver);
	}

	@Test
	public void learn_caruosel_fun_tc() throws IOException, InterruptedException {
		saadiyat_learn learn = new saadiyat_learn(driver);
		learn.carousel(driver);
	}
}
