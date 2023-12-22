package pomPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header_menus {

	@FindBy(xpath = "//nav[@class='main-nav']//a")
	private List<WebElement> menu;

	@FindBy(xpath = "(//a[contains(text(),'Stay')])[1]")
	private WebElement Stay_menu;

	@FindBy(xpath = "(//a[contains(text(),'Experiences')])[1]")
	private WebElement experience_menu;

	@FindBy(xpath = "(//a[contains(text(),'Dine')])[1]")
	private WebElement dine_menu;

	@FindBy(xpath = "(//a[contains(text(),'Learn')])[1]")
	private WebElement learn_menu;

	@FindBy(xpath = "(//a[contains(text(),'Journeys')])[1]")
	private WebElement journey_menu;

	@FindBy(xpath = "(//a[contains(text(),'Events')])[1]")
	private WebElement Events_menu;

	@FindBy(xpath = "(//a[contains(text(),'Saadiyat Guide')])[1]")
	private WebElement Guide_menu;

	@FindBy(xpath = "(//ul[@class='sub-menu'])[1]//a")
	private List<WebElement> stay_menu_options;

	public Header_menus(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void menu_options(WebDriver driver) throws InterruptedException {
		for (WebElement menuOptions : menu) {
			String options = menuOptions.getText();
			System.out.println(options);
//			WebElement Element = driver.findElement(By.xpath("(//a[contains(translate (text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'"+options+"')])[1]"));			
//			Element.click();

			((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", menuOptions.getAttribute("href"));

			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabs.size() - 1));
			Thread.sleep(2000);
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			driver.close();
			driver.switchTo().window(tabs.get(0));

		}

//		Stay_menu.click();
//		System.out.println(driver.getTitle());
//		experience_menu.click();System.out.println(driver.getTitle());
//		dine_menu.click();System.out.println(driver.getTitle());
//		learn_menu.click();System.out.println(driver.getTitle());
//		journey_menu.click();System.out.println(driver.getTitle());
//		Events_menu.click();System.out.println(driver.getTitle());
//		Guide_menu.click();System.out.println(driver.getTitle());
	}

	public void stay_menus(WebDriver driver) throws InterruptedException {
		Actions a = new Actions(driver);
		a.moveToElement(Stay_menu).perform();

		for (WebElement option : stay_menu_options)
////	for(int i=0; i<stay_menu_options.size();i++)
		{
			String optionText = option.getText();
			System.out.println(optionText);
//////
//////	        String href = option.getAttribute("href");
////	
////		System.out.println(stay_menu_options.get(i).getText());
////		
////		String text = stay_menu_options.get(i).getText();
////		driver.findElement(By.xpath("//a[contains(text(),'"+text+"')]")).click();
////		
////		

			((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", option.getAttribute("href"));

			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabs.size() - 1));
			Thread.sleep(2000);

			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			driver.close();
			driver.switchTo().window(tabs.get(0));

//	        a.moveToElement(Stay_menu).perform();
		}
//	    
////	    for(WebElement options : stay_menu_options) 
////	    {
////	    	String Text = options.getText();
////	    	driver.findElement(By.xpath("//a[contains(text(),'"+Text+"')]")).click();
////	    	 a.moveToElement(Stay_menu).perform();
////	    }

	}

}
