package tests;

import library.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseClass {
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void verifyUsername() {
        boolean usernameExist = loginPage.verifyUsername();
        Assert.assertTrue(usernameExist);
    }

    @Test
    public void verifyPassword() {
        boolean passwordExist = loginPage.verifyPassword();
        Assert.assertTrue(passwordExist);
    }

    @Test
    public void verifyLoginButton() {
        boolean loginButtonExist = loginPage.verifyLoginButton();
        Assert.assertTrue(loginButtonExist);
    }


}