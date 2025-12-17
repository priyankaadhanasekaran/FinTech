package com.parabank.tests;

import com.parabank.base.*;
import com.parabank.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransactionsTests extends BaseTest {

    @Test
    public void verifyTransactionHistoryLoads() {
        LoginPage login = new LoginPage(driver);
        login.login(Config.USERNAME, Config.PASSWORD);

        HomePage home = new HomePage(driver);
        home.clickAccountsOverview();

        AccountsOverviewPage acc = new AccountsOverviewPage(driver);
        String firstAcc = acc.getAccountList().get(0);
        acc.openAccount(firstAcc);

        AccountDetailsPage details = new AccountDetailsPage(driver);

        Assert.assertTrue(details.isAt(), "Account Details should appear.");
        Assert.assertTrue(details.getTransactionCount() >= 0,
                "Transaction list should load (0 or more).");
    }
}
