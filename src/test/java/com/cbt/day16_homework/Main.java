package com.cbt.day16_homework;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Main {
    private static WebDriver driver ;
    @BeforeMethod
    private void setup(){
        driver = BrowserFactory.getDriver("chrome");
    }
    @AfterMethod
    private void close(){
        driver.close();
    }
    @AfterClass
    private void tearDown(){
        driver.quit();
    }
    @Test
    private void moveToElement() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement user1Avatar= driver.findElement(By.cssSelector(".figure:nth-of-type(1)>img"));
        WebElement user1 = driver.findElement(By.xpath("//a[text()='View profile'][1]"));
        Assert.assertFalse(user1.isDisplayed(),"Verify that user1 details are NOT displayed");
        Actions actions = new Actions(driver);
        actions.moveToElement(user1Avatar).perform();

        Thread.sleep(5000);

        Assert.assertTrue(user1.isDisplayed(),"Verify that user1 details are displayed");

    }
    @Test
    private void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        String actualBeforeDrop = target.getText();
        String expectedBeforeDrop ="Drag the small circle here.";
        Assert.assertEquals(actualBeforeDrop,expectedBeforeDrop,"Verify that ...");
        Thread.sleep(1000);
        Actions actions = new Actions(driver);

        actions.dragAndDrop(source,target).perform();
        String actualAfterDrop = target.getText();
        String expectedAfterDrop = "You did great!";
        Assert.assertEquals(actualAfterDrop,expectedAfterDrop,"Verify that ...");
        Thread.sleep(1000);
    }
    @Test
    void jsExecutionTest() throws InterruptedException {
        driver.get("https://www.etsy.com/");
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("paper" + Keys.ENTER);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        Thread.sleep(3000);
//        String javascript =
//                "let elements = document.querySelectorAll('ul[data-ui=top-nav-category-list]>li');"+
//                "for(let i = 0;i < elements.length; i++){" +
//                        "elements[i].remove();" +
//                "}";
//        jsExecutor.executeScript(javascript);
//        String xpathTotheElement= "//a[text()='Copyright 1999-2021']";
//        WebElement element = driver.findElement(By.xpath(xpathTotheElement));
//        jsExecutor.executeScript("arguments[0].scrollIntoView(true)",element);
//        Thread.sleep(10000);
        WebElement element = driver.findElement(By.xpath("(//span[text()='10.53'])[3]"));


        jsExecutor.executeScript("arguments[0].scrollIntoView(true)",element);
        Thread.sleep(1000);
    }
    @Test
    private void testHaberler() throws InterruptedException {
        driver.get("https://www.haberler.com");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Actions actions = new Actions(driver);
        for (int i = 1; i <= 25; i++) {
            String haber = ".swiper-pagination.swiper-pagination-bullets:nth-of-type(2)>a:nth-of-type("+i+")";
            actions.moveToElement(driver.findElement(By.cssSelector(haber))).perform();
            Thread.sleep(2000);
            js.executeScript("alert('Do you want to open this?')");


        }


    }
}
