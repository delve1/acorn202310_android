package com.example.step07fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/*
    하나의 액티비티는 여러개의 프레그먼트로 구성할수가 있다
    액티비티 제어하에 동작하는 미니 액티비티라고 생각하면 된다.
 */
public class MyFragment extends Fragment {
    //여기서 리턴해주는 View 객체가 MyFragment 가 차지하고 있는 영역에 체워진다
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_my, container, false);
    }
}