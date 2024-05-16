package com.example.likelionbe.week2.Objects;

public class Apple_Storage implements Storages{

    int Apple_num;
    public Apple_Storage()
    {
        Apple_num = 0;
    }
    @Override
    public void TakeOut_thing(int get_num) {
        this.Apple_num = this.Apple_num - get_num;
        if(Quantity_available(get_num))
        {
            System.out.println("바나나를" + get_num + "만큼 꺼낼수 없습니다.");
            this.Apple_num = this.Apple_num + get_num;
            System.out.println("현재 바나나는" + this.Apple_num + "만큼 들어있습니다.");
        }
        else {
            System.out.println("바나나를" + get_num + "만큼 꺼냈습니다.");
        }
    }

    @Override
    public void insert_thing(int insert_num) {
        this.Apple_num = this.Apple_num - insert_num;
        System.out.println("바나나를" + insert_num + "만큼 넣었습니다.");
    }

    @Override
    public void check_logistics() {
        System.out.println("현재 바나나는" + this.Apple_num + "만큼 들어있습니다.");
    }

    @Override
    public boolean Quantity_available(int num) {
        if(this.Apple_num - num <0)
        {
            return false;
        }
        else {
            return true;
        }
    }
}
