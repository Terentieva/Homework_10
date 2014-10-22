package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Common;
import utils.Logger;

/**
 * Created by Таня on 23.09.2014.
 */
public class SearchPage extends BasePage {
    @FindBy(xpath="//*[@href='/search']")
    WebElement searchLink;

    @FindBy(id="search_text")
    WebElement searchTextbox;

    @FindBy(id="search_button")
    WebElement searchButton;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openSearchPage() {
        Logger.debug("Open Search page");
        searchLink.click();
    }

    public void setSearchValue(String searchDescription) {
        Logger.debug("Enter search criteria: '" + searchDescription+"'");
        searchTextbox.clear();
        searchTextbox.sendKeys(searchDescription);
        Common.highlightElement(searchTextbox);
    }

    public void search() {
        Logger.debug("Click Search button");
        searchButton.click();
    }

}
