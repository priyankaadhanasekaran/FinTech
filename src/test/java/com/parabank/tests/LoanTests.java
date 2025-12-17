package com.parabank.tests;

import com.parabank.base.*;
import com.parabank.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoanTests extends BaseTest {

    @Test
    public void verifyLoanRequest() {
        LoginPage login = new LoginPage(driver);
        login.login(Config.USERNAME, Config.PASSWORD);

        HomePage home = new HomePage(driver);
        home.clickRequestLoan();

        RequestLoanPage loan = new RequestLoanPage(driver);

        loan.requestLoan("1000", "100", "12345");

        String status = loan.getLoanStatus();

        Assert.assertTrue(status.length() > 1,
                "Loan status should be displayed.");
    }
}
