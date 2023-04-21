package com.bnpadvisor.pages;

import com.bnpadvisor.testBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    WebDriver driver;

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "Login")
    private WebElement loginBtn;

    public LoginPage() {
        driver = webDriver.get();
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String userToEnter) {
        waitForElementToBeClickable(userName);
        userName.sendKeys(userToEnter);
    }

    public void enterPassword(String passwordToEnter) {
        waitForElementToBeClickable(userName);
        password.sendKeys(passwordToEnter);
    }

    public void clickOnLoginButton() {
        loginBtn.click();
    }
}
