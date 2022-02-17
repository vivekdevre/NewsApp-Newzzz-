package com.example.newzzz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_homepage.*


class Homepage : AppCompatActivity() {
    private var tempMenuItemClicked: Int = 0

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.india -> {
                tempMenuItemClicked = 1
                true
            }
            R.id.usa -> {
                tempMenuItemClicked = 2
                true
            }
            R.id.australia->{
                tempMenuItemClicked = 3
                true
            }
            R.id.russia->{
                tempMenuItemClicked = 4
                true
            }
            R.id.france->{
                tempMenuItemClicked = 5
                true
            }
            R.id.uk->{
                tempMenuItemClicked = 6
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        General.setOnClickListener {
            var value = 10
            when(tempMenuItemClicked){
                1->value=11
                2->value=12
                3->value=13
                4->value=14
                5->value=15
                6->value=16

            }

            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }

        Business.setOnClickListener {
            var value = 20
            when(tempMenuItemClicked){
                1->value=21
                2->value=22
                3->value=23
                4->value=24
                5->value=25
                6->value=26
            }
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }

        Entertainment.setOnClickListener {
            var value = 30
            when(tempMenuItemClicked){
                1->value=31
                2->value=32
                3->value=33
                4->value=34
                5->value=35
                6->value=36
            }
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }

        Health.setOnClickListener {
            var value = 40
            when(tempMenuItemClicked){
                1->value=41
                2->value=42
                3->value=43
                4->value=44
                5->value=45
                6->value=46
            }
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }

        Science.setOnClickListener {
            var value = 50
            when(tempMenuItemClicked){
                1->value=51
                2->value=52
                3->value=53
                4->value=54
                5->value=55
                6->value=56
            }
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }

        Sports.setOnClickListener {
            var value = 60
            when(tempMenuItemClicked){
                1->value=61
                2->value=62
                3->value=63
                4->value=64
                5->value=65
                6->value=66
            }
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }

        Technology.setOnClickListener {
            var value = 70
            when(tempMenuItemClicked){
                1->value=71
                2->value=72
                3->value=73
                4->value=74
                5->value=75
                6->value=76
            }
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("key1",value)

            startActivity(intent)
        }
    }

}
