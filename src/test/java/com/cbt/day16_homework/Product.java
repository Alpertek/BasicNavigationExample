package com.cbt.day16_homework;


import java.util.*;

public class Product implements Comparable<Product>{
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Product anotherProduct) {
        if(this.price>anotherProduct.price){
            return 1;
        }else if(this.price==anotherProduct.price){
            return 0;
        }else {
            return -1;
        }
    }
}
 class Study{
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Product p1 = new Product("Apple",2500.9);
        Product p2 = new Product("Microsoft",2000);
        Product p3 = new Product("IBM",2501);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        System.out.println(products);
        Collections.sort(products);
        System.out.println(products);
    }
}
class Trial extends Study{

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.set(0,55);
        list.addLast(5000);
        list.addLast(5000);
        System.out.println(list);
        System.out.println(list.getFirst());
        System.out.println("Integer.compare(list.getFirst(),list.getLast()) = " + Integer.compare(list.getFirst(), list.getLast()));
        System.out.println("Integer.compare(list.getLast(), list.getFirst()) = " + Integer.compare(list.getLast(), list.getFirst()));

    }

}
