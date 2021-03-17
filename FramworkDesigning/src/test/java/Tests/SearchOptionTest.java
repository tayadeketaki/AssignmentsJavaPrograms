package Tests;

import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MainListeners.ApplicationListeners.class)
public class SearchOptionTest extends BaseTest {

    @Test (dataProvider = "dataProviderSearchCriteria")
    public void verifySearchProductResults(String searchProductName){
        //browserInitialize();
        searchOption = new SearchPage(driver);
        searchOption.enterSearchCriteria(searchProductName);
        boolean searchResult = searchOption.verifySearchResults(searchProductName);
        Assert.assertTrue(searchResult);
    }

    @DataProvider(name = "dataProviderSearchCriteria")
    public Object[][] dpMethod()
    {
        return new Object[][]
                {
                        { "Ruby"}

                };

    }




}
