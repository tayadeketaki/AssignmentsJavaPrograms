package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage  {

    WebDriver driver;
    @FindBy(css="input[id='spree_user_email']")
    private WebElement emailField;

    @FindBy(css="input[id='spree_user_password']")
    private WebElement passwordField;

    @FindBy(css="input[name='commit']")
    private WebElement loginSubmit;

    @FindBy(xpath = "//div[contains(@class,'alert alert-')]")
    private WebElement loginMessage;


    //Create a Constructor
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    //Create a methods for these elements
    public void setEmailField(String emailID)
    {
        emailField.sendKeys(emailID);
    }

    public void setPasswordField(String password)
    {
        passwordField.sendKeys(password);
    }

    public void clickLoginSubmit()
    {
        loginSubmit.click();
    }
    public String getLoginMessage()
    {
        return loginMessage.getText();
    }


}
