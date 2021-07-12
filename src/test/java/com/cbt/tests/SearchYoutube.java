package com.cbt.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class SearchYoutube {

    public static void search(WebDriver driver,String searchString){
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("ytd-app input#search")).sendKeys(searchString + Keys.ENTER);

        List<WebElement> videos = driver.findElements(By.cssSelector("#meta #title-wrapper #video-title"));
        int count = 1;
        for (WebElement video : videos) {
            System.out.println(count+". result :");
            System.out.println(video.getAttribute("title"));
            System.out.println(video.getAttribute("href"));
            count++;
        }

    }

}
