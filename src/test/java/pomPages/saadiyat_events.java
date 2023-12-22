package pomPages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class saadiyat_events {

	@FindBy(xpath = "(//a[contains(text(),'Events')])[1]")
	private WebElement events_menu;

	@FindBy(xpath = "//div[@class=\"card\"]//a")
	private List<WebElement> upcoming_events;

	@FindBy(xpath = "//a[contains(@class,'btn-rounded')]")
	private WebElement cta_button;

	@FindBy(xpath = "//button[contains(text(),'Accept All')]")
	private WebElement acceptcookies;

	@FindBy(id = "category")
	private WebElement categoryfilter;

	@FindBy(id = "venue")
	private WebElement venuefilter;

	@FindBy(xpath = "(//input[@type=\"submit\"])[1]")
	private WebElement submit;

	@FindBy(xpath = "//div[@class=\"card\"]//h3")
	private List<WebElement> event_title;

	@FindBy(xpath = "//div[@class=\"card\"]")
	private WebElement eventcard;

	@FindBy(name = "event_date")
	private WebElement date;

	public saadiyat_events(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void events_page(WebDriver driver) throws IOException, InterruptedException {
		events_menu.click();

		if (acceptcookies.isDisplayed()) {
			acceptcookies.click();
		}
		String currentUrl = driver.getCurrentUrl();
		URL current_url = new URL(currentUrl);

		HttpURLConnection httpconnect = (HttpURLConnection) current_url.openConnection();
		httpconnect.connect();

		int rescode = httpconnect.getResponseCode();
		if (rescode >= 400) {
			System.out.println(current_url + " - Page not found (Response code: " + rescode + ")");
		} else {
			for (WebElement upcoming_event : upcoming_events) {
				String url = upcoming_event.getAttribute("href");
				URL newlearnurl = new URL(url);
				HttpURLConnection httpconnects = (HttpURLConnection) newlearnurl.openConnection();
				httpconnects.connect();

				int resposeCode = httpconnects.getResponseCode();
				if (resposeCode >= 400) {
					System.out.println(newlearnurl + " - Page not found (Response code: " + resposeCode + ")");
				}

				else {
					driver.navigate().to(url);
					if (driver.getTitle() == null || driver.getTitle().isEmpty()) {
						System.out.println(driver.getCurrentUrl());
					} else {
						System.out.println(driver.getTitle());
						event_details_page_cta(driver);
						Thread.sleep(1000);
						driver.navigate().back();
						Thread.sleep(1000);
					}
//
				}
			}

		}

	}

	public void event_details_page_cta(WebDriver driver) throws IOException, InterruptedException {

		if (acceptcookies.isDisplayed()) {
			acceptcookies.click();
		}

		try {
			String link_urls = cta_button.getAttribute("href");

			if (link_urls.startsWith("javascript:") || link_urls.startsWith("mailto:")
					|| link_urls.startsWith("tel:")) {
				System.out.println("Skipping JavaScript link: " + link_urls);
			}

			URL newurls = new URL(link_urls);
			HttpURLConnection hpptconnect = (HttpURLConnection) newurls.openConnection();
			hpptconnect.connect();

			int responseCode = hpptconnect.getResponseCode();
			if (responseCode >= 400) {
				System.out.println(newurls + " - Page not found (Response code: " + responseCode + ")");
			} else {
//	             System.out.println(newUrl + " - Page found (Response code: " + responseCode + ")");
				((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", link_urls);

				ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(tabs.size() - 1));

				if (driver.getTitle() == null || driver.getTitle().isEmpty()) {
					System.out.println(driver.getCurrentUrl());
				} else {
					System.out.println(driver.getTitle());
				}

				driver.close();
				driver.switchTo().window(tabs.get(0));
				Thread.sleep(1000);

			}

		} catch (Exception e) {
			System.out.println("No booking availabe for the event - " + driver.getTitle());
		}

	}

	public void category_filter() throws InterruptedException {
		events_menu.click();
		Select selectCategory = new Select(categoryfilter);
		for (WebElement options : selectCategory.getOptions()) {
			if (options.isEnabled()) {
				selectCategory.selectByVisibleText(options.getText());
				System.out.println("Events available in : " + options.getText());
				System.out.println();
				submit.click();
				List<WebElement> eventTitles = event_title;
				if (eventTitles.size() > 0) {
					for (WebElement title : event_title) {
						System.out.println(title.getText());
						Thread.sleep(1000);
					}
				} else {
					System.out.println("No events available");
				}
				System.out.println("=======================================================");
			} else {
				System.out.println("Option is diabled " + options.getText());
			}
		}
	}

	public void venues_filter() throws InterruptedException {
		events_menu.click();

		Select selectVenue = new Select(venuefilter);

//		for(WebElement options : selectVenue.getOptions())
		for (WebElement option : selectVenue.getOptions()) {
			if (option.isEnabled()) {
				selectVenue.selectByVisibleText(option.getText());
				System.out.println("Events available in : " + option.getText());
				System.out.println();

				submit.click();
				List<WebElement> eventTitles = event_title;
				if (eventTitles.size() > 0) {
					for (WebElement title : eventTitles) {
						System.out.println(title.getText());
						Thread.sleep(1000);
					}
				} else {
					System.out.println("No events available");
				}
				System.out.println("=======================================================");
			} else {
				System.out.println("Option is diabled " + option.getText());
			}

		}
	}

	public void venues_category_filter() throws InterruptedException {
		events_menu.click();

		Select selectCategory = new Select(categoryfilter);

		for (int i = 0; i < selectCategory.getOptions().size(); i++) {
			WebElement categoryOptions = selectCategory.getOptions().get(i);
			String category = categoryOptions.getText();
			if (categoryOptions.isEnabled()) {
				selectCategory.selectByIndex(i);
//				selectCategory.selectByVisibleText(categoryOptions.getText());
				Select selectVenue = new Select(venuefilter);
				for (int j = 0; j < selectVenue.getOptions().size(); j++) {
					WebElement venueOptions = selectVenue.getOptions().get(j);
					String venue = venueOptions.getText();
					if (venueOptions.isEnabled()) {
						selectVenue.selectByIndex(j);
//					selectVenue.selectByVisibleText(venueOptions.getText());
						System.out.println("Events available in : " + category + " category and " + venue + " venue");
						System.out.println();

						submit.click();
						List<WebElement> eventTilte = event_title;
						if (eventTilte.size() > 0) {
							for (WebElement title : event_title) {
								System.out.println(title.getText());
								Thread.sleep(1000);
							}
						} else {
							System.out.println("No events available");
						}
						System.out.println("=======================================================");

					}
				}
			}
		}
	}

	public void date_caterory() throws InterruptedException {
		date.click();
		date.sendKeys("12-11-2023");
		submit.click();
		List<WebElement> eventTitles = event_title;
		if (eventTitles.size() > 0) {
			for (WebElement title : eventTitles) {
				System.out.println(title.getText());
				Thread.sleep(1000);
			}
		} else {
			System.out.println("No events available");
		}
	}

	public void filters() throws InterruptedException {
		events_menu.click();
		date.click();
		date.sendKeys("12-11-2023");
		Select selectCategory = new Select(categoryfilter);

		for (int i = 0; i < selectCategory.getOptions().size(); i++) {
			WebElement categoryOptions = selectCategory.getOptions().get(i);
			String category = categoryOptions.getText();
			if (categoryOptions.isEnabled()) {
				selectCategory.selectByIndex(i);
//				selectCategory.selectByVisibleText(categoryOptions.getText());
				Select selectVenue = new Select(venuefilter);
				for (int j = 0; j < selectVenue.getOptions().size(); j++) {
					WebElement venueOptions = selectVenue.getOptions().get(j);
					String venue = venueOptions.getText();
					if (venueOptions.isEnabled()) {
						selectVenue.selectByIndex(j);
//					selectVenue.selectByVisibleText(venueOptions.getText());
						System.out.println("Events available in : " + category + " category and " + venue + " venue");
						System.out.println();

						submit.click();
						List<WebElement> eventTilte = event_title;
						if (eventTilte.size() > 0) {
							for (WebElement title : event_title) {
								System.out.println(title.getText());
								Thread.sleep(1000);
							}
						} else {
							System.out.println("No events available");
						}
						System.out.println("=======================================================");

					}
				}
			}
		}

	}
}
