package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// Factory method pattern

interface IBrowser {
    WebDriver getBrowser();
}

class FirefoxTemporary implements IBrowser {
    public WebDriver getBrowser() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}

class FirefoxWithoutUI implements IBrowser {
    public WebDriver getBrowser() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        return new FirefoxDriver(options);
    }
}

class ChromeTemporary implements IBrowser {
    public WebDriver getBrowser() {
        // Set up Chrome driver
    	
        return new ChromeDriver();
    }
}

class ChromeProfile implements IBrowser {
    public WebDriver getBrowser() {
        WebDriverManager.chromedriver().setup();
        String userProfile = System.getenv("HOMEPATH") + "\\AppData\\Local\\Google\\Chrome\\User Data";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=" + userProfile);
        return new ChromeDriver(options);
    }
}

class ChromeWithoutUI implements IBrowser {
    public WebDriver getBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-proxy-server");
        options.addArguments("--ignore-certificate-errors");
        return new ChromeDriver(options);
    }
}

class PhantomjsTemporary implements IBrowser {
    public WebDriver getBrowser() {
        // Set up PhantomJS driver
    	
        return new PhantomJSDriver();
    }
}

class HtmlUnitTemporary implements IBrowser {
    public WebDriver getBrowser() {
    	// Set up HtmlUnitDriver driver
        
        return driver;
    }
}

public enum Browsers {
    DEFAULT_TEMPORARY(new ChromeTemporary()),
    FIREFOX_TEMPORARY(new FirefoxTemporary()),
    FIREFOX_WITHOUTUI(new FirefoxWithoutUI()),
    CHROME_TEMPORARY(new ChromeTemporary()),
    CHROME_PROFILE(new ChromeProfile()),
    CHROME_WITHOUTUI(new ChromeWithoutUI()),
    PHANTOMJS_TEMPORARY(new PhantomjsTemporary()),
    HTMLUNIT_TEMPORARY(new HtmlUnitTemporary());
    //
    private IBrowser browser;

    private Browsers(IBrowser browser) {
        this.browser = browser;
    }

    public WebDriver runBrowser(String baseUrl, Long implicitlyWait) {
        WebDriver driver = browser.getBrowser();
        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        return driver;
    }
}
