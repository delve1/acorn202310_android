package com.example.hellokotlin

// kotlin 에서 인터페이스 만들기
interface Remocon{
    fun up()
    fun down()
}

//인터페이스를 구현한 클래스 만들기
class MyRemocon : Remocon{
    override fun up() {
        println("무언가를 올려요")
    }
    override fun down() {
       println("무언가를 내려요")
    }
    fun move(){
        println("움직여요")
    }
}

fun main(){
    val r1:MyRemocon = MyRemocon()
    val r2:Remocon = MyRemocon()

    //r1 은 MyRemocon type 이기 때문에 모든  move() 메소드도 사용가능
    r1.up()
    r1.down()
    r1.move()

    //r2 는 Remocon type 이기 때문에 up(), down() 메소드만 사용할수 있다.
    r2.up()
    r2.down()

    // in java  (MyRemocon)r2
    // in kotlin   r2 as MyRemocon
    val r3:MyRemocon = r2 as MyRemocon //kotlin 의 type casting
    r3.move()

    // in java : r2 instanceof MyRemocon
    // in kotlin : r2 is MyRemocon
    if( r2 is MyRemocon){
        //smart casting  형변환 없이 바로 MyRemocon 의 기능을 사용할수 있다.
        r2.move()
    }
}




