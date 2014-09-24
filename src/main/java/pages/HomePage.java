package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Таня on 23.09.2014.
 */
public class HomePage extends  BasePage {

    @FindBy(xpath="//*[@href='/login']")
    WebElement enterButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage openLoginPage() {
        enterButton.click();
        return new LoginPage(driver);
    }
}
