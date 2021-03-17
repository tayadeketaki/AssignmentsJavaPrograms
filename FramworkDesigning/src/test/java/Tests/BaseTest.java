package Tests;

import Pages.HomePage;
import Pages.SearchPage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class BaseTest {
	
	public static WebDriver driver;
    Properties properties;
    HomePage homePage;
    SearchPage searchOption;
    String webdriverLocation;
    String webdriverProp;
   
    @BeforeSuite
    public void setEnvironmentVariables() throws IOException {
        FileInputStream propertyFileName = new FileInputStream(System.getProperty("user.dir") + "//src//config.properties");
        properties = new Properties();
        properties.load(propertyFileName);
        webdriverProp = properties.getProperty("CROME_WEBDRIVER_PROPERTY");
        webdriverLocation = properties.getProperty("CROME_WEBDRIVER_LOCATION");

    }
    
   
    @BeforeTest
    public void browserInitialize()
    {
        System.setProperty(webdriverProp,webdriverLocation);
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    }



    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
    
  

}
