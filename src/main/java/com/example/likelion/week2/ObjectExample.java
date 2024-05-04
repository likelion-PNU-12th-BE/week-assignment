package com.example.likelion.week2;

public class ObjectExample {

    public static void main(String[] args) {
        People people = new People("박주은", 25);
        
        for (int i = 0; i < 100; i++) {
            People people1 = new People("박주은", 25);
            System.out.println("people1 = " + people1);
        }
        
    }
}
