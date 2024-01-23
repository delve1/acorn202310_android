package com.example.hellokotlin

// read only List<Int>
val nums2 = listOf(1,2,3,4,5,6,7,8,9,10)

fun main(){
    //nums2 에서 5 보다 큰 item 만 남겨진 새로운 List 얻어내기
    val result=nums2.filter {
        it > 5
    }
    // nums2 의 모든 item 에 2를 곱한후 5 보다 큰 item 만 남겨진 새로운 List 얻어내기
    val result2=nums2.map { it*2 }.filter { it>5 }
}