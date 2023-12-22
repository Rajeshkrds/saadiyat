package testScripts;

import org.openqa.selenium.By;

import BaseClass.BaseClass;
import pomPages.contactUsform;

public class contactUs extends BaseClass {

	public void contact_us_wthout_message_tc()
	{
		contactUsform form = new contactUsform(driver);
		form.contactusLink();
		form.firstName();
		form.lastName();
		form.mobileNumber();
		form.emailAddress();
		form.submit();
	}
	
	public void contact_us_wth_message_tc()
	{
		contactUsform form = new contactUsform(driver);
		form.contactusLink();
		form.firstName();
		form.lastName();
		form.mobileNumber();
		form.emailAddress();
		form.message();
		form.submit();
	}

	public void validation_message() 
	{
		contactUsform form = new contactUsform(driver);
		form.contactusLink();
		form.submit();
		String actual_message ="One or more fields have an error. Please check and try again.";
		String expected_message = driver.findElement(By.xpath("//div[@class=\"wpcf7-response-output\"]")).getText();
	
		
	}
}
