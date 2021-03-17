package utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



import Tests.BaseTest;

public class UtilitiesRequired extends BaseTest{
	
	public static void takeSnapShot() throws Exception{

		// Convert web driver object to TakeScreenshot
		
		TakesScreenshot scrShot = ((TakesScreenshot)driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(System.getProperty("user.dir")+"//src//utilities/");

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

            

    }

}
