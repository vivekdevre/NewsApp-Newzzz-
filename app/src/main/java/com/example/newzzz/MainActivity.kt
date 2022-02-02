package com.example.newzzz

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View
import android.widget.AdapterView
import android.widget.Switch
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_homepage.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsItemClicked {
    private lateinit var mAdapter: NewsListAdapter
    var urlx:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recView.layoutManager = LinearLayoutManager(this)
        fetchData()
        mAdapter = NewsListAdapter(this)
        recView.adapter = mAdapter

        urlx=intent.getIntExtra("key1",0)
    }


    fun giveurl():String{
        urlx=intent.getIntExtra("key1",0)
        var ans:String=""

        when (urlx){
            1 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/general/in.json"
                    setTitle("General News")}
            2 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/business/in.json"
                    setTitle("Business News")}
            3 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/entertainment/in.json"
                    setTitle("Entertainment News")}
            4 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/health/in.json"
                    setTitle("Health News")}
            5 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/science/in.json"
                    setTitle("Science News")}
            6 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/sports/in.json"
                    setTitle("Sports News")}
            7 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/technology/in.json"
                    setTitle("Tech News")}
        }

        return ans
    }

    fun fetchData() {
        var url = giveurl()
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            {
                val newsJsonArray = it.getJSONArray("articles")
                val newsArray = ArrayList<News>()
                for(i in 0 until newsJsonArray.length()) {
                    val newsJsonObject = newsJsonArray.getJSONObject(i)
                    val news = News(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("author"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage")
                    )
                    newsArray.add(news)
                }

                mAdapter.updateNews(newsArray)
            },
            {

            }
        )
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }


    override fun onItemClicked(item: News) {
        val builder =  CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(item.url))
    }
}