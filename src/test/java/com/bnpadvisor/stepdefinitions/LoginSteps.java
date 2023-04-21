package com.bnpadvisor.stepdefinitions;

import com.bnpadvisor.pages.LoginPage;
import com.bnpadvisor.testBase.TestBase;
import io.cucumber.java.en.Given;

public class LoginSteps extends TestBase {

    public LoginSteps() {
        super();
    }

    @Given("User login with valid creds")
    public void loginWithValidCreds() {
        initialize();
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(prop.getProperty("user"));
        loginPage.enterPassword(prop.getProperty("pass"));
        loginPage.clickOnLoginButton();
    }
}
