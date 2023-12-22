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

public class saadiyat_blog {

	@FindBy(xpath = "//a[contains(text(),'Blog')]")
	private WebElement blogs;

	@FindBy(xpath = "//a[contains(text(),'KNOW MORE')]")
	private List<WebElement> know_more_button;

	@FindBy(xpath = "(//a[contains(text(),'KNOW MORE')])[1]")
	private WebElement know_more_btn;

	@FindBy(xpath = "//div[@class=\"each\"]//a")
	private List<WebElement> socials_links;

	@FindBy(xpath = "//div[@class=\"container \"]//a")
	private List<WebElement> trendingposts;

	@FindBy(xpath = "//div[@class=\"card\"]//a")
	private List<WebElement> related_post;

	@FindBy(xpath = "//button[contains(text(),'Accept All')]")
	private WebElement acceptcookies;

	public saadiyat_blog(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void blog_Page(WebDriver driver) throws IOException, InterruptedException {

		blogs.click();
		String currentUrl = driver.getCurrentUrl();
		URL current_url = new URL(currentUrl);

		HttpURLConnection httpconnect = (HttpURLConnection) current_url.openConnection();
		httpconnect.connect();

		int rescode = httpconnect.getResponseCode();
		if (rescode >= 400) {
			System.out.println(current_url + " - Page not found (Response code: " + rescode + ")");
		} else {
			for (WebElement knowMore : know_more_button) {
				String link_urls = knowMore.getAttribute("href");

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

	public void blog_details() {
		blogs.click();
		if (acceptcookies.isDisplayed()) {
			acceptcookies.click();
		}
		know_more_btn.click();

	}

	public void social_media(WebDriver driver) throws IOException, InterruptedException {
		for (WebElement links : socials_links) {
			String link_urls = links.getAttribute("href");

			if (link_urls.startsWith("#") || link_urls.startsWith("javascript:") || link_urls.startsWith("mailto:")
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

	public void trending_posts(WebDriver driver) throws IOException, InterruptedException {
		for (WebElement links : trendingposts) {
			String link_urls = links.getAttribute("href");

//			if (link_urls.startsWith("javascript:")|| link_urls.startsWith("mailto:")||link_urls.startsWith("tel:")) {
//		           System.out.println("Skipping JavaScript link: " + link_urls);
//		            continue; // Skip this link and continue to the next iteration
//		        }

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

	public void related_posts(WebDriver driver) throws IOException, InterruptedException {
		for (WebElement links : related_post) {
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
