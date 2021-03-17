package TestClasses;

import Pages.BasePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void browserInitialize()
    {
        System.setProperty("webdriver.chrome.driver","C://Users//ketaki//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    }
    @Test (dataProvider = "dataProviderLogin")
    public void loginToApplication(String emailValue, String passwordValue){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginLink();
        loginPage.setEmailField(emailValue);
        loginPage.setPasswordField(passwordValue);
        loginPage.clickLoginSubmit();
        softAssert.assertEquals(loginPage.getLoginMessage(),"Logged in successfully");
    }

    @Test
    public void logoutFromApplication(){
        LoginPage loginPage  = new LoginPage(driver);
        loginPage.clickLogoutLink();
        loginPage.getLoginMessage();
        softAssert.assertEquals(loginPage.getLoginMessage(),"Signed out successfully.");

    }

    @DataProvider (name = "dataProviderLogin")
    public Object[][] dpMethod()
    {
        return new Object[][]
                {
                        { "ketaki.tayade@gmail.com", "ketaki123" }
                };

    }
}
