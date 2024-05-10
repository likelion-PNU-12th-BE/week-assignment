package com.example.weekassignment.week3;


//한글 깨짐 이슈
public class logging {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("logging 로깅 !!");
            System.err.println("error 에러 !!");
        }
    }
}

