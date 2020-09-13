package com.turman.and_guide.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.turman.and_guide.R
import kotlinx.coroutines.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class KotlinActivity : AppCompatActivity() {
    lateinit var adapter:ArrayAdapter<String>
    lateinit var listview:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        //findViewById<TextView>(R.id.textView).setOnClickListener { Toast.makeText(this, "textView1",Toast.LENGTH_SHORT).show() }

        listview = findViewById<ListView>(R.id.list)
        adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1)
        listview.adapter = adapter

        GlobalScope.launch(Dispatchers.IO) {
            Log.d("AA", "协程初始化完成，时间: " + System.currentTimeMillis())
            for (i in 1..3) {
                Log.d("AA", "协程任务1打印第$i 次，时间: " + System.currentTimeMillis())
            }
            delay(500)
            for (i in 1..3) {
                Log.d("AA", "协程任务2打印第$i 次，时间: " + System.currentTimeMillis())
            }
        }

//        Log.d("AA", "主线程 sleep ，时间: " + System.currentTimeMillis())
//        Thread.sleep(1000)
        Log.d("AA", "主线程运行，时间: " + System.currentTimeMillis())

        for (i in 1..3) {
            Log.d("AA", "主线程打印第$i 次，时间: " + System.currentTimeMillis())
        }

        GlobalScope.launch(Dispatchers.Unconfined){
            var token = GlobalScope.async(Dispatchers.Unconfined) {
                return@async requestToekn()
            }.await()

            var response = GlobalScope.async(Dispatchers.Unconfined) {
                return@async getResponse(token)
            }.await()

            findViewById<TextView>(R.id.textView).text = response
        }

        getPageData(1)
    }

    fun onClick(v: View?) {
        when (v?.id) {
            R.id.textView -> Toast.makeText(this, "textView1",Toast.LENGTH_SHORT).show()
            R.id.textView2 -> Toast.makeText(this, "textView2",Toast.LENGTH_SHORT).show()
            R.id.textView3 -> Toast.makeText(this, "textView3",Toast.LENGTH_SHORT).show()
        }
    }

    suspend fun requestToekn():String {
        return "token"
    }

    suspend fun getResponse(token:String):String {
        return "$token:response"
    }

    fun getPageData(page: Int) {
        GlobalScope.launch(Dispatchers.Unconfined) {
            var result = GlobalScope.async(Dispatchers.IO) {
                return@async getListData("https://apish.centanet.com/v3/zfapi_apush/json/reply/SearchStaffRequest?GScopeId=&MustHasPost=false&PageCount=10&OrderByCriteria=DefaultOrder&PageIndex=$page")
            }.await()

//            val sres = Gson().fromJson<ResponseBean<StaffBean>>(result, object : TypeToken<ResponseBean<StaffBean?>?>() {}.type)
            val sres = ResponseBean.getrs(result)

//            val arr = ArrayList<String>()
            if (sres.getResult()!=null) {
               val lis:ArrayList<StaffBean> = sres.getResult() as ArrayList<StaffBean>
                for (li in lis) {
                    adapter.add(li.cnName)
                }
            }
//
//            if (arr.size>0) {
//                adapter.addAll(arr)
//            }
        }
    }

    suspend fun getListData(strUrl:String):String {
        val url = URL(strUrl)
        var httpURLConnection = url.openConnection() as HttpURLConnection
        var resultBuffer = StringBuffer()
        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8")
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
        if (httpURLConnection.responseCode >= 300) throw Exception("HTTP Request is not success, Response code is ${httpURLConnection.responseCode}")
        val inputStream = httpURLConnection.inputStream
        val inputStreamReader = InputStreamReader(inputStream, "utf-8")
        val reader = BufferedReader(inputStreamReader)
        reader.use { r ->
            var temp = r.readLine()
            if (temp != null) resultBuffer.append(temp)
        }
        reader.close()
        inputStreamReader.close()
        inputStream.close()
        return resultBuffer.toString()
    }
}