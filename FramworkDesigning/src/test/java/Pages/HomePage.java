package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    //WebDriver driver;
    //WebElements
    @FindBy(css="input[id='spree_user_email']")
    private WebElement emailField;

    @FindBy(css="input[id='spree_user_password']")
    private WebElement passwordField;

    @FindBy(css="input[name='commit']")
    private WebElement loginSubmit;

    @FindBy(xpath = "//div[contains(@class,'alert alert-')]")
    private WebElement loginMessage;

    @FindBy(xpath="//a[@href='/login']")
    private WebElement loginLink;

    @FindBy(xpath="//a[@href='/logout']")
    private WebElement logoutLink;

    public HomePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String loginToApplication(String userEmail, String userPassword) {
        loginLink.click();
        emailField.sendKeys("");
        passwordField.sendKeys("");
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(userPassword);
        loginSubmit.click();
        return verifyMessage();
    }

    public String logoutApplication(){
        logoutLink.click();
        return verifyMessage();
    }

    public String verifyMessage()
    {
        return loginMessage.getText();
    }
}
