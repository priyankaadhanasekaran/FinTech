package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class RegisterPage {

    WebDriver driver;

    @FindBy(id = "customer.firstName") WebElement firstName;
    @FindBy(id = "customer.lastName") WebElement lastName;
    @FindBy(id = "customer.address.street") WebElement address;
    @FindBy(id = "customer.address.city") WebElement city;
    @FindBy(id = "customer.address.state") WebElement state;
    @FindBy(id = "customer.address.zipCode") WebElement zip;
    @FindBy(id = "customer.phoneNumber") WebElement phone;
    @FindBy(id = "customer.ssn") WebElement ssn;
    @FindBy(id = "customer.username") WebElement username;
    @FindBy(id = "customer.password") WebElement password;
    @FindBy(id = "repeatedPassword") WebElement confirmPassword;
    @FindBy(xpath = "//input[@value='Register']") WebElement registerBtn;

    @FindBy(css = "#rightPanel h1")
    WebElement successHeader;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void registerUser(String fn, String ln, String addr, String c, String st,
                             String zipCode, String ph, String ss, String user, String pw) {

        firstName.sendKeys(fn);
        lastName.sendKeys(ln);
        address.sendKeys(addr);
        city.sendKeys(c);
        state.sendKeys(st);
        zip.sendKeys(zipCode);
        phone.sendKeys(ph);
        ssn.sendKeys(ss);
        username.sendKeys(user);
        password.sendKeys(pw);
        confirmPassword.sendKeys(pw);

        registerBtn.click();
    }

    public boolean isRegistrationSuccess() {
        try { return successHeader.getText().contains("Welcome"); }
        catch (Exception e) { return false; }
    }
}
