package Tests;

import Pages.HomePage;
import Pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
@Listeners(MainListeners.ApplicationListeners.class)
public class LoginPageTest extends BaseTest{


    @Test (dataProvider = "dataProviderLogin")
    public void loginToApplication(String emailValue, String passwordValue, String loginSuccessMessage) {
        //browserInitialize();
        homePage = new HomePage(driver);
        String loginSuccessfulMessage = homePage.loginToApplication(emailValue,passwordValue);
        Assert.assertEquals(loginSuccessMessage,loginSuccessfulMessage);

    }
    @Test
    public void logoutApplication(){
        String logoutSuccessfulMessage = homePage.logoutApplication();
        Assert.assertEquals(logoutSuccessfulMessage,"Signed out successfully.");
    }


    @DataProvider(name = "dataProviderLogin")
    public Object[][] dpMethod()
    {
        return new Object[][]
                {
                        { "ketaki.tayade@gmail.com", "ketaki123" , "Logged in successfully1"}
                };

    }

}
