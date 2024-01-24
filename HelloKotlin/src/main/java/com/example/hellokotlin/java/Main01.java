package com.example.hellokotlin.java;

import com.example.hellokotlin.MyUtil;
import com.example.hellokotlin.OurUtil;
import com.example.hellokotlin.YourUtil;

public class Main01 {
    public static void main(String[] args) {
        //kotlin 으로 정의된 클래스도 import 해서 사용 가능 하다
        MyUtil util=new MyUtil();
        util.send();
        util.send(10);
        util.send(10, "hi");

        YourUtil util2=new YourUtil();
        //이런 모양의 메소드만 호출가능
        util2.send(20, "hello");

        OurUtil util3=new OurUtil();
        // send() 메소드에는 @JvmOverloads 어노테이션이 붙어 있기 때문에 java 에서 모든 모양의 메소드를 호출할수 있다
        util3.send();
        util3.send(30);
        util3.send(30, "bye");
    }
}
