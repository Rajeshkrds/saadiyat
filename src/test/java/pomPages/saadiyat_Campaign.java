package pomPages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class saadiyat_Campaign {

	@FindBy(xpath="//a[contains(text(),'Sign up and win ')]")
	private WebElement signupButton;
	
	@FindBy(name="Name")
	private WebElement name;
	
	@FindBy(name="Family")
	private WebElement family;
	
	@FindBy(name="Email")
	private WebElement email;
	
	@FindBy(xpath="(//input[@type=\"checkbox\"])[1]")
	private WebElement ageCheckBox;
	
	@FindBy(xpath="(//input[@type=\"checkbox\"])[2]")
	private WebElement UAEcitizen;
	

	@FindBy(xpath="(//input[@type=\"checkbox\"])[3]")
	private WebElement termsandcondition;
	
	@FindBy(xpath="//a[contains(text(),'terms and conditions ')]")
	private WebElement tandcLink;
	
	@FindBy(xpath="//iframe[@title=\"reCAPTCHA\"]")
	private WebElement captcha;
	
	@FindBy(xpath="(//input[@type=\"submit\"])[1]")
	private WebElement subscribe;
	
	public saadiyat_Campaign(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void signup(WebDriver driver) throws InterruptedException 
	{
		
 //       String mainWindowHandle = driver.getWindowHandle();
        
        signupButton.click();
//        
//        for (String windowHandle : driver.getWindowHandles()) {
//            if (!windowHandle.equals(mainWindowHandle)) {
//                driver.switchTo().window(windowHandle);
//                
//                name();
//                familyName();
//                email();
//                Thread.sleep(2000);
//                checkbox();
//                captcha();
// //             subscribe();
//                break;
//            }
//            driver.close();
//            driver.switchTo().window(mainWindowHandle);
//        }
	}
	
	public void name() 
	{
		name.click();
		name.sendKeys("test");
	}
	
	public void familyName() 
	{
		family.click();
		family.sendKeys("KRDS");
	}
	
	public void checkbox() throws InterruptedException 
	{
		if(!ageCheckBox.isSelected()) 
		{
			ageCheckBox.click();
			Thread.sleep(2000);
		}
		else 
		{
			System.out.println("Age check box is already selected");
		}
        
		if(!UAEcitizen.isSelected()) 
		{
			UAEcitizen.click();
	        Thread.sleep(2000);
		}
		else 
		{
			System.out.println("UAE resident check box is already selected");
		}
		
		if(!termsandcondition.isSelected()) 
		{
			termsandcondition.click();
		}
		else 
		{
			System.out.println("Terms and condition check box is already selected");
		}
		
	}
	
	public void email() 
	{
		email.click();
		email.sendKeys("testone@gmail.com");
	}
	public void captcha() 
	{
		try 
		{
			captcha.isDisplayed();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public void subscribe() 
	{
		subscribe.click();
	}
	
	public void termsPage() 
	{
		tandcLink.click();
	}
}
