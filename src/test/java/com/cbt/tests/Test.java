package com.cbt.tests;

public class Test {


}
class Test2 extends Test implements Walk{

    public static void main(String[] args) {
        
    }

}
interface Walk{
    static void main(String[] args) {
        System.out.println("Raise finger");
    }
    default int topla() throws InterruptedException {
        System.out.println(this.getClass().getName());
        return 0;
    }
}




