package com.example.exampleandroidcomponents

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TestBroadcastReceiverActivity : AppCompatActivity() {

    private lateinit var chargeReceiver: ChargeBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_broadcast)

        chargeReceiver = ChargeBroadcastReceiver()
    }

    override fun onStart() {
        super.onStart()
        val usbFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(chargeReceiver, usbFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(chargeReceiver)
    }

}