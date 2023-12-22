package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.saadiyat_events;

public class events_Page extends BaseClass {

	@Test
	public void events_page_tc() throws IOException, InterruptedException {
		saadiyat_events events = new saadiyat_events(driver);
		events.events_page(driver);
	}

	@Test
	public void venue_filter_functionality_tc() throws InterruptedException {
		saadiyat_events events = new saadiyat_events(driver);
		events.venues_filter();
	}

	@Test
	public void category_filter_functionality_tc() throws InterruptedException {
		saadiyat_events events = new saadiyat_events(driver);
		events.category_filter();
	}

	@Test
	public void venue_and_category_filter_functionality_tc() throws InterruptedException {
		saadiyat_events events = new saadiyat_events(driver);
		events.venues_category_filter();
	}

	@Test
	public void date_filter_functionality_tc() throws InterruptedException {
		saadiyat_events events = new saadiyat_events(driver);
		events.date_caterory();
	}

	@Test
	public void filters() throws InterruptedException

	{
		saadiyat_events events = new saadiyat_events(driver);
		events.filters();
	}
}
