package testScripts;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import BaseClass.webutilities;
import pomPages.saadiyat_Campaign;

public class campaingPage extends BaseClass{

	@Test
	public void campaign_tc() throws InterruptedException 
	{
		webutilities u = new webutilities();
		
		saadiyat_Campaign campaign = new saadiyat_Campaign(driver);
		 String mainWindowHandle = driver.getWindowHandle();
		campaign.signup(driver);
		
		
		for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                String actual_title = driver.getTitle();
                System.out.println(actual_title);
                String expected_title ="Campaign - Saadiyat";
                u.assertion(actual_title, expected_title);
                
                
                campaign.termsPage();
                
                String expectedTitle ="Terms and conditions - Saadiyat";
                String actualTitle = driver.getTitle();
                System.out.println(driver.getTitle());
                u.assertion(actualTitle, expectedTitle);
                
                
                driver.navigate().back();
                campaign.name();
                campaign.familyName();
                campaign.email();
                Thread.sleep(2000);
                campaign.checkbox();
                campaign.captcha();
 //             campaign.subscribe();
                break;
            }
  
            driver.switchTo().window(mainWindowHandle);
            driver.close();
        }
	}
}