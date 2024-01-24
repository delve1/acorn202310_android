package com.example.hellokotlin.java;

import com.example.hellokotlin.MyData;
import com.example.hellokotlin.OurData;
import com.example.hellokotlin.YourData;
import com.example.hellokotlin.YourData2;

public class Main02 {
    public static void main(String[] args) {
        //다양한 모양으로 MyData() 객체를 생성할수 있다.
        MyData d1=new MyData();
        MyData d2=new MyData(10);
        MyData d3=new MyData(10, "김구라");

        // @JvmOverloads 되어 있지 않아서 아래와 같은 생성자만 호출 가능하다
        YourData d4=new YourData(20, "해골");

        // @JvmOverloads 되어 있기 때문에 다양한 모양의 생성자를 호출 가능하다
        YourData2 d5=new YourData2();
        YourData2 d6=new YourData2(30);
        YourData2 d7=new YourData2(30, "원숭이");

        OurData d8=new OurData();
        OurData d9=new OurData(40);
        OurData d10=new OurData(40, "덩어리");

    }
}







