package com.project.weekassignment.week2;

public class Person {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Person person = new Person();
            System.out.println(person);
            //C++ print와 동일
            //com.project.weekassignment.week2.Person@1fb3ebeb Peron==객체이름, @... == 각 객체별 주소
        }
    }
}
