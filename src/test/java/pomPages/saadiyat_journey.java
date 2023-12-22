package pomPages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class saadiyat_journey {

	@FindBy(xpath = "(//ul[@class='sub-menu'])[4]//a")
	private List<WebElement> jpurney_menu_options;

	@FindBy(xpath = "//div[@class=\"each\"]//a")
	private List<WebElement> other_links;

	@FindBy(xpath = "//a[contains(text(),'Best Spas in Abu Dhabi')]")
	private WebElement best_spas;

	@FindBy(xpath = "//a[contains(@class,'btn-rounded')]")
	private List<WebElement> cta_button;

	@FindBy(xpath = "//a[contains(text(),'Journeys')]")
	private WebElement journey;

	@FindBy(xpath = "//a[contains(text(),'Staycation')]")
	private WebElement staycation;

	public saadiyat_journey(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void journey_sub_menus(WebDriver driver) throws IOException, InterruptedException {
		for (int i = 0; i < jpurney_menu_options.size(); i++) {
			String url = jpurney_menu_options.get(i).getAttribute("href");
			URL newurl = new URL(url);
			HttpURLConnection httpconnect = (HttpURLConnection) newurl.openConnection();
			httpconnect.connect();

			int resposeCode = httpconnect.getResponseCode();
			if (resposeCode >= 400) {
				System.out.println(newurl + " - Page not found (Response code: " + resposeCode + ")");
			}

			else {
				driver.navigate().to(url);
				if (driver.getTitle() == null || driver.getTitle().isEmpty()) {
					System.out.println(driver.getCurrentUrl());
				} else {
					System.out.println(driver.getTitle());
					other_links_social_media(driver);
					Thread.sleep(2000);
					driver.navigate().back();
					Thread.sleep(2000);
				}

			}
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

	public void best_spa_page(WebDriver driver) throws InterruptedException, IOException {
		Actions a = new Actions(driver);
		a.moveToElement(journey).build().perform();
		best_spas.click();
		for (WebElement book_now : cta_button) {
			String link_urls = book_now.getAttribute("href");
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

	public void staycation_page(WebDriver driver) throws InterruptedException, IOException {
		Actions a = new Actions(driver);
		a.moveToElement(journey).build().perform();
		staycation.click();
		for (WebElement book_now : cta_button) {
			String link_urls = book_now.getAttribute("href");
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
}
