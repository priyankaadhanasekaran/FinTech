package com.parabank.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class TransferPage {

    WebDriver driver;

    @FindBy(linkText = "Transfer Funds")
    WebElement transferFundsLink;

    @FindBy(id = "amount")
    WebElement amount;

    @FindBy(id = "fromAccountId")
    WebElement fromAccount;

    @FindBy(id = "toAccountId")
    WebElement toAccount;

    @FindBy(xpath = "//input[@value='Transfer']")
    WebElement transferBtn;

    @FindBy(css = "#rightPanel p")
    WebElement confirmationText;

    public TransferPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openTransferPage() {
        transferFundsLink.click();
    }

    public void transferFunds(String amt, String from, String to) {
        amount.clear();
        amount.sendKeys(amt);

        fromAccount.sendKeys(from);
        toAccount.sendKeys(to);

        transferBtn.click();
    }

    public String getConfirmation() {
        try { return confirmationText.getText(); }
        catch (Exception e) { return ""; }
    }
}
