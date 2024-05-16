package com.example.likelionbe.week2;


import com.example.likelionbe.week2.Objects.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Application {

    @Bean
    public Storages Banana_Storages(){
        return new Banana_Storage();
    }
    @Bean
    public Storages Apples_Storages(){
        return new Apple_Storage();
    }
    @Bean
    public Sales_Man Banana_SalesMan(){
        return new Banana_Sales_Man(Moneys(),3,Banana_Storages());
    }
    @Bean
    public Sales_Man Apple_SalesMan(){
        return new Apple_Sales_Man(Moneys(), 5, Apples_Storages());
    }
    @Bean
    public int Moneys(){
        return 0;
    }

}
