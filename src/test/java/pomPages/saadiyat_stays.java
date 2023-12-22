package pomPages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class saadiyat_stays {

	@FindBy(xpath = "(//a[contains(text(),'Stay')])[1]")
	private WebElement Stay_menu;

	@FindBy(xpath = "(//ul[@class='sub-menu'])[1]//a")
	private List<WebElement> stay_menu_options;

	@FindBy(xpath = "//a[contains(text(),'BOOK NOW')]")
	private List<WebElement> book_now_button;

	@FindBy(xpath = "//div[@class=\"each\"]//a")
	private List<WebElement> other_links;

	public saadiyat_stays(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void stays(WebDriver driver) throws IOException, InterruptedException {
		Stay_menu.click();

		for (WebElement bookNow : book_now_button) {
			String urls = bookNow.getAttribute("href");
			URL newurls = new URL(urls);
			HttpURLConnection hpptconnect = (HttpURLConnection) newurls.openConnection();
			hpptconnect.connect();

			int responseCode = hpptconnect.getResponseCode();
			if (responseCode >= 400) {
				System.out.println(newurls + " - Page not found (Response code: " + responseCode + ")");
			} else {
//	             System.out.println(newUrl + " - Page found (Response code: " + responseCode + ")");
				((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", urls);

				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(tabs.size() - 1));

				if (driver.getTitle() == null) {
					System.out.println(driver.getCurrentUrl());
				} else {
					System.out.println(driver.getTitle());
				}
				Thread.sleep(2000);
				driver.close();
				driver.switchTo().window(tabs.get(0));
			}
		}
	}

	public void stays_sub_menus(WebDriver driver) throws IOException, InterruptedException {
		for (int i = 0; i < stay_menu_options.size(); i++) {
			String urls = stay_menu_options.get(i).getAttribute("href");
			URL newurls = new URL(urls);
			HttpURLConnection hpptconnect = (HttpURLConnection) newurls.openConnection();
			hpptconnect.connect();

			int responseCode = hpptconnect.getResponseCode();
			if (responseCode >= 400) {
				System.out.println(newurls + " - Page not found (Response code: " + responseCode + ")");
			} else {
//	             System.out.println(newUrl + " - Page found (Response code: " + responseCode + ")");
				driver.navigate().to(urls);

				if (driver.getTitle() == null || driver.getTitle().isEmpty()) {
					System.out.println(driver.getCurrentUrl());
				} else {

					System.out.println(driver.getTitle());
					carouselCTA(driver);
					other_links_social_media(driver);
				}
				Thread.sleep(2000);
			}
		}
	}

	public void carouselCTA(WebDriver driver) throws IOException, InterruptedException {
		for (int i = 0; i < book_now_button.size(); i++) {
			String B_urls = book_now_button.get(i).getAttribute("href");
			URL bookurls = new URL(B_urls);
			HttpURLConnection hpptconnect = (HttpURLConnection) bookurls.openConnection();
			hpptconnect.connect();

			int responseCode = hpptconnect.getResponseCode();
			if (responseCode >= 400) {
				System.out.println(bookurls + " - Page not found (Response code: " + responseCode + ")");
			} else {
//	             System.out.println(newUrl + " - Page found (Response code: " + responseCode + ")");

				driver.navigate().to(B_urls);
				if (driver.getTitle() == null || driver.getTitle().isEmpty()) {
					System.out.println(driver.getCurrentUrl());
				} else {
					System.out.println(driver.getTitle());
					driver.navigate().back();
				}
				Thread.sleep(2000);
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

}
