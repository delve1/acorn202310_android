package com.example.hellokotlin
/*
    Array  => 아이템 수정가능, 아이템 추가 불가
    List   => 아이템 수정불가, 이이템 추가 불가
    MuatableList => 아이템 수정가능, 아이템 추가 가능
 */
fun main(){
    //정수 배열(array) 객체 생성하기
    val nums:Array<Int> = arrayOf<Int>(10, 20, 30)
    val nums2:List<Int> = listOf<Int>(10, 20, 30)
    //문자 배열
    val names:Array<String> = arrayOf<String>("김구라", "해골", "원숭이")
    val names2:List<String> = listOf<String>("김구라", "해골", "원숭이")

    //nums 에 아이템을 추가 할수 있을까? 추가 불가

    //아이템 수정 가능
    nums[0]=100 //대입연산자를 이용해서 수정하거나
    nums.set(1, 200) //메소드를 이용해서 수정 가능

    // array 도 map, filter 함수 사용가능
    val result:List<Int> = nums.map {
        it*2
    }
    // forEach 함수도 사용가능
    nums.forEach {
        println(it)
    }

}