package com.cbt.tests;

public class Test {
    int count = setCount(10);
    {
        count = setCount(5);
    }
    Test(){

    }

    public int setCount(int count){
        System.out.println("Test.count = " + this.count);
        this.count = count;
        System.out.println("Test.count = " + this.count);
        return count;
    }
}
class TestTest {
    public static void main(String[] args) {
        Test test = new Test();
    }
}



