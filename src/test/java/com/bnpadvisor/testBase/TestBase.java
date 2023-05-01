package com.bnpadvisor.testBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    public static Properties prop;
    public static DesiredCapabilities capabilities = new DesiredCapabilities();

    public WebDriverWait wait;

    public TestBase(){
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/config.properties");
            prop = new Properties();
            try {
                prop.load(file);
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void initialize() {
        if (prop.getProperty("browser").equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");

            WebDriver cd = new ChromeDriver();
            webDriver.set(cd);
        } else if (prop.getProperty("browser").equals("FireFox")){
            WebDriver fd = new FirefoxDriver();
            webDriver.set(fd);
        } else if (prop.getProperty("browser").equals("remoteChrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-gpu");
            options.addArguments("--log-level=3");
            options.addArguments("--silent");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");

            capabilities.setCapability(ChromeOptions.CAPABILITY, options);

            try {
                WebDriver rwd = new RemoteWebDriver(new URL("url of node"), capabilities);
                webDriver.set(rwd);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        webDriver.get().manage().window().maximize();
        webDriver.get().get(prop.getProperty("testEnvironmentUrl"));
        webDriver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait = new WebDriverWait(webDriver.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait = new WebDriverWait(webDriver.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void actionClickOnElement(WebElement element) {
        Actions actions = new Actions(webDriver.get());
        actions.moveToElement(element).click().build().perform();
    }


    WebDriver driver;

    public void init(String browser) {
        if(browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("ID")) {
            driver = new InternetExplorerDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }
    }

    public void clickSomewhere() {
        driver.findElement(By.xpath("")).click();
        driver.navigate().to("abcd.com");
    }

}
