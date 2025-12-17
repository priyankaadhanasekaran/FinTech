package com.parabank.tests;

import com.parabank.base.*;
import com.parabank.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountsTests extends BaseTest {

    @Test
    public void verifyAccountsOverviewPageLoads() {
        LoginPage login = new LoginPage(driver);
        login.login(Config.USERNAME, Config.PASSWORD);

        HomePage home = new HomePage(driver);
        home.clickAccountsOverview();

        AccountsOverviewPage acc = new AccountsOverviewPage(driver);

        Assert.assertTrue(acc.isAt(), "Accounts Overview should load.");
        Assert.assertTrue(acc.getAccountList().size() > 0,
                "At least one account should be listed.");
    }

    @Test
    public void verifyAccountDetailsLoad() {
        LoginPage login = new LoginPage(driver);
        login.login(Config.USERNAME, Config.PASSWORD);

        HomePage home = new HomePage(driver);
        home.clickAccountsOverview();

        AccountsOverviewPage acc = new AccountsOverviewPage(driver);
        String firstAccount = acc.getAccountList().get(0);
        acc.openAccount(firstAccount);

        AccountDetailsPage details = new AccountDetailsPage(driver);

        Assert.assertTrue(details.isAt(), "Account Details page should appear.");
        Assert.assertTrue(details.getTransactionCount() >= 0,
                "Transaction table should be present.");
    }
}
