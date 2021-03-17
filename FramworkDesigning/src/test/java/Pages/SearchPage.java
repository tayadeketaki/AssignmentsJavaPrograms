package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath="//*[@id='taxonomies']/div[1]")
    private WebElement shopCategory;

    @FindBy(xpath="//*[@id='taxonomies']/div[2]")
    private WebElement shopBrands;

    @FindBy(css = "input[id='keywords']")
    private WebElement searchKeyword;

    @FindBy(xpath="//input[@class='btn btn-success']")
    private WebElement searchSubmit;

    @FindBys(@FindBy(xpath = "//div[contains(@id,'product_')]"))
   //@FindBys(@FindBy(css="#products"))
    private List<WebElement> searchResult;

    public SearchPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void enterSearchCriteria(String searchCriteria)
    {
        searchKeyword.sendKeys("");
        searchKeyword.sendKeys(searchCriteria);
        searchSubmit.click();

    }

    public boolean verifySearchResults(String searchCriteria) {
        boolean searchResults = false;
        for(WebElement element : searchResult)
        {
            WebElement textElement  = element.findElement(By.tagName("span"));
            if(textElement.getText().contains(searchCriteria))
                searchResults = true;
            else
            {
                searchResults = false;
                break;
            }
        }
        return searchResults;
    }
}
