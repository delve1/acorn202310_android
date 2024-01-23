package com.example.hellokotlin


fun main(){
    val num=10
    //변수나 상수 선언을 미리하고
    val result:String
    //조건부로 다른 값을 대입
    if(num%2 == 1){
        result="$num 은 홀수 입니다"
    }else{
        result="$num 은 짝수 입니다"
    }
    //3항 연산자?
    //val result2:String = num%2 == 1 ? "$num 은 홀수 입니다" : "$num 은 짝수 입니다"

    // 대입연산자의 우측에 if 문을 넣는 것이 가능하다
    // if 문이 어떤 data 를 해당 위치에 남기기도 한다
    // if 문이 남긴데이터(리턴해준 데이터)가 대입연산자를 통해서 변수에 대입된다
    val result3:String = if(num%2==1){ "$num 은 홀수 입니다" }else{ "$num 은 짝수 입니다" }
    // 실행할 code 블럭이 없다면 중괄호 생략 가능
    val result4:String = if(num%2==1) "$num 은 홀수 입니다" else "$num 은 짝수 입니다"

    val result5:String? = if(num%2==1) "$num 은 홀수 입니다" else null
}




