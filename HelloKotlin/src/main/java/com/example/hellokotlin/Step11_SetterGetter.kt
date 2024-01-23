package com.example.hellokotlin

class StarBucks{
    var location:String? = null
        //필드에 값을 대입할때 호출되는 함수
        set(value) {
            //value 는 필드에 대입할 값이고 field 는 실제 필드를 가리킨다
            field=value+"지점"
        }
        //필드의 값을 참조할때 호출되는 함수 (여기서 리턴한 값이 참조되는 값이 된다)
        get() {
            if(field==null){
                return "지점명 없음"
            }else{
                return field
            }
        }

    fun showInfo(){
        println(location)
    }
}

fun main(){
    val s1=StarBucks()
    s1.location = "강남역"
    s1.showInfo()

    val s2=StarBucks()
    s2.showInfo()
    println(s2.location)

}