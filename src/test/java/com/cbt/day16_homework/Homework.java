package com.cbt.day16_homework;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class Homework {
    public static void main(String[] args) {
        String folderPath = System.getProperty("user.dir");
        System.out.println("folderPath = " + folderPath);
        String filePath = "/src/test/resources/text.txt";
        String file = folderPath + filePath;
        filePath = "/src/test/java/textfile.txt";
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("");
    }
}
