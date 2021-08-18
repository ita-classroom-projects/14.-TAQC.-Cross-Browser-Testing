package com.softserve.edu;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BrowsersTest {
    private final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;

    private void presentationSleep() {
        presentationSleep(1);
    }

    private void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        presentationSleep(); // For Presentation ONLY
        if (!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("***TC error, name = " + testName + " ERROR");
            // Take Screenshot, Save sourceCode, Save to log, Prepare report, Return to previous state, logout, etc.
        }
        presentationSleep(); // For Presentation ONLY
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider
    public Object[][] dataListGroups() {
        return new Object[][] {
            { Browsers.CHROME_TEMPORARY, "Desktops" },
            { Browsers.CHROME_TEMPORARY, "Laptops & Notebooks" },
            { Browsers.CHROME_TEMPORARY, "Components" },
            { Browsers.CHROME_WITHOUTUI, "Laptops & Notebooks" },
            { Browsers.FIREFOX_TEMPORARY, "Laptops & Notebooks" },
            { Browsers.FIREFOX_WITHOUTUI, "Laptops & Notebooks" },
            { Browsers.PHANTOMJS_TEMPORARY, "Laptops & Notebooks" },
            { Browsers.HTMLUNIT_TEMPORARY, "Laptops & Notebooks" },
        };
    }

    @Test(dataProvider = "dataListGroups")
    public void checkListGroups(Browsers browser, String groupItem) {
        System.out.println("browser = " + browser.name()
                + " groupItem = " + groupItem);
        //
        // Start browser
        driver = browser.runBrowser(BASE_URL, IMPLICITLY_WAIT_SECONDS);
        presentationSleep(); // For Presentation ONLY
        //
        // TODO
        //
    }
   
    @DataProvider
    public Object[][] dataSearchCounts() {
        return new Object[][] { 
            { Browsers.CHROME_TEMPORARY, "mac", 4 },
            { Browsers.CHROME_WITHOUTUI, "ip", 6 },
            { Browsers.FIREFOX_TEMPORARY, "%", 31 },
            { Browsers.FIREFOX_WITHOUTUI, " ", 31 },
        };
    }

    @Test(dataProvider = "dataSearchCounts")
    public void checkSearchCounts(Browsers browser, String searchName,
            int expectedCounts) {
        System.out.println("browser = " + browser.name()
                + " searchName = " + searchName 
                + " expectedCounts = " + expectedCounts);
        //
        // Start browser
        driver = browser.runBrowser(BASE_URL, IMPLICITLY_WAIT_SECONDS);
        presentationSleep(); // For Presentation ONLY
        //
        // TODO
        //        
    }

    @DataProvider
    public Object[][] dataAdvancedSearchCounts() {
        return new Object[][] { 
            { Browsers.CHROME_TEMPORARY, "ip", "Desktops", 2 },
            { Browsers.CHROME_WITHOUTUI, "ip", "Phones & PDAs",  2 },
            { Browsers.FIREFOX_TEMPORARY, "ip", "Desktops", 2 },
            { Browsers.FIREFOX_WITHOUTUI, "ip", "Phones & PDAs", 2 },
        };
    }

    @Test(dataProvider = "dataAdvancedSearchCounts")
    public void checkAdvancedSearchCounts(Browsers browser, String searchName,
            String categoryName, int expectedCounts) {
        System.out.println("browser = " + browser.name()
                + " searchName = " + searchName 
                + " categoryName = " + categoryName 
                + " expectedCounts = " + expectedCounts);
        //
        // Start browser
        driver = browser.runBrowser(BASE_URL, IMPLICITLY_WAIT_SECONDS);
        presentationSleep(); // For Presentation ONLY
        //
        // TODO
        //        
    }
    
}
