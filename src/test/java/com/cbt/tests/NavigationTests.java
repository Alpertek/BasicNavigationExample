package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    public static void main(String[] args) {

        String OS = System.getProperty("os.name").toLowerCase();

        testChrome();
        testFirefox();

        if(OS.contains("win")){
            testEdge();
        }
        else if(OS.contains("mac")){
            testSafari();
        }

    }
    static void test(WebDriver driver){

        driver.get("https://google.com");

        String expectedTitleGoogle = driver.getTitle();

        driver.navigate().to("https://etsy.com");
        String expectedTitleEtsy = driver.getTitle();

        driver.navigate().back();

        String actualTitleGoogle = driver.getTitle();

        driver.navigate().forward();

        String actualTitleEtsy = driver.getTitle();

        StringUtility.verifyEquals(expectedTitleGoogle, actualTitleGoogle);
        StringUtility.verifyEquals(expectedTitleEtsy, actualTitleEtsy);
        driver.quit();
    }
    private static void testChrome(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        test(driver);
    }
    private static void testFirefox(){
        WebDriver driver = BrowserFactory.getDriver("firefox");
        test(driver);
    }
    private static void testEdge(){
        WebDriver driver = BrowserFactory.getDriver("edge");
        test(driver);
    }
    private static void testSafari(){
        WebDriver driver = BrowserFactory.getDriver("safari");
        test(driver);
    }
}
