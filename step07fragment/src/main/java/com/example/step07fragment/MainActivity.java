package com.example.step07fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

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

        //버튼에 클릭 리스너 등록
        binding.resetBtn.setOnClickListener(v->{

        });
        binding.moveBtn.setOnClickListener(v->{

        });
    }
}









