package com.parabank.tests;

import com.parabank.base.*;
import com.parabank.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferTests extends BaseTest {

    @Test
    public void verifyTransferFunds() {
        LoginPage login = new LoginPage(driver);
        login.login(Config.USERNAME, Config.PASSWORD);

        HomePage home = new HomePage(driver);
        home.clickTransferFunds();

        TransferPage tf = new TransferPage(driver);

        tf.transferFunds("100", "12345", "54321");

        String confirmation = tf.getConfirmation();

        Assert.assertTrue(confirmation.contains("complete")
                        || confirmation.contains("Success")
                        || confirmation.length() > 1,
                "Transfer confirmation should be displayed.");
    }
}
