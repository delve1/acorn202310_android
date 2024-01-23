package com.example.hellokotlin

fun main(){
    //1 ~ 10 까지 출력
    for(num in 1..10){
        println(num)
    }
    println("-----")
    //10 ~ 1 까지 출력
    for(num in 10 downTo 1){
        println(num)
    }
    println("-----")
    //1, 3, 5, 7, 9 ... 2씩 증가 시키면서 출력
    for(num in 1..10 step 2){
        println(num)
    }
    println("-----")
    //10, 8, 6 ... 2씩 감소 시키면서 출력
    for(num in 10 downTo 1 step 2){
        println(num)
    }
    val names= listOf("김구라", "해골", "원숭이", "주뎅이", "덩어리")
    //반복문 돌면서 역순으로 출력해 보세요.
    for(i in names.size-1 downTo 0){
        println(names[i])
    }
}






