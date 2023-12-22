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

public class saadiyat_Experience {

	@FindBy(xpath = "(//a[contains(text(),'Experiences')])[1]")
	private WebElement experience_menu;

	@FindBy(xpath = "//a[contains(text(),'All')]")
	private WebElement exp_all_option;

	@FindBy(xpath = "//a[contains(text(),'EXPLORE NOW')]")
	private List<WebElement> exploreNow;

	@FindBy(xpath = "(//ul[@class='sub-menu'])[2]//a")
	private List<WebElement> exp_menu_options;

	@FindBy(xpath = "//a[contains(text(),'Art & Culture')]")
	private WebElement exp_arts_option;

	@FindBy(xpath = "//a[contains(text(),'Leisure')]")
	private WebElement exp_lesiure_option;

	@FindBy(xpath = "//a[contains(text(),'Food')]")
	private WebElement exp_food;

	@FindBy(xpath = "//a[contains(text(),'Sports')]")
	private WebElement exp_sports;

	@FindBy(xpath = "//a[@class='btn-rounded']")
	private WebElement banner_button;

	@FindBy(xpath = "//button[contains(text(),'Accept All')]")
	private WebElement acceptcookies;

	@FindBy(xpath = "//div[@class=\"each\"]//a")
	private List<WebElement> other_links;

	@FindBy(xpath = "(//a[contains(text(),'The Abrahamic Family House')])[1]")
	private WebElement exp_arabicfam;

	@FindBy(xpath = "(//a[contains(text(),'Louvre Abu Dhabi')])[1]")
	private WebElement exp_lovabu;

	@FindBy(xpath = "(//a[contains(text(),'Manarat Al Saadiyat')])[1]")
	private WebElement exp_manarat;

	@FindBy(xpath = "(//a[contains(text(),'Saadiyat Beach Golf Club')])[1]")
	private WebElement exp_golfclubm;

	@FindBy(xpath = "(//a[contains(text(),'Saadiyat Beach Club')])[1]")
	private WebElement exp_beachclub;

	@FindBy(xpath = "(//a[contains(text(),'Mamsha Al Saadiyat')])[1]")
	private WebElement exp_mamsha;

	@FindBy(xpath = "(//a[contains(text(),'Kai Beach')])[1]")
	private WebElement exp_kaibeach;

	@FindBy(xpath = "//a[contains(text(),'VIEW DETAILS')]")
	private List<WebElement> view_details_button;

	public saadiyat_Experience(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void experiencePage(WebDriver driver) throws IOException, InterruptedException {

		for (int i = 0; i < exp_menu_options.size(); i++) {
			String url = exp_menu_options.get(i).getAttribute("href");
			URL newurl = new URL(url);
			HttpURLConnection httpconnect = (HttpURLConnection) newurl.openConnection();
			httpconnect.connect();

			int resposeCode = httpconnect.getResponseCode();
			if (resposeCode >= 400) {
				System.out.println(newurl + " - Page not found (Response code: " + resposeCode + ")");
			}

			else {
//				((JavascriptExecutor)driver).executeScript("window.open(arguments[0])", url);
				driver.navigate().to(url);

//				ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
//				driver.switchTo().window(tabs.get(tabs.size()-1));

				if (driver.getTitle() == null || driver.getTitle().isEmpty()) {
					System.out.println(driver.getCurrentUrl());
				} else {
					System.out.println(driver.getTitle());
					view_details_button_cta(driver);
					other_links_social_media(driver);
//					if(banner_button.isDisplayed()) 
//					{
//						if(acceptcookies.isDisplayed()) 
//						{
//							acceptcookies.click();
//						}
//						Thread.sleep(2000);
//						banner_button.click();
////						 Set<String> windowHandles = driver.getWindowHandles();
////						    for (String handle : windowHandles) {
////						        driver.switchTo().window(handle);
////						        Thread.sleep(2000);
////						    }
//					}
//					else 
//					{
//						System.out.println();
//					}
					Thread.sleep(2000);
					driver.navigate().back();
					Thread.sleep(2000);
				}
//				driver.close();
//				driver.switchTo().window(tabs.get(0));
			}
		}

	}

	public void exploreNow(WebDriver driver) throws IOException {
		for (int i = 0; i <= exploreNow.size(); i++) {
			String explore_now = exploreNow.get(i).getAttribute("href");
			URL newurl = new URL(explore_now);
			HttpURLConnection httpconnect = (HttpURLConnection) newurl.openConnection();
			httpconnect.connect();

			int resposeCode = httpconnect.getResponseCode();
			if (resposeCode >= 400) {
				System.out.println(newurl + " - Page not found (Response code: " + resposeCode + ")");
			}

			else {
				((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", explore_now);

				ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(tabs.size() - 1));

				if (driver.getTitle() == null || driver.getTitle().isEmpty()) {
					System.out.println(driver.getCurrentUrl());
				} else {
					System.out.println(driver.getTitle());
				}
				driver.close();
				driver.switchTo().window(tabs.get(0));
			}
		}
	}

	public void all_option(WebDriver driver) throws IOException {
		experience_menu.click();
		exp_all_option.click();
		exploreNow(driver);
	}

	public void arts_culture(WebDriver driver) throws IOException {
		exp_arts_option.click();
		exploreNow(driver);
	}

	public void lesiure(WebDriver driver) throws IOException {
		exp_lesiure_option.click();
		exploreNow(driver);
	}

	public void food(WebDriver driver) {
		exp_food.click();
		System.out.println(driver.getTitle());

	}

	public void sports(WebDriver driver) {
		exp_sports.click();
		System.out.println(driver.getTitle());
	}

	public void exp_sub_menus(WebDriver driver) throws IOException, InterruptedException {
		Actions a = new Actions(driver);
		a.moveToElement(experience_menu);
		exp_arabicfam.click();
		other_links_social_media(driver);
		Thread.sleep(2000);
		exp_lovabu.click();
		other_links_social_media(driver);
		Thread.sleep(2000);
		exp_manarat.click();
		other_links_social_media(driver);
		Thread.sleep(2000);
		exp_golfclubm.click();
		other_links_social_media(driver);
		Thread.sleep(2000);
		exp_beachclub.click();
		other_links_social_media(driver);
		Thread.sleep(2000);
		exp_mamsha.click();
		other_links_social_media(driver);
		Thread.sleep(2000);
		exp_kaibeach.click();
		other_links_social_media(driver);
		Thread.sleep(2000);
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

	public void view_details_button_cta(WebDriver driver) throws IOException, InterruptedException {
		for (int i = 0; i < view_details_button.size(); i++) {
			String B_urls = view_details_button.get(i).getAttribute("href");
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
}
