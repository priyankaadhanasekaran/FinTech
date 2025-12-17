package com.parabank.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class RequestLoanPage {

    WebDriver driver;

    @FindBy(linkText = "Request Loan")
    WebElement requestLoanLink;

    @FindBy(id = "loanAmount")
    WebElement loanAmount;

    @FindBy(id = "downPayment")
    WebElement downPayment;

    @FindBy(id = "fromAccountId")
    WebElement fromAccount;

    @FindBy(xpath = "//input[@value='Apply Now']")
    WebElement applyNowBtn;

    @FindBy(id = "loanStatus")
    WebElement loanStatus;

    public RequestLoanPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLoanPage() {
        requestLoanLink.click();
    }

    public void requestLoan(String amount, String down, String fromAcc) {
        loanAmount.sendKeys(amount);
        downPayment.sendKeys(down);
        fromAccount.sendKeys(fromAcc);
        applyNowBtn.click();
    }

    public String getLoanStatus() {
        try { return loanStatus.getText(); }
        catch (Exception e) { return ""; }
    }
}

