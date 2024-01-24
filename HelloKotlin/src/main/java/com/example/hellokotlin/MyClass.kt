package com.example.hellokotlin

/*
    [ kotlin 기본 data type ]
    - import 없이 바로 사용할수 있는 data type

    Byte, Short, Int, Long
    Float, Double
    Boolean, Char
    String
 */

fun main(){
    println("Hello, World!")
    /*
        var 이라는 예약어는 변수를 만들때 사용한다.
     */
    //정수를 담을수 있는 num 이라는 이름의 변수를 만들어서 10 대입하기
    var num:Int = 10
    //실수를 담을수 있는 num2 라는 이름의 변수를 만들어서 10.1 대입하기
    var num2:Double = 10.1
    //문자열을 담을수 있는 myName 이라는 이름의 변수를 만들어서 "김구라" 대입하기
    var myName:String = "김구라"

    //num 은 변수(var) 라서 값 변경 가능
    num = 11

    //val 은 상수를 만들때 사용하는 예약어다
    val num3:Int = 20 // 값이 한번 결정되면 변경 불가
    //num3 = 21 //변경불가

    // type 추론이 가능한 경우 type 은 생략 가능!
    var num4=10
    var num5=10.1
    var yourName="해골"

    //변수를 미리 선언하고
    var num6:Int
    //값을 나중에 넣을수도 있다
    num6=10

    //상수도 미리 선언하고
    val PI:Float
    //값을 나중에 대입할수 있다
    PI=3.14f

}











