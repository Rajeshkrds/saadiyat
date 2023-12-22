package testScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import BaseClass.webutilities;
import pomPages.contactUsform;

public class contactUs extends BaseClass {

	@Test
	public void contact_us_wthout_message_tc()
	{
		contactUsform form = new contactUsform(driver);
		form.contactusLink();
		form.firstName();
		form.lastName();
		form.mobileNumber();
		form.emailAddress();
//		form.submit();
	}
	@Test
	public void contact_us_wth_message_tc()
	{
		contactUsform form = new contactUsform(driver);
		form.contactusLink();
		form.firstName();
		form.lastName();
		form.mobileNumber();
		form.emailAddress();
		form.message();
//		form.submit();
	}
	@Test
	public void validation_message() throws InterruptedException 
	{
		webutilities u = new webutilities();
		contactUsform form = new contactUsform(driver);
		form.contactusLink();
		form.submit();
		Thread.sleep(1500);
		String actual_message ="One or more fields have an error. Please check and try again.";
		String expected_message = driver.findElement(By.xpath("//div[@class=\"wpcf7-response-output\"]")).getText();
		System.out.println(expected_message);
		Thread.sleep(1500);
		u.assertion(actual_message, expected_message);
		
	}
}
