package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.base.Config;
import com.parabank.pages.HomePage;
import com.parabank.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void verifyLoginWithValidCredentials() {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.login(Config.USERNAME, Config.PASSWORD);

        Assert.assertTrue(login.isWelcomeMessageVisible(),
                "User should be logged in successfully.");
    }

    @Test
    public void verifyLoginWithInvalidPassword() {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.login(Config.USERNAME, "wrongpassword");

        Assert.assertFalse(login.isWelcomeMessageVisible(),
                "Login should fail with incorrect password.");
    }

    @Test
    public void verifyLoginWithEmptyFields() {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.enterUsername("");
        login.enterPassword("");
        login.clickLogin();

        Assert.assertFalse(login.isWelcomeMessageVisible(),
                "Login should not succeed with empty fields.");
    }

    @Test
    public void verifyInvalidEmailFormat() {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.enterUsername("user.com");
        login.enterPassword(Config.PASSWORD);
        login.clickLogin();

        Assert.assertFalse(login.isWelcomeMessageVisible(),
                "Invalid email format should not login.");
    }

    @Test
    public void verifyPasswordIsMasked() {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        LoginPage login = new LoginPage(driver);

        login.enterPassword("Secret123");
        String type = login.password.getAttribute("type");

        Assert.assertEquals(type, "password",
                "Password field should mask characters.");
    }
}
