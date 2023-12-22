package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.saadiyat_journey;

public class journey_Page extends BaseClass {

	@Test
	public void journey_page_tc() throws IOException, InterruptedException {
		saadiyat_journey journey = new saadiyat_journey(driver);
		journey.journey_sub_menus(driver);
	}

	@Test
	public void Journey_best_spa_Page() throws InterruptedException, IOException {
		saadiyat_journey journey = new saadiyat_journey(driver);
		journey.best_spa_page(driver);
	}

	@Test
	public void journey_staycation() throws InterruptedException, IOException {
		saadiyat_journey journey = new saadiyat_journey(driver);
		journey.staycation_page(driver);
	}
}
