package com.example.step08example

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.step08example.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var notices:MutableList<String>
    lateinit var adapter:ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //view binding 을 이용해서 화면 구성
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //모델
        notices= mutableListOf<String>()
        //ListView 에 연결할 아답타
        adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, notices)
        //ListView 에 아답타 연결하기
        binding.listView.adapter=adapter

        binding.getBtn2.setOnClickListener {
            val url="http://192.168.0.39:9000/boot09/api/galleries"
            lifecycleScope.launch(Dispatchers.Main) {
                val json=makeHttpRequest(url)
                printToListView2(json)
            }
        }

        //버튼에 리스너 등록
        binding.getBtn.setOnClickListener{
            val url="http://192.168.0.39:9000/boot09/api/notices"
            lifecycleScope.launch(Dispatchers.Main) {
                //요청을 하고 json 문자열을 결과로 받아오기
                val json=makeHttpRequest(url)
                //테스트로 Toast 로 띄워보기

                Toast.makeText(this@MainActivity, json, Toast.LENGTH_LONG).show()
                printToListView(json)

            }
        }
    }
    fun printToListView2(json:String){
        // [] 형식의 문자열이기 때문에 JSONArray 객체를 생성한다
        val arr=JSONArray(json)
        for(i in 0 until  arr.length()){
            // [ ] 안에 {} 가 들어 있는 형태 이기 때문에 .getJSONObject(인덱스) 이다
            val tmp:JSONObject = arr.getJSONObject(0);
            // {"num":x , "writer":"xxx", "caption":"xxx" ... }
            val num=tmp.getInt("num")
            val writer=tmp.getString("writer")
            val caption=tmp.getString("caption")
            notices.add("번호:$num 작성자:$writer 설명:$caption")
        }
        adapter.notifyDataSetChanged()
    }

    fun printToListView(json:String){
        // [] 형식의 문자열이기 때문에 JSONArray 객체를 생성한다
        val arr=JSONArray(json)
        //반복문 돌면서
        for( i in 0 until arr.length()){
            // i 번째 문자열 추출
            val tmp=arr.getString(i)
            //모델에 아이템 추가하기
            notices.add(tmp)
        }
        //모델에 변경이 생겼다고 아답타에 알려서 ListView 가 업데이트 되도록 한다.
        adapter.notifyDataSetChanged()
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










