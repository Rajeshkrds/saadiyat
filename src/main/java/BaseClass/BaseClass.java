package BaseClass;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;

	@BeforeTest
	@SuppressWarnings("deprecation")
	public void launch_browser() throws IOException {
		
//		if (br.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		} else if (br.equals("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		} else if (br.equals("microsoft")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
		String prodURL = "https://saadiyatisland.ae/";
		String stagingURL = "https://saadiyat-island-bedrock.dev.kacdn.net/";

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get(stagingURL);
		driver.get(prodURL);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SoftAssert a = new SoftAssert();
		a.assertEquals(driver.getTitle(), "Home - Saadiyat");

//		URL url = new URL (stagingURL);
		URL url = new URL(prodURL);
		HttpURLConnection httpconnect = (HttpURLConnection) url.openConnection();
		httpconnect.connect();

		int resCode = httpconnect.getResponseCode();
		if (resCode >= 400) {
			System.out.println("Page not found - (Response Code : " + resCode + ")");
			driver.close();
		}
		
		driver.findElement(By.xpath("//button[contains(text(),'Accept All')]")).click();
	}

	@AfterMethod
	public void close_browser(ITestResult result) throws IOException {
		int status = result.getStatus();
		String name = result.getName();
		if (status == ITestResult.FAILURE) {
			Screenshot s = new Screenshot();
			s.get_screenshot(name, driver);
		}

		driver.close();
//		driver.quit();
	}
}
