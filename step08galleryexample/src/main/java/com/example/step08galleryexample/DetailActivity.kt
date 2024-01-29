package com.example.step08galleryexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.step08galleryexample.databinding.ActivityDetailBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class DetailActivity : AppCompatActivity() {
    lateinit var binding:ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //MainActivity 에서 전달된 Gallery 의 pk 얻어내기
        var num = intent.getLongExtra("id", 0)

        lifecycleScope.launch(Dispatchers.Main){
            val url="http://192.168.0.39:9000/boot09/api/gallery/"+num
            // json 은 {} 형식의 문자열이다 (Gallery 하나의 정보)
            var json=makeHttpRequest(url)
            printToLayout(json)
        }
    }
    fun printToLayout(json:String){
        //json 은 {} 형식의 문자열이기 때문에 JSONObject() 객체를 생성한다.
        val obj=JSONObject(json)
        //작성자를 읽어와서 TextView 에 출력
        binding.writer.text = obj.getString("writer")
        //설명을 읽어와서 TextView 에 출력
        binding.caption.text = obj.getString("caption")
        //등록일을 읽어와서 TextView 에 출력
        binding.regdate.text = obj.getString("regdate")
        //이미지는 Glide 를 이용한다.
        Glide.with(this)
                .load("http://192.168.0.39:9000/boot09/upload/images/"+obj.getString("saveFileName"))
                .fitCenter()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.imageView)
    }

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
                val url= URL(url)
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








