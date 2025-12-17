package com.parabank.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import java.util.List;
import java.util.stream.Collectors;

public class AccountsOverviewPage {

    WebDriver driver;

    @FindBy(xpath = "//h1[contains(text(),'Accounts Overview')]")
    WebElement header;

    @FindBy(xpath = "//table[@id='accountTable']//tbody/tr/td[1]/a")
    List<WebElement> accountNumbers;

    public AccountsOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isAt() {
        try { return header.isDisplayed(); }
        catch (Exception e) { return false; }
    }

    public List<String> getAccountList() {
        return accountNumbers.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void openAccount(String accId) {
        for (WebElement acc : accountNumbers) {
            if (acc.getText().trim().equals(accId)) {
                acc.click();
                break;
            }
        }
    }
}

