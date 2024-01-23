package com.example.hellokotlin

//sample data

// read only List<Int>
val nums = listOf(1,2,3,4,5,6,7,8,9,10)

fun main(){
    // List 에 저장된 모든 아이템을 순서대로 참조해서
    nums.forEach(fun(item){
        //원하는 작업 하기
        println(item)
    })
    //위의 code 를 좀더 간략히 하면
    nums.forEach{
        println(it)
    }
    //nums 배열을 이용해서 모든 item 에 2 를 곱한 새로운 배열 얻어내기
    val result=nums.map(fun(item):Int{
        return item*2
    })
    //위의 code 를 좀더 간략히 하면
    val result2=nums.map{
        it*2
    }
}









