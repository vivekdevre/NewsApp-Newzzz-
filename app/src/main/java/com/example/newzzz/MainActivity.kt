package com.example.newzzz


import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsItemClicked {
    private lateinit var mAdapter: NewsListAdapter
    private var tempUrl:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recView.layoutManager = LinearLayoutManager(this)
        fetchData()
        mAdapter = NewsListAdapter(this)
        recView.adapter = mAdapter

        tempUrl=intent.getIntExtra("key1",0)
    }


    private fun giveUrl():String{
        tempUrl=intent.getIntExtra("key1",0)
        var ans =""

        when (tempUrl){
            1 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/general/in.json"
                    title = "General News"
            }
            2 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/business/in.json"
                    title = "Business News"
            }
            3 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/entertainment/in.json"
                    title = "Entertainment News"
            }
            4 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/health/in.json"
                    title = "Health News"
            }
            5 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/science/in.json"
                    title = "Science News"
            }
            6 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/sports/in.json"
                    title = "Sports News"
            }
            7 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/technology/in.json"
                    title = "Tech News"
            }
        }

        return ans
    }

    private fun fetchData() {
        val url = giveUrl()
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