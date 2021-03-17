package Pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class BasePage {
    WebDriver driver;
    Select select;

    @FindBy(id="link-to-login")
    private WebElement loginLink;

    @FindBy(xpath="//select[@id='taxon']")
    private WebElement deptSearch;

    @FindBy(css = "input[id='keywords']")
    private WebElement searchKeyword;

    @FindBy(xpath="//a[@href='/logout']")
    private WebElement logoutLink;

    @FindBy(xpath="//input[@class='btn btn-success']")
    private WebElement searchSubmit;
    //Create a Constructor.

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Create the methods required for these objects.
    public void clickLoginLink()
    {
        loginLink.click();
    }

    //Select the department for Search
    public void selectDepartment(String deptName)
    {
        select = new Select(deptSearch);
        select.selectByValue(deptName);
    }

    //Enter Text for search criteria.
    public void enterTextForSearch(String searchText)
    {
        searchKeyword.sendKeys(searchText);
    }
    public void clickLogoutLink()
    {
        logoutLink.click();
    }
    public void clickSearchSubmit()
    {
        searchSubmit.click();
    }

}
