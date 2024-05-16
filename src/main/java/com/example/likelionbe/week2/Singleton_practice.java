package com.example.likelionbe.week2;

//싱글톤패턴은 여러개의 쓰레드가 동시에 하나의 객체에 접근한다고 가정했을때 동시성문제가 발생할
//수 있다. 그래서

import jakarta.transaction.Synchronization;

class Singleton
{
    private static Singleton singleton;
    private int num1;
    private Singleton()
    {
        num1 = 10;
    }
    public static synchronized Singleton getSingleton()//싱글톤 synchronized이용으로 동시성 해결
    {
        if(singleton == null)
        {
            singleton = new Singleton();
        }
        return singleton;
    }
    public int getNum()
    {
        return num1;
    }

}
public class Singleton_practice {
    public static void main(String[]args)
    {
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();
        System.out.println(singleton1.getNum());
        System.out.println(singleton2.getNum());
    }

}
