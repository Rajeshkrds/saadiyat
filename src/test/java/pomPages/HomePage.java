package pomPages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(tagName = "a")
	private List<WebElement> links;

	@FindBy(xpath = "(//a[contains(text(),'Stay')])[1]")
	private WebElement stay;

	@FindBy(xpath = "//a[contains(text(),'Sign up and win ')]")
	private WebElement signup_button;

	@FindBy(xpath = "//a[contains(text(),'Get your transport')]")
	private WebElement transport_button;
	
	@FindBy(xpath="//a[contains(text(),'MORE ABOUT US')]")
	private WebElement aboutusButton;

	@FindBy(xpath = "(//a[contains(text(),'EXPLORE ALL')])[1]")
	private WebElement exploreStays;

	@FindBy(xpath = "//button[contains(text(),'Accept All')]")
	private WebElement acceptcookies;

	@FindBy(xpath = "(//a[contains(text(),'EXPLORE ALL')])[3]")
	private WebElement exploreDine;

	@FindBy(xpath = "(//a[contains(text(),'EXPLORE ALL')])[5]")
	private WebElement exploreExperiences;
	
	@FindBy(xpath = "(//a[contains(text(),'EXPLORE ALL')])[7]")
	private WebElement exploreLearn;
	
	@FindBy(xpath="(//div[contains(@class,'swiper-container')])[2]//a")
	private List<WebElement> dineCarousalButton;
	
	@FindBy(xpath="(//div[contains(@class,'swiper-container')])[1]//a")
	private List<WebElement> staysCarousalButton;
	
	@FindBy(xpath="//span[@class=\"tp-tab-title\"]")
	private List<WebElement> experienceTabs;
	
	@FindBy(xpath="//div[@class=\"listing-row\"]//a")
	private List<WebElement> learnCTA;
	
	@FindBy(xpath="//a[@class=\"banner-btn\"]")
	private List<WebElement> experienceVeiwDetails; 
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void check_broken_links() throws IOException {
		for (WebElement link : links) {
			String url = link.getAttribute("href");

			// Check if the link starts with the "javascript:" protocol
			if (url.startsWith("javascript:") || url.startsWith("mailto:")) {
				System.out.println("Skipping JavaScript link: " + url);
				continue; // Skip this link and continue to the next iteration
			}

			try {
				URL newUrl = new URL(url);
				HttpURLConnection httpConnection = (HttpURLConnection) newUrl.openConnection();
				httpConnection.connect();

				int responseCode = httpConnection.getResponseCode();
				if (responseCode >= 400) {
					System.out.println(newUrl + " - Page not found (Response code: " + responseCode + ")");
				}
//		            else {
//		                System.out.println(newUrl + " - Page found (Response code: " + responseCode + ")");
//		            }
			} catch (MalformedURLException e) {
				System.out.println("Malformed URL: " + url);
			}
		}
	}

	public void signup_button() {
		signup_button.click();
	}

	public void get_your_transport() {
		transport_button.click();
	}
	
	public void aboutUs() 
	{
		aboutusButton.click();
	}

	public void exploreStays(WebDriver driver) throws InterruptedException, IOException {
		
		exploreStays.click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		carouselstaysCTA(driver);
	}
	
	public void carouselstaysCTA(WebDriver driver) throws IOException, InterruptedException {
		for (int i = 0; i < staysCarousalButton.size(); i++) {
			String B_urls = staysCarousalButton.get(i).getAttribute("href");
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
	
	public void exploreDine(WebDriver driver) throws IOException, InterruptedException 
	{
		exploreDine.click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		carouselDineCTA(driver);
	}
	
	public void carouselDineCTA(WebDriver driver) throws IOException, InterruptedException {
		
		for (int i = 0; i < dineCarousalButton.size(); i++) {
			String B_urls = dineCarousalButton.get(i).getAttribute("href");
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

	public void exploreExperiences(WebDriver driver) throws InterruptedException 
	{
		exploreExperiences.click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		for(int i=0; i<experienceTabs.size();i++) 
		{
			experienceTabs.get(i).click();
			for(int j=0; j<experienceVeiwDetails.size();j++ ) 
			{
				if(j==i) 
				{
					experienceVeiwDetails.get(j).click();
					System.out.println(driver.getTitle());
					driver.navigate().back();
					Thread.sleep(1000);
				}
			}
			
			
		}
	}
	
	public void exploreLearn(WebDriver driver) throws IOException, InterruptedException 
	{
		exploreLearn.click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		
		for (int i = 0; i < learnCTA.size(); i++) {
			String B_urls = learnCTA.get(i).getAttribute("href");
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
