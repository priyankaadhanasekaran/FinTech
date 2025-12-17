package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(linkText = "Log In")
    WebElement loginLink;

    @FindBy(linkText = "Open New Account")
    WebElement openAccountLink;

    @FindBy(linkText = "Accounts Overview")
    WebElement accountsOverviewLink;

    @FindBy(linkText = "Transfer Funds")
    WebElement transferFundsLink;

    @FindBy(linkText = "Request Loan")
    WebElement requestLoanLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRegister() { registerLink.click(); }

    public void clickLogin() { loginLink.click(); }

    public void clickOpenAccount() { openAccountLink.click(); }

    public void clickAccountsOverview() { accountsOverviewLink.click(); }

    public void clickTransferFunds() { transferFundsLink.click(); }

    public void clickRequestLoan() { requestLoanLink.click(); }
}
