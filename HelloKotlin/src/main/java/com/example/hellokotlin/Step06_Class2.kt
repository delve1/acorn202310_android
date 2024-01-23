package com.example.hellokotlin

class Person constructor(name:String){
    //필드 선언
    var name:String
    init {
        this.name=name
    }
}
//위의 코드를 줄이면 아래와 같다
//생성자에 정의한 매개변수의 모양 그대로 필드가 만들어지고 생성자에 전달한 값이 자동 저장된다
class Person2 (var name:String)
// var 과 val 의 차이는 수정 가능한 필드 와 수정 불가능한 필드의 차이이다
class Person3 (val name:String)

fun main(){
    val p1=Person("김구라")
    val p2=Person2("해골")
    val p3=Person3("원숭이")
}









