package com.cbt.day16_homework;

import com.cbt.utilities.BrowserFactory;
import com.sun.corba.se.impl.io.TypeMismatchException;
import net.sourceforge.tess4j.Tesseract;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.InputMismatchException;

public class Hello {



    public static void main(String[] args) throws InputMismatchException {
        addAmounts(new Amount("TL",1000),new Amount("EURO",500));

    }
    static Amount addAmounts(Amount a1, Amount a2) throws InputMismatchException {
        if(!a1.currency.equals(a2.currency)){
            throw new InputMismatchException("Currencies are not the same");
        }
        return new Amount(a1.currency,a1.amount + a2.amount);

    }
    static class Amount{
        String currency;
        int amount;
        Amount(String currency,int amount){
            this.currency = currency;
            this.amount = amount;
        }
    }

}
