package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class Method {
    public static void main(String[] args) {
        int[] x = {5, 9, 0, -1, 2, -80, 8, 6};
        bubbleSort(x);
        WebDriver driver = BrowserFactory.getDriver("chrome");
        SearchYoutube.search(driver,"The one that got away");
    }

    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < (length - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1]; //swap elements
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
}
