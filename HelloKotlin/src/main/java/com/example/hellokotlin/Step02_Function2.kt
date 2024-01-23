package com.example.hellokotlin

// 함수 type 을 전달받는 함수를 정의 해 보자

fun useFun(a:()->Unit){
    //매개 변수 a 에 전달된 함수 호출
    a()
}

//메인 메소드
fun main(){
    //useFun() 함수를 호출해 보세요
    useFun(fun(){
        println("오잉?")
    })
    //fun() 생략 가능
    useFun({
        println("오잉??")
    })
    //함수를 호출하는 표현식 ( ) 생략 가능
    useFun{
        println("오잉???")
    }
}