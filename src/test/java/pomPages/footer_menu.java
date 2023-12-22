package pomPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class footer_menu {

	@FindBy(xpath = "//div[@class='quick-links']//a")
	private List<WebElement> footer;

	@FindBy(xpath = "//div[@class='bottom clearfix']//a")
	private List<WebElement> social_links;

	@FindBy(xpath="//input[@class=\"tnp-button\"]")
	private WebElement subscribeButton;
	
	@FindBy(name="ne")
	private WebElement emailInputBox;
	
	public footer_menu(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void check_footer_links(WebDriver driver) throws InterruptedException {
		for (WebElement footer_links : footer) {
			((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", footer_links.getAttribute("href"));

			if (footer_links.getAttribute("href").startsWith("javascript:")
					|| footer_links.getAttribute("href").startsWith("mailto:")
					|| footer_links.getAttribute("href").startsWith("tel:")) {
				System.out.println("Skipping JavaScript link: " + footer_links.getAttribute("href"));
				continue; // Skip this link and continue to the next iteration
			}

			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabs.size() - 1));

			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			driver.close();
			driver.switchTo().window(tabs.get(0));
		}
	}

	public void check_social_links(WebDriver driver) throws InterruptedException {
		for (WebElement social_link : social_links) {
			((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", social_link.getAttribute("href"));

			if (social_link.getAttribute("href").startsWith("javascript:")
					|| social_link.getAttribute("href").startsWith("mailto:")
					|| social_link.getAttribute("href").startsWith("tel:")) {
				System.out.println("Skipping JavaScript link: " + social_link.getAttribute("href"));
				continue; // Skip this link and continue to the next iteration
			}

			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
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
	
	public void emailSubscription() 
	{
		emailInputBox.sendKeys("testone@gmail.com");
		subscribeButton.click();
	}
}
