package com.cbt.day16_homework;

import com.cbt.utilities.BrowserFactory;
import net.sourceforge.tess4j.Tesseract;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.InputMismatchException;

public class Hello {



    public static void main(String[] args) {
//        WebDriver driver = BrowserFactory.getDriver("chrome");
//        driver.get("https://mvnrepository.com/artifact/com.aspose/aspose-cloud-storage");
//        TakesScreenshot ss = (TakesScreenshot) driver;
        try{
            System.out.println(1/0);
        }finally{
            System.out.println("bye;");
        }


    }

}
