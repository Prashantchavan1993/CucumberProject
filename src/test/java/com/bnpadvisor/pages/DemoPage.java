package com.bnpadvisor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bnpadvisor.testBase.TestBase;

public class DemoPage extends TestBase {
    WebDriver driver;

    @FindBy(xpath = "//h2[text()='Administration']/preceding-sibling::a")
    WebElement adminTab;

    public DemoPage() {
        PageFactory.initElements(webDriver.get(), this);
        driver = webDriver.get();
    }

    public void clickOnAdministrationTab() {
        adminTab.isDisplayed();
    }
}