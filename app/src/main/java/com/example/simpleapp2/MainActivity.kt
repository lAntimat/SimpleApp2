package com.example.simpleapp2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        getNews()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NewsAdapter()

        adapter.setOnClickListener {
            val intent = Intent(applicationContext, DetailActivity::class.java)
            intent.putExtra("title", it.newsTitle)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }

    private fun generateFakeNews(): ArrayList<News> {
        val newsList = ArrayList<News>()
        for (i in 0..99) {
            val news = News("Hot news $i", "hothothothtothot")
            newsList.add(news)
        }
        return newsList
    }

    private fun getNews() {

        val okHttpClientBuilder = OkHttpClient.Builder()


        val okHttpClient = okHttpClientBuilder.build()

        val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(GitHubService::class.java)

        val call: Call<Object> = service.listRepos("lantimat")

        call.enqueue(object : Callback<Object> {
            override fun onResponse(call: Call<Object>, response: Response<Object>) {
                Log.d("onResponse", response.toString())

                val json = JSONArray(Gson().toJson(response.body()))
                val title = json.getJSONObject(0)?.getString("name") ?: ""
                val subtitle = json.getJSONObject(0)?.getString("full_name") ?: ""
                Log.d("title", title ?: "")


                val list = arrayListOf(News(title, subtitle))

                (recyclerView.adapter as NewsAdapter).addList(list)
                (recyclerView.adapter as NewsAdapter).notifyDataSetChanged()

            }

            override fun onFailure(call: Call<Object>, t: Throwable) {
                Log.d("onFailure", t.toString())
            }

        })

    }
}