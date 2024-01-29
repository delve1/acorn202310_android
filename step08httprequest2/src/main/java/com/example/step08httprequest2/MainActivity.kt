package com.example.step08httprequest2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.step08httprequest2.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //binding.getRoot()

        //요청 버튼 눌렀을때 동작
        binding.requestBtn.setOnClickListener{
            //입력한 url 읽어오기
            val url=binding.inputUrl.text.toString(); //.getText().toString()
            //kotilin 의 coroutine 의 기능을 이용해서 요청 처리하기
            // 액티비티의 생명주기 안에서만 동작하는 작업시작
            lifecycleScope.launch(Dispatchers.Main){
                val result = makeHttpRequest(url)
                //결과 문자열을 EditText 에 출력하기
                binding.editText.setText(result)
            }

        }
    }

    // suspend fun  =>  리턴되는데 시간이 걸릴 가능성이 있는 함수
     suspend fun makeHttpRequest(url:String):String{
        /*
            IO(InputOutput) 입출력 처리를 하기에 적합한 스레드를 시작 시켜서 작업을한다.
            withContext(){} 블럭 내부는 UI 스레드가 아니다.
            블럭의 가장 아랬부분에 남긴 값이 리턴된다.
         */
        val result = withContext(Dispatchers.IO){
            //여기도 새로운 스레드 
            //문자열을 누적할 객체
            //StringBuilder builder=new StringBuilder();
            val builder=StringBuilder()
            try {
                //요청 url 을 생성자의 인자로 전달하면서 URL 객체를 생성한다
                val url=URL(url)
                //URLConnection 객체를 원래 type (자식 type) 으로 casting 해서 받는다.
                val conn=url.openConnection() as HttpURLConnection
                if(conn != null){
                    //conn.setConnectTimeout(20000) //응답을 기다리는 최대 대기 시간
                    conn.connectTimeout=20000
                    //conn.setRequestMethod("GET")// 요청 메소드 설정 (Default 는 GET)
                    conn.requestMethod="GET"
                    //conn.setUseCaches(false)//케쉬 사용 여부
                    conn.useCaches=false
                    //응답 코드를 읽어온다.
                    //int responseCode=conn.getResponseCode();
                    val responseCode=conn.responseCode;
                    if(responseCode == HttpURLConnection.HTTP_OK) { //정상 응답이라면 (200)
                        //문자열을 읽어들일수 있는 객체의 참조값 얻어오기
                        val br= BufferedReader(InputStreamReader(conn.inputStream))
                        //반복문 돌면서
                        while(true){
                            //문자열을 한줄씩 읽어 들인다.
                            val line=br.readLine();
                            if(line==null)break;
                            //StringBuilder 객체에 누적 시키기
                            builder.append(line);
                        }
                    }
                }
            }catch(e : Exception){
                e.message?.let { Log.e("MainActivity", it) }
            }
            //누적된 문자열이 리턴된다.
            builder.toString()
        }
        return result
    }
}






