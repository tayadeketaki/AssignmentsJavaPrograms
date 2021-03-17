package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage{

    @FindBy(xpath="//*[@id='taxonomies']/div[1]")
    private WebElement shopCategory;

    @FindBy(xpath="//*[@id='taxonomies']/div[2]")
    private WebElement shopBrands;

    @FindBys(@FindBy(xpath = "//div[contains(@id,'product_')]"))
    private WebElement searchResult;

    public SearchPage(WebDriver driver)
    {
        super(driver);
    }

    //Verify if searched results are correct.
    public boolean verifySearchResults(String searchCriteria)
    {
        List<WebElement>searchResults = new ArrayList<>();
        searchResults = driver.findElements(By.xpath("//div[contains(@id,'product_')]//a"));
        boolean flag=true;
        for(WebElement element : searchResults)
        {
            if(element.getAttribute("href").equalsIgnoreCase("searchCriteria"))
                flag =true;
            else
                flag = false;

        }
        return flag;
    }



}
