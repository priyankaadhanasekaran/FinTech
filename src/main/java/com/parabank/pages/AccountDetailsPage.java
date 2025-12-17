package com.parabank.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import java.util.List;

public class AccountDetailsPage {

    WebDriver driver;

    @FindBy(xpath = "//h1[contains(text(),'Account Details')]")
    WebElement header;

    @FindBy(xpath = "//table[@id='transactionTable']//tbody/tr")
    List<WebElement> transactions;

    public AccountDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isAt() {
        try { return header.isDisplayed(); }
        catch (Exception e) { return false; }
    }

    public int getTransactionCount() {
        return transactions.size();
    }
}

