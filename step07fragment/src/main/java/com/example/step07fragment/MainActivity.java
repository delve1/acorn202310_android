package com.example.step07fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.step07fragment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //view binding 객체를 필드에 저장해 놓고 사용하면 편리하다
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //액티비티의 화면에 전개된 프레그먼트의 참조값 얻어내기
        FragmentManager fm=getSupportFragmentManager();
        //MyFragment 의 참조값을 얻어와서
        MyFragment f1=(MyFragment) fm.findFragmentById(R.id.fragment1);
        MyFragment f2=(MyFragment) fm.findFragmentById(R.id.fragment2);

        //버튼에 클릭 리스너 등록
        binding.resetBtn.setOnClickListener(v->{
            //MyFragment 가 가지고 있는 리셋 메소드를 호출하기
            f1.reset();
            f2.reset();
        });
        binding.moveBtn.setOnClickListener(v->{
            startActivity(new Intent(this, SubActivity.class));
        });
    }
}









