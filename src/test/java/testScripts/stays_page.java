package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.saadiyat_stays;

public class stays_page extends BaseClass {

	@Test
	public void stays_page_tc() throws IOException, InterruptedException {
		saadiyat_stays stays = new saadiyat_stays(driver);
		stays.stays(driver);
		stays.stays_sub_menus(driver);
	}
}
