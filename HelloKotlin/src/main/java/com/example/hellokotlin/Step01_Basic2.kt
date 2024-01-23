package com.example.hellokotlin
/*
    kotlin 에서 배열(List)과 반복문
 */

fun main(){
    //수정 불가능한 List ( read only )
    val names:List<String> = listOf<String>("kim", "lee", "park")
    //type 추론이 가능하기 때문에 상수의 type 생략가능
    val animals=listOf<String>("dog", "cat", "elephant")
    //listOf( ) 안에 있는 데이터가 추론 가능 하기때문에 listOf 의 Generic 도 생략 가능
    val nums=listOf(10,20,30)

    //배열 참조
    println(names[0])
    println(names[1])
    println(names[2])
    println("-------")
    println(names.get(0))
    println(names.get(1))
    println(names.get(2))

    // read only 이기때문에 수정 불가
    //names[0]="김구라"

    val result=names.indices

    //반복문
    for(i in names.indices){
        println(i)
    }
    println("-----")
    for(i in names.indices){
        println("$i : ${names[i]}")
    }
    println("-----")
    for(item in names){
        println(item)
    }
    println("-----")
    names.forEach(fun(item){
        println(item)
    })
    println("-----")
    names.forEach{
        println(it)
    }
}









