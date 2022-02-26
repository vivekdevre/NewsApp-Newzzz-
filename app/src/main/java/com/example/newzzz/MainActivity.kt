package com.example.newzzz


import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
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
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
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
            10 ->
            { ans="https://saurav.tech/NewsAPI/top-headlines/category/general/in.json"
                title = "General News-India"
            }
            11 ->
            { ans="https://saurav.tech/NewsAPI/top-headlines/category/general/in.json"
                title = "General News-India"
            }
            12 ->
            { ans="https://saurav.tech/NewsAPI/top-headlines/category/general/us.json"
                title = "General News-USA"
            }
            13 ->
            { ans="https://saurav.tech/NewsAPI/top-headlines/category/general/au.json"
                title = "General News-Australia"
            }
            14 ->
            { ans="https://saurav.tech/NewsAPI/top-headlines/category/general/ru.json"
                title = "General News-Russia"
            }
            15 ->
            { ans="https://saurav.tech/NewsAPI/top-headlines/category/general/fr.json"
                title = "General News-France"
            }
            16 ->
            { ans="https://saurav.tech/NewsAPI/top-headlines/category/general/gb.json"
                title = "General News-UnitedKingdom"
            }
            20 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/business/in.json"
                    title = "Business News-India"
            }
            21 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/business/in.json"
                    title = "Business News-India"
            }
            22 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/business/us.json"
                    title = "Business News-USA"
            }
            23 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/business/au.json"
                    title = "Business News-Australia"
            }
            24 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/business/ru.json"
                    title = "Business News-Russia"
            }
            25 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/business/fr.json"
                    title = "Business News-France"
            }
            26 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/business/gb.json"
                    title = "Business News-UnitedKingdom"
            }
            30 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/entertainment/in.json"
                    title = "Entertainment News-India"
            }
            31 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/entertainment/in.json"
                    title = "Entertainment News-India"
            }
            32 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/entertainment/us.json"
                    title = "Entertainment News-USA"
            }
            33 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/entertainment/au.json"
                    title = "Entertainment News-Australia"
            }
            34 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/entertainment/ru.json"
                    title = "Entertainment News-Russia"
            }
            35 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/entertainment/fr.json"
                    title = "Entertainment News-France"
            }
            36 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/entertainment/gb.json"
                    title = "Entertainment News-UnitedKingdom"
            }
            40 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/health/in.json"
                    title = "Health News-India"
            }
            41 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/health/in.json"
                    title = "Health News-India"
            }
            42 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/health/us.json"
                    title = "Health News-USA"
            }
            43 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/health/au.json"
                    title = "Health News-Australia"
            }
            44 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/health/ru.json"
                    title = "Health News-Russia"
            }
            45 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/health/fr.json"
                    title = "Health News-France"
            }
            46 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/health/gb.json"
                    title = "Health News-UnitedKingdom"
            }
            50 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/science/in.json"
                    title = "Science News-India"
            }
            51 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/science/in.json"
                    title = "Science News-India"
            }
            52 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/science/us.json"
                    title = "Science News-USA"
            }
            53 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/science/au.json"
                    title = "Science News-Australia"
            }
            54 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/science/ru.json"
                    title = "Science News-Russia"
            }
            55 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/science/fr.json"
                    title = "Science News-France"
            }
            56 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/science/gb.json"
                    title = "Science News-UnitedKingdom"
            }
            60 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/sports/in.json"
                    title = "Sports News-India"
            }
            61 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/sports/in.json"
                    title = "Sports News-India"
            }
            62 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/sports/us.json"
                    title = "Sports News-USA"
            }
            63 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/sports/au.json"
                    title = "Sports News-Australia"
            }
            64 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/sports/ru.json"
                    title = "Sports News-Russia"
            }
            65 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/sports/fr.json"
                    title = "Sports News-France"
            }
            66 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/sports/gb.json"
                    title = "Sports News-UnitedKingdom"
            }
            70 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/technology/in.json"
                    title = "Tech News-India"
            }
            71 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/technology/in.json"
                    title = "Tech News-India"
            }
            72 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/technology/us.json"
                    title = "Tech News-USA"
            }
            73 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/technology/au.json"
                    title = "Tech News-Australia"
            }
            74 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/technology/ru.json"
                    title = "Tech News-Russia"
            }
            75 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/technology/fr.json"
                    title = "Tech News-France"
            }
            76 -> {ans="https://saurav.tech/NewsAPI/top-headlines/category/technology/gb.json"
                    title = "Tech News-UnitedKingdom"
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