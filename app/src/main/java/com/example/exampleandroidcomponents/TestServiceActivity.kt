package com.example.exampleandroidcomponents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_test_service.*


class TestServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_service)

        buttonStart.setOnClickListener {
            ForegroundService.startService(this, getString(R.string.message_service))
        }

        buttonStop.setOnClickListener {
            ForegroundService.stopService(this)
        }

    }
}