package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.HomePage;
import com.parabank.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTests extends BaseTest {

    @Test
    public void verifyValidUserRegistration() {
        HomePage home = new HomePage(driver);
        home.clickRegister();

        RegisterPage reg = new RegisterPage(driver);
        reg.registerUser(
                "Priya", "Sharma", "Street 1", "Chennai", "TN",
                "600001", "9000000000", "1111",
                "User" + System.currentTimeMillis(), "Password123"
        );

        Assert.assertTrue(reg.isRegistrationSuccess(),
                "Registration success text should appear.");
    }

    @Test
    public void verifyExistingUserRegistration() {
        HomePage home = new HomePage(driver);
        home.clickRegister();

        RegisterPage reg = new RegisterPage(driver);

        reg.registerUser(
                "Priya", "Sharma", "Street 1", "Chennai", "TN",
                "600001", "9000000000", "1111",
                "JohnPriya", "Password123"
        );

        // Parabank shows generic failure — no success header
        Assert.assertFalse(reg.isRegistrationSuccess(),
                "Registration should fail for existing user.");
    }

    @Test
    public void verifyBlankRegistrationFields() {
        HomePage home = new HomePage(driver);
        home.clickRegister();

        RegisterPage reg = new RegisterPage(driver);

        reg.registerUser("", "", "", "", "", "", "", "",
                "", "");

        Assert.assertFalse(reg.isRegistrationSuccess(),
                "Blank registration should not succeed.");
    }
}
