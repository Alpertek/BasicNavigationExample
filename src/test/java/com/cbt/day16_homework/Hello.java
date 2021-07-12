package com.cbt.day16_homework;

import com.cbt.utilities.BrowserFactory;
import com.sun.corba.se.impl.io.TypeMismatchException;
import net.sourceforge.tess4j.Tesseract;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.InputMismatchException;

public class Hello {

    public static Object get(Object[] array,int index){
        return array[index];
    }
    public static String typeOf(Object object) {

        String type = object.getClass().getSimpleName();

        return type;
    }
    public static void main(String[] args) throws TypeMismatchException {
        Amount amount = addAmounts(new Amount("TL",1000),new Amount("TL",500));
        System.out.println(typeOf(amount));
        System.out.println(amount.amount);
        System.out.println(amount.currency);
    }
    static Amount addAmounts(Amount a1, Amount a2) throws TypeMismatchException {
        if(!a1.currency.equals(a2.currency)){
            throw new TypeMismatchException("Currencies are not the same");
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
