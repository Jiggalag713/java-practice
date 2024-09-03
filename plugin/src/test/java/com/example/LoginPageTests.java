package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;

public class LoginPageTests extends BaseTests{

    @ParameterizedTest
    @CsvSource({
            "admin$$,admin123",
            "Admin,admin123!!",
            "admin123,Admin",
            "%%%%%,$$$$$$"})
    public void invalidCredentials(String username, String password) {

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(username, password);

        // Verify Error Message
        assertEquals("Invalid credentials",objLoginPage.getErrorMessage());

    }

    @Test
    public void validLogin() {

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login("Admin", "admin123");

        HomePage objHomePage = new HomePage(driver);

        // Verify Home Page
        assertNotNull(objHomePage.getHomePageText());
        //assertEquals("Employee Information",objHomePage.getHomePageText());

    }

    @Test
    public void missingUsername() {

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login("", "admin123");

        // Verify Error Message
        assertEquals("Required",objLoginPage.getMissingUsernameText());

    }

    @Test
    public void missingPassword() {

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login("admin", "");

        // Verify Error Message
        assertEquals("Required",objLoginPage.getMissingPasswordText());

    }

}