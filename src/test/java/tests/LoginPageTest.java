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
    int testCaseID;

    @BeforeMethod
    public void setup(ITestResult result) {
        loginPage = new LoginPage(driver);
        testCaseID = result.getMethod().getPriority();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            UtilityClass.captureSS(testCaseID);
        }

        driver.quit();
    }

    @Test(description="Verify the username text box existence", priority = 1)
    public void verifyUsername() {
        boolean usernameExist = loginPage.verifyUsername();
        Assert.assertTrue(usernameExist);
    }

    @Test(description="Verify the password text box existence", priority = 2)
    public void verifyPassword() {
        boolean passwordExist = loginPage.verifyPassword();
        Assert.assertTrue(passwordExist);
    }

    @Test(description="Verify the login button existence", priority = 3)
    public void verifyLoginButton() {
        boolean loginButtonExist = loginPage.verifyLoginButton();
        Assert.assertTrue(loginButtonExist);
    }

    @Test(description="Verify the log in functionality with valid credentials", priority = 4)
    public void loginWithValidCredentials() throws IOException {
        loginPage.enterCredentials("standard_user", "secret_sauce");

        String actualURL = loginPage.getCurrentURL();
        String expectedURL = UtilityClass.readPFData("productPageURL");
        Assert.assertEquals(actualURL, expectedURL);

        boolean swagLabsLogoExist = loginPage.verifySwagLabsLogo();
        Assert.assertTrue(swagLabsLogoExist);
    }

    @Test(description="Verify the log in functionality with invalid credentials", priority = 5)
    public void loginWithInvalidCredentials() throws IOException {
        loginPage.enterCredentials("menna", "mennapassword");

        String actualURL = loginPage.getCurrentURL();
        String expectedURL = UtilityClass.readPFData("URL");
        Assert.assertEquals(actualURL, expectedURL);

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test(description="Verify the log in functionality with blank username", priority = 6)
    public void loginWithBlankUsername() throws IOException {
        loginPage.enterCredentials("", "menna");

        String actualURL = loginPage.getCurrentURL();
        String expectedURL = UtilityClass.readPFData("URL");
        Assert.assertEquals(actualURL, expectedURL);

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username is required";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test(description="Verify the log in functionality with blank password", priority = 7)
    public void loginWithBlankPassword() throws IOException {
        loginPage.enterCredentials("menna", "");

        String actualURL = loginPage.getCurrentURL();
        String expectedURL = UtilityClass.readPFData("URL");
        Assert.assertEquals(actualURL, expectedURL);

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test(description="Verify the log in functionality with empty credentials", priority = 8)
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