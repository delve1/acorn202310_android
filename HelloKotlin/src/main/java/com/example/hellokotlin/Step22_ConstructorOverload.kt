package com.example.hellokotlin

//생성자 여러개 만들기
class MyData{
    constructor()
    constructor(num:Int)
    constructor(num:Int, name:String)
}

class YourData{
    //매개 변수에 기본값을 설정하면 다중 정의된 효과를 낼수 있다.
    constructor(num:Int=0, name:String="")
}

class YourData2{
    //매개 변수에 기본값을 설정하면 다중 정의된 효과를 낼수 있다.
    @JvmOverloads constructor(num:Int=0, name:String="")
}

data class OurData @JvmOverloads constructor(var num:Int=0, var name:String="")
fun main(){
    //다양한 모양으로 객체를 생성할수 있다.
    val a = MyData()
    val b = MyData(1)
    val c = MyData(1, "김구라")
    //YourData 도 다양한 모양으로 객체를 생성할수 있다.
    val d = YourData()
    val e = YourData(2)
    val f = YourData(2, "해골")

    val g = OurData()
    val h = OurData(3)
    val i = OurData(3, "원숭이")

}















