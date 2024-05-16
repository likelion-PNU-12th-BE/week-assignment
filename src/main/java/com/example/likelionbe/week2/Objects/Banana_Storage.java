package com.example.likelionbe.week2.Objects;

public class Banana_Storage implements Storages{

    int Banana_num;

    public Banana_Storage()
    {
        Banana_num = 0;
    }

    @Override
    public void TakeOut_thing(int get_num) {
        this.Banana_num = this.Banana_num - get_num;
        if(Quantity_available(get_num))
        {
            System.out.println("바나나를" + get_num + "만큼 꺼낼수 없습니다.");
            this.Banana_num = this.Banana_num + get_num;
            System.out.println("현재 바나나는" + this.Banana_num + "만큼 들어있습니다.");
        }
        else {
            System.out.println("바나나를" + get_num + "만큼 꺼냈습니다.");
        }

    }

    @Override
    public void insert_thing(int insert_num) {
        this.Banana_num = this.Banana_num - insert_num;
        System.out.println("바나나를" + insert_num + "만큼 넣었습니다.");
    }

    @Override
    public void check_logistics() {
        System.out.println("현재 바나나는" + this.Banana_num + "만큼 들어있습니다.");
    }

    @Override
    public boolean Quantity_available(int num) {
        if(this.Banana_num - num <0)
        {
            return false;
        }
        else {
            return true;
        }
    }

}
