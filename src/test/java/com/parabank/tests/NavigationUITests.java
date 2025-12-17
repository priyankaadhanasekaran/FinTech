package com.parabank.tests;

import com.parabank.base.*;
import com.parabank.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationUITests extends BaseTest {

    @Test
    public void verifyNavigationAcrossMenu() {
        LoginPage login = new LoginPage(driver);
        login.login(Config.USERNAME, Config.PASSWORD);

        HomePage home = new HomePage(driver);

        home.clickAccountsOverview();
        Assert.assertTrue(new AccountsOverviewPage(driver).isAt());

        home.clickOpenAccount();
        Assert.assertTrue(driver.getTitle().contains("Open Account"));

        home.clickTransferFunds();
        Assert.assertTrue(driver.getTitle().contains("Transfer Funds"));

        home.clickRequestLoan();
        Assert.assertTrue(driver.getTitle().contains("Request Loan"));
    }
}
