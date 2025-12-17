package com.parabank.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage {

    WebDriver driver;

    @FindBy(linkText = "Open New Account")
    WebElement openNewAccountLink;

    @FindBy(id = "type")
    WebElement accountType;

    @FindBy(id = "fromAccountId")
    WebElement fromAccount;

    @FindBy(xpath = "//input[@value='Open New Account']")
    WebElement openAccountBtn;

    @FindBy(id = "newAccountId")
    WebElement newAccountId;

    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openOpenAccountPage() {
        openNewAccountLink.click();
    }

    public void createAccount(String type, String fromAcc) {
        new Select(accountType).selectByVisibleText(type);
        fromAccount.sendKeys(fromAcc);
        openAccountBtn.click();
    }

    public String getCreatedAccountId() {
        try { return newAccountId.getText().trim(); }
        catch (Exception e) { return ""; }
    }
}
