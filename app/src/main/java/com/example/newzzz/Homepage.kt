package com.example.newzzz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_homepage.*


class Homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        General.setOnClickListener {
            val value = 1
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }

        Business.setOnClickListener {
            val value = 2
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }

        Entertainment.setOnClickListener {
            val value = 3
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }

        Health.setOnClickListener {
            val value = 4
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }

        Science.setOnClickListener {
            val value = 5
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }

        Sports.setOnClickListener {
            val value = 6
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }

        Technology.setOnClickListener {
            val value = 7
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }
    }
}
