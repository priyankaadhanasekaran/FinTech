package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LoginPage {

    WebDriver driver;

    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Log In']")
    WebElement loginBtn;

    @FindBy(css = "#rightPanel p")
    WebElement welcomeText;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String user) {
        username.clear();
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        password.clear();
        password.sendKeys(pass);
    }

    public void clickLogin() {
        loginBtn.click();
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    public boolean isWelcomeMessageVisible() {
        try { return welcomeText.isDisplayed(); }
        catch (Exception e) { return false; }
    }
}
