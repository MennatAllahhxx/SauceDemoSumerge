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

    @FindBy(xpath="//*[@id=\"login_button_container\"]/div/form/div[3]")
    WebElement errorMessage;

    @FindBy(xpath ="//div[contains(text(), 'Swag Labs')]")
    WebElement swagLabsLogo;

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

    public void enterCredentials(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

    public boolean verifySwagLabsLogo() {
        return swagLabsLogo.isDisplayed();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}