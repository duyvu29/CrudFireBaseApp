package com.example.crudfirebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnInsert: Button
    lateinit var btnFetch : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mapping()
        event()

    }

    private fun event() {
        btnInsert.setOnClickListener {
            var intent = Intent(this, InsrtActivity::class.java)
            startActivity(intent)
        }
        btnFetch.setOnClickListener {
            var i = Intent(this, FetchActivity::class.java)
            startActivity(i)
        }

    }

    private fun mapping() {
        btnInsert = findViewById(R.id.btnInsertData)
        btnFetch    = findViewById(R.id.btnFetchData)
    }


}