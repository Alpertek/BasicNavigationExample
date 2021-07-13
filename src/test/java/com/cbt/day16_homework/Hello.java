package com.cbt.day16_homework;

import com.cbt.utilities.BrowserFactory;
import com.sun.corba.se.impl.io.TypeMismatchException;
import net.sourceforge.tess4j.Tesseract;

import org.openqa.selenium.WebDriver;

import java.util.*;

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

        ArrayList<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<Integer>();

        list1.add(1);
        list1.add(5);
        list2.add(4);
        list2.add(6);
        ArrayList<List<Integer>> wordArrays = new ArrayList<List<Integer>>();
        wordArrays.add(list1);
        wordArrays.add(list2);
        System.out.println(wordArrays.get(0).get(0));
        System.out.println(wordArrays.get(0).get(1));
        System.out.println(wordArrays.get(1).get(0));
        System.out.println(wordArrays.get(1).get(1));

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
