package BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public void get_screenshot(String testName, WebDriver driver) throws IOException

	{
		Date currentDate = new Date();

		String formattedDate = currentDate.toString().replaceAll(":", "-");

		String fileName = testName + "_" + formattedDate + ".png";

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		File des = new File("C:\\Users\\Administrator\\eclipse-workspace\\Saadiyat\\Failed_TC\\" + fileName);

		FileUtils.copyFile(src, des);
	}
}
