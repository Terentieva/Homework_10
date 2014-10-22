package testing;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import utils.GetConfigAndTestData;
import utils.Logger;

public class WorkWithExUa extends BaseTest {

    @Test
    public void testSearch()
    {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.openLoginPage();
        GetConfigAndTestData getConfig = new GetConfigAndTestData();
        SearchPage searchPage = loginPage.loginToSystem(getConfig.getLogin(), getConfig.getPassword());
        searchPage.openSearchPage();
        searchPage.setSearchValue(getConfig.getSearchDescription());
        searchPage.search();

    }
}
