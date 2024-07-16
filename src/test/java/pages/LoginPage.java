package pages;

import library.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    @FindBy(id="user-name")
    WebElement username;

    @FindBy(css="[id=password]")
    WebElement password;

    @FindBy(xpath="//*[@id=\"login-button\"]")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyUsername() {
        return username.isDisplayed();
    }

    public boolean verifyPassword() {
        return password.isDisplayed();
    }

    public boolean verifyLoginButton() {
        return loginButton.isDisplayed();
    }
}