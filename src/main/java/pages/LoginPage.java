package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Common;
import utils.Logger;

public class LoginPage extends BasePage {

    @FindBy(xpath="//input[@type='text']")
    WebElement loginTextbox;

    @FindBy(xpath="//input[@type='password']")
    WebElement passwordTextbox;

    @FindBy(xpath="//input[@class='button']")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SearchPage loginToSystem(String login, String password) {
        Logger.debug("Log in. User credential: login '"+login+"'; password '"+password+"'.");
        loginTextbox.clear();
        passwordTextbox.clear();
        Common.highlightElement(loginTextbox);
        loginTextbox.sendKeys(login);
        Common.highlightElement(passwordTextbox);
        passwordTextbox.sendKeys(password);
        Common.makeScreenshot();
        loginButton.click();
        return new SearchPage(driver);
    }

}
