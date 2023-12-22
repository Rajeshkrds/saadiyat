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

public class saadiyat_learn {

	@FindBy(xpath = "(//a[contains(text(),'Learn')])[1]")
	private WebElement learn_menu;

	@FindBy(xpath = "//button[contains(text(),'Accept All')]")
	private WebElement acceptcookies;

	@FindBy(xpath = "//div[@class=\"each\"]//a")
	private List<WebElement> other_links;

	@FindBy(xpath = "//a[contains(text(),'LEARN MORE')]")
	private List<WebElement> learn_more_button;

	@FindBy(xpath = "(//ul[@class='sub-menu'])[3]//a")
	private List<WebElement> learn_menu_options;

	@FindBy(xpath = "//div[@class=\"content clearfix\"]//a")
	private List<WebElement> content_links;

	@FindBy(xpath = "//a[contains(text(),'VIEW DETAILS')]")
	private List<WebElement> view_details_button;

	@FindBy(xpath = "(//a[contains(text(),'LEARN MORE')])[1]")
	private WebElement berklee_learn_more_button;

	public saadiyat_learn(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void learn_menu(WebDriver driver) throws IOException, InterruptedException {
		learn_menu.click();

		String currentUrl = driver.getCurrentUrl();
		URL current_url = new URL(currentUrl);

		HttpURLConnection httpconnect = (HttpURLConnection) current_url.openConnection();
		httpconnect.connect();

		int rescode = httpconnect.getResponseCode();
		if (rescode >= 400) {
			System.out.println(current_url + " - Page not found (Response code: " + rescode + ")");
		} else {
			for (int i = 0; i < learn_menu_options.size(); i++) {
				String url = learn_menu_options.get(i).getAttribute("href");
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
						Thread.sleep(2000);
						driver.navigate().back();
						Thread.sleep(2000);
					}
//				
				}
			}

		}

	}

	public void learn_sub_menu_pages(WebDriver driver) throws IOException, InterruptedException {
		for (int j = 0; j < learn_more_button.size(); j++) {

			String newurl = learn_more_button.get(j).getAttribute("href");
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
					sub_menu_realted_contents(driver);
					other_links_social_media(driver);
					driver.navigate().back();

				}
			}
		}
		if (acceptcookies.isDisplayed()) {
			acceptcookies.click();
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
//             System.out.println(newUrl + " - Page found (Response code: " + responseCode + ")");
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

	public void sub_menu_realted_contents(WebDriver driver) throws IOException, InterruptedException {
		for (WebElement links : content_links) {
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
//             System.out.println(newUrl + " - Page found (Response code: " + responseCode + ")");
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
		learn_menu.click();
		if (acceptcookies.isDisplayed()) {
			acceptcookies.click();
		}
		berklee_learn_more_button.click();
		for (int j = 0; j < view_details_button.size(); j++) {
//		System.out.println(view_details_button.size());
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
	}
}
