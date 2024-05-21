package com.example.likelionbe.week2.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Banana_Sales_Man implements Sales_Man{

    private int Money;
    private int Product_Price;
    private Storages storages;

    @Autowired
    public Banana_Sales_Man( @Qualifier("Banana_Storages") Storages storages)
    {
        this.Money = 10;
        this.Product_Price = 10;
        this.storages = storages;
    }
    @Override
    public void Product_sales(int num) {
        if(storages.Quantity_available(num))
        {
            storages.TakeOut_thing(num);
            storages.check_logistics();
            Get_Money(Product_Price*num);
        }
        else {
            System.out.println("현재 수량이 부족해 판매가 불가능합니다.");
            storages.check_logistics();
        }


    }

    @Override
    public void Get_Money(int num) {
        this.Money = this.Money+num;
        System.out.println("현재 가지고 있는 돈은"+Money+"입니다");
    }

    @Override
    public void Product_Recharge(int num) {
        storages.insert_thing(num);
        storages.check_logistics();
    }

    @Override
    public void Produt_Detail() {
        System.out.println("현재 바나나 가격은"+Product_Price+"입니다");
    }
}
