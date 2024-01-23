package com.example.hellokotlin

fun main(){
    // read only  문자열 List
    val names = listOf<String>("김구라", "해골", "원숭이")
    // read only  숫자 List
    val nums = listOf<Int>(10, 20, 30)
    //names List 의 0 번 index 참조하는 방법1
    val a=names.get(0)
    //names List 의 0 번 index 참조하는 방법2
    val b=names[0]
    //names 의 item 갯수 참조
    val c=names.size
    //names 의 마지막 인덱스 참조
    val d=names.lastIndex
    //List 의 모든 item 을  순회 하면서 참조
    names.forEach{
        println(it) // it 일는 키워드로 각각의 아이템을 가리킬수 있다.
    }
    //인덱스가 같이 필요 하다면
    for(i in names.indices){
        val tmp=names.get(i)
        println("${i} 번째 인덱스 : ${tmp}")
    }
    //역순으로 순회하기
    for(i in names.lastIndex downTo 0){
        val tmp=names.get(i)
        println("${i} 번째 인덱스 : ${tmp}")
    }
}






