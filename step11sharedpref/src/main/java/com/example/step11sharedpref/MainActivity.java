package com.example.step11sharedpref;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
/*
    App 에서 문자열을 영구 저장하는 방법 (영구 저장이란 앱을 종료하고 다시 시작해도 불러올수 있는 문자열 )

    1. 파일 입출력을 이용해서 저장
    2. android 내장 data base 를 이용해서 저장  => SQLite DataBase
    3. SharedPreference 를 이용해서 저장 (느리지만 간단히 저장하고 불러 올수 있다)
       내부적으로 xml 문서를 만들어서 문자열을 저장하고 불러온다.
       저장된 문자열을 boolean, int, double, String type 으로 변환해서 불러 올수 있다.

 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //UI 의 참조값 얻어오기
        editText=findViewById(R.id.editText);
        Button saveBtn=findViewById(R.id.saveBtn);
        Button readBtn=findViewById(R.id.readBtn);
        //버튼에 리스너 등록하기
        saveBtn.setOnClickListener(this);
        readBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //눌러진 버튼의 아이디를 읽어와서
        int id=v.getId();

        //분기한다.
        if(id == R.id.saveBtn){
            //입력한 문자열
            String msg=editText.getText().toString();
            // info 라는 이름의 xml 문서를 만들 SharedPreferences 객체의 참조값 얻어오기
            SharedPreferences pref=getSharedPreferences("info", Context.MODE_PRIVATE);
            // 에디터 객체
            SharedPreferences.Editor editor=pref.edit();
            // 에디터 객체를 이용해서 저장하기
            editor.putString("msg", msg);
            editor.commit();

            new AlertDialog.Builder(this)
                    .setMessage("저장 했습니다")
                    .setNeutralButton("확인", null)
                    .create()
                    .show();
        }else if(id == R.id.readBtn){
            SharedPreferences pref=getSharedPreferences("info", Context.MODE_PRIVATE);
            // .getString( key 값, default 값 )
            String msg=pref.getString("msg", "");
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }

    }
    /*

        1. res => 마우스 우클릭 => new => Android Resource Directory => Resource type => menu
        선택해서 menu 폴더를 만든다
        2. menu 폴더에 마우스 우클릭 => new  => menu Resource file
        선택해서 menu_main xml 문서를 만든다.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //메뉴 전개자 객체를 이용해서 res/menu/menu_main.xml 문서를 전개해서
        //메뉴에 추가하기
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //위에서 구성된 메뉴중에 하나를 선택했을때 호출되는 메소드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //선택된 메뉴의 아이디 읽어오기
        int id=item.getItemId();
        //아이디를 이용해서 분기 한다
        if(id == R.id.setting){
            Intent i=new Intent(this, SettingsActivity.class);
            startActivity(i);
        }else if( id == R.id.one){

        }else if( id == R.id.two){

        }

        return super.onOptionsItemSelected(item);
    }
}

























