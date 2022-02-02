package com.example.newzzz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_homepage.*
import kotlinx.android.synthetic.main.activity_homepage.view.*

class homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var urlx:String=""
        setContentView(R.layout.activity_homepage)

        General.setOnClickListener {
            var value:Int = 1
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }

        Business.setOnClickListener {
            var value:Int = 2
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }

        Entertainment.setOnClickListener {
            var value:Int = 3
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }

        Health.setOnClickListener {
            var value:Int = 4
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }

        Science.setOnClickListener {
            var value:Int = 5
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }

        Sports.setOnClickListener {
            var value:Int = 6
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }

        Technology.setOnClickListener {
            var value:Int = 7
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }


    }

}
