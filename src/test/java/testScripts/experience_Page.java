package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.saadiyat_Experience;

public class experience_Page extends BaseClass {

	@Test
	public void experience_Page_tc() throws IOException, InterruptedException {
		saadiyat_Experience exp = new saadiyat_Experience(driver);
		exp.experiencePage(driver);
//		exp.exp_sub_menus(driver);
		exp.all_option(driver);
		exp.arts_culture(driver);
		exp.lesiure(driver);
		exp.food(driver);
		exp.sports(driver);
	}

}
