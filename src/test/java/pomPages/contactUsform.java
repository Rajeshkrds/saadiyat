package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactUsform {

	@FindBy(xpath="//a[contains(text(),'Contact us')]")
	private WebElement contactusLink;
	
	@FindBy(xpath ="(//input[@type=\"text\"])[1]")
	private WebElement firstName;
	
	@FindBy(xpath ="(//input[@type=\"text\"])[2]")
	private WebElement lastName;
	
	@FindBy(xpath ="//input[@type=\"tel\"]")
	private WebElement mobileNumber;
	
	@FindBy(name="your-email")
	private WebElement email;
	
	@FindBy(name="textarea-623")
	private WebElement message;
	
	@FindBy(xpath="(//input[@type=\"submit\"])[1]")
	private WebElement submit;
		
	public contactUsform(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void contactusLink() 
	{
		contactusLink.click();
	}
	public void firstName() 
	{
		firstName.click();
		firstName.sendKeys("test");
	}
	
	public void lastName() 
	{
		
		lastName.click();
		lastName.sendKeys("one");
	}
	
	public void mobileNumber() {
		mobileNumber.click();
		mobileNumber.sendKeys("123456789");
		
	}
	
	public void emailAddress()
	{
		email.click();
		email.sendKeys("testone@gmail.com");
		
	}
	public void message() {
		message.click();
		message.sendKeys("Testing form");
		
		submit.click();
	}
	
	public void submit() 
	{
		submit.click();
	}
	

	
}
