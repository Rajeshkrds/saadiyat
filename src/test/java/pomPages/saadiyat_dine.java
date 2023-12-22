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

public class saadiyat_dine {

	@FindBy(xpath = "(//a[contains(text(),'Dine')])[1]")
	private WebElement dine;

	@FindBy(xpath = "//a[contains(text(),'VIEW DETAILS')]")
	private List<WebElement> view_details_button;

	@FindBy(xpath = "(//a[contains(text(),'VIEW DETAILS')])[1]")
	private WebElement feels_view_details_button;

	@FindBy(xpath = "//ul[@class='pagination-ul']//li")
	private List<WebElement> pageno;

	@FindBy(xpath = "//div[@class=\"each\"]//a")
	private List<WebElement> other_links;

	@FindBy(xpath = "//button[contains(text(),'Accept All')]")
	private WebElement acceptcookies;

	@FindBy(xpath = "(//div[contains(@class,\"swiper-button\")])[1]")
	private WebElement previous_button;

	@FindBy(xpath = "(//div[contains(@class,\"swiper-button\")])[2]")
	private WebElement next_button;

	@FindBy(xpath = "//div[contains(@class,'swiper-slide swiper-slide-active')]//h3")
	private WebElement currentslide;

	public saadiyat_dine(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void dine_Page(WebDriver driver) throws IOException {
		dine.click();
		String currentUrl = driver.getCurrentUrl();
		URL current_url = new URL(currentUrl);

		HttpURLConnection httpconnect = (HttpURLConnection) current_url.openConnection();
		httpconnect.connect();

		int rescode = httpconnect.getResponseCode();
		if (rescode >= 400) {
			System.out.println(current_url + " - Page not found (Response code: " + rescode + ")");
		} else {
			System.out.println(current_url + " - Page found (Response code: " + rescode + ")");
		}
	}

	public void dine_menus(WebDriver driver) throws IOException, InterruptedException {
		for (int i = 0; i < pageno.size() - 1; i++) {
			for (int j = 0; j < view_details_button.size(); j++) {

				String newurl = view_details_button.get(j).getAttribute("href");
				URL new_url = new URL(newurl);

				HttpURLConnection httpconnect = (HttpURLConnection) new_url.openConnection();
				httpconnect.connect();

				int rescode = httpconnect.getResponseCode();
				if (rescode >= 400) {
					System.out.println(new_url + " - Page not found (Response code: " + rescode + ")");
				} else {
					driver.navigate().to(newurl);

					if (driver.getTitle() == null || driver.getTitle().isEmpty()) {
						System.out.println(driver.getCurrentUrl());
					} else {

						System.out.println(driver.getTitle());
						other_links_social_media(driver);
						driver.navigate().back();

					}
				}
			}
			if (acceptcookies.isDisplayed()) {
				acceptcookies.click();
			}
			pageno.get(i + 1).click();
		}
	}

	public void other_links_social_media(WebDriver driver) throws IOException, InterruptedException {
		for (WebElement links : other_links) {
			String link_urls = links.getAttribute("href");

			if (link_urls.startsWith("javascript:") || link_urls.startsWith("mailto:")
					|| link_urls.startsWith("tel:")) {
				System.out.println("Skipping JavaScript link: " + link_urls);
				continue; // Skip this link and continue to the next iteration
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

				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(tabs.size() - 1));

				if (driver.getTitle() == null || driver.getTitle().isEmpty()) {
					System.out.println(driver.getCurrentUrl());
				} else {
					System.out.println(driver.getTitle());
				}

				driver.close();
				driver.switchTo().window(tabs.get(0));
				Thread.sleep(2000);

			}
		}
	}

	public void carousel(WebDriver driver) throws IOException, InterruptedException {
		dine.click();
		if (acceptcookies.isDisplayed()) {
			acceptcookies.click();
		}
		feels_view_details_button.click();
		for (int j = 0; j < view_details_button.size(); j++) {
			// System.out.println(view_details_button.size());
			String newurl = view_details_button.get(j).getAttribute("href");
			URL new_url = new URL(newurl);

			HttpURLConnection httpconnect = (HttpURLConnection) new_url.openConnection();
			httpconnect.connect();

			int rescode = httpconnect.getResponseCode();
			if (rescode >= 400) {
				System.out.println(new_url + " - Page not found (Response code: " + rescode + ")");
			} else {
				((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", newurl);

				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(tabs.size() - 1));

				if (driver.getTitle() == null || driver.getTitle().isEmpty()) {
					System.out.println(driver.getCurrentUrl());
				} else {
					System.out.println(driver.getTitle());
					driver.close();
					driver.switchTo().window(tabs.get(0));
					Thread.sleep(2000);
				}
			}
		}

		// System.out.println("Before carousel action : " +currentslide.getText());
//		Thread.sleep(2000);
//		previous_button.click();
//		Thread.sleep(2000);
		// System.out.println("Clicking on Prevoius button carousel : "
		// +currentslide.getText());
//		next_button.click();
		// System.out.println("Clicking on Next button carousel : "
		// +currentslide.getText());
	}
}
