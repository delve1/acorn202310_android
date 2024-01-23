package com.example.hellokotlin

fun main(){
    //테스트용 클래스
    class Member{
        var num:Int?=null
        var name:String?=null
        var isMan:Boolean?=null
        fun showInfo(){
            println("${this.num} , ${this.name}, ${this.isMan}")
        }
    }

    val m1 = Member().apply {
        num=1
        name="김구라"
        isMan=true
        showInfo()
        // apply 는 this 를 리턴해준다
    }
    // with 를 apply 처럼 사용해보기 (이렇게 사용하지는 않는다)
    val m2 = with(Member()){
        num=1
        name="김구라"
        isMan=true
        showInfo()
        this //with 는 가장 마지막 라인에 있는 값이 리턴된다.
    }
}