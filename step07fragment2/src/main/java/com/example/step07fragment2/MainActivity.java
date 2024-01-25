package com.example.step07fragment2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.step07fragment2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MyFragment.MyFragmentListener{
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

    @Override
    public void onTen(String msg) {
        binding.result.setText(msg);
    }
}





