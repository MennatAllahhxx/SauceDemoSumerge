package tests;

import library.BaseClass;
import library.UtilityClass;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class LoginPageTest extends BaseClass {
    LoginPage loginPage;
    int TCID;

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

    @Test
    public void loginWithValidCredentials() throws IOException {
        loginPage.enterCredentials("standard_user", "secret_sauce");

        String actualURL = loginPage.getCurrentURL();
        String expectedURL = UtilityClass.readPFData("productPageURL");
        Assert.assertEquals(actualURL, expectedURL);

        boolean swagLabsLogoExist = loginPage.verifySwagLabsLogo();
        Assert.assertTrue(swagLabsLogoExist);
    }

    @Test
    public void loginWithInvalidCredentials() throws IOException {
        loginPage.enterCredentials("menna", "mennapassword");

        String actualURL = loginPage.getCurrentURL();
        String expectedURL = UtilityClass.readPFData("URL");
        Assert.assertEquals(actualURL, expectedURL);

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test
    public void loginWithBlankUsername() throws IOException {
        loginPage.enterCredentials("", "menna");

        String actualURL = loginPage.getCurrentURL();
        String expectedURL = UtilityClass.readPFData("URL");
        Assert.assertEquals(actualURL, expectedURL);

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username is required";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test
    public void loginWithBlankPassword() throws IOException {
        loginPage.enterCredentials("menna", "");

        String actualURL = loginPage.getCurrentURL();
        String expectedURL = UtilityClass.readPFData("URL");
        Assert.assertEquals(actualURL, expectedURL);

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test
    public void loginWithBlankCredentials() throws IOException {
        loginPage.enterCredentials("", "");

        String actualURL = loginPage.getCurrentURL();
        String expectedURL = UtilityClass.readPFData("URL");
        Assert.assertEquals(actualURL, expectedURL);

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username is required";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }
}