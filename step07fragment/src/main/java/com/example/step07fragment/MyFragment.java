package com.example.step07fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/*
    하나의 액티비티는 여러개의 프레그먼트로 구성할수가 있다
    액티비티 제어하에 동작하는 미니 액티비티라고 생각하면 된다.
 */
public class MyFragment extends Fragment {
    //필드
    int count=0;
    TextView textView;
    //여기서 리턴해주는 View 객체가 MyFragment 가 차지하고 있는 영역에 체워진다
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // res/layout/fragment_my.xml 문서를 전개해서 View 만들기
        View view=inflater.inflate(R.layout.fragment_my, container, false);
        // 만들어진 View 에서 TextView 의 참조값 찾아오기
        textView = view.findViewById(R.id.textView);
        //TextView 에 클릭 리스너 등록
        textView.setOnClickListener(v->{
            //TextView 를 클릭했을때 count 값을 1 증가 시키고
            count++;
            //TextView 에 출력하기
            textView.setText(Integer.toString(count));
        });
        return view;
    }

    //리셋 하는 메소드
    public void reset(){
        //카운트 초기화
        count=0;
        //TextView 에 0 을 출력한다.
        textView.setText("0");
    }
}






