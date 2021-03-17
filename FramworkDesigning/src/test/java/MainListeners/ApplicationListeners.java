package MainListeners;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import Tests.BaseTest;
import utilities.UtilitiesRequired;



public class ApplicationListeners implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {

            Reporter.log(result.getName() + " Test Case is PASS");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        //Take screenshots
    	
    	Reporter.log( result.getName() + " Test Case is FAIL");
    	try {
    		File scrFile = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
    		System.out.println(System.getProperty("user.dir"));
    		File screenshotName = new File (System.getProperty("user.dir")+"//Screenshots//"+System.currentTimeMillis()+".jpg");
    		FileUtils.copyFile(scrFile, screenshotName);
    		Reporter.log("<br><img src='"+screenshotName+"'height='300' width='300'/><br>");
    		Reporter.log("<td><a href='" + screenshotName
                    + "'><img src='" + screenshotName
                    + "' height='300' width='300' /></a></td>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
		

    }

	
	


}