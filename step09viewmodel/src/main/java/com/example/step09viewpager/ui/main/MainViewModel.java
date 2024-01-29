package com.example.step09viewpager.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    //수정가능한 라이브 데이타
    private final MutableLiveData<String> info;
    //생성자
    public MainViewModel(){
        //객체 생성해서 참조값을 필드에 담기
        info=new MutableLiveData<>();
        info.setValue("변경될 예정인 문자열 초기값");
    }
    //라이브 데이터를 수정해 주는 메소드
    public void setData(String msg){
        info.setValue(msg);
    }

    //라이브 데이터(ReadOnly)를 리턴하는 메소드 (외부에서 수정 불가능하도록)
    public LiveData<String> getData(){

        return info;
    }
}






