package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.Set;

public class Frames {
    public static void main(String[] args) {

    }
}
class WindowSwitching{

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        switchBetweenMultiFramesPage(driver);

    }

    public static void iframeSwitching(WebDriver driver) throws InterruptedException, NoSuchSessionException {
        if(driver.toString().contains("null"))
            driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/iframe");
        WebElement Iframe = driver.findElement(By.cssSelector("#mce_0_ifr"));
        driver.switchTo().frame(Iframe);

        driver.findElement(By.cssSelector("body#tinymce")).clear();
        driver.findElement(By.cssSelector("body#tinymce")).sendKeys("Hello shit head");
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
        driver.quit();
        System.out.println(driver);
    }
    public static void switchTabs(WebDriver driver) throws InterruptedException {
        if(driver.toString().contains("null"))
            driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/windows");

        String currentHandle = driver.getWindowHandle();
        driver.findElement(By.cssSelector("div#content a")).click();
        Thread.sleep(3000);
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            if(!tab.equals(currentHandle)){
                driver.switchTo().window(tab);
                if(driver.findElements(By.xpath("//h3[text()='New Window']")).size()==1){
                    System.out.println("Switching between tabs is successful, now go back");
                }

            }
        }
        driver.quit();
    }

    public static void switchBetweenMultiFramesPage(WebDriver driver){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());
        driver.switchTo().parentFrame();
        //driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());

    }

}
