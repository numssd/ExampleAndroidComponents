package com.example.exampleandroidcomponents

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.widget.Toast

class ChargeBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val status: Int = intent?.getIntExtra(BatteryManager.EXTRA_STATUS, -1) ?: -1
        status == BatteryManager.BATTERY_STATUS_CHARGING
                || status == BatteryManager.BATTERY_STATUS_FULL

        val chargePlug: Int = intent?.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1) ?: -1
        val usbCharge: Boolean = chargePlug == BatteryManager.BATTERY_PLUGGED_USB
        val acCharge: Boolean = chargePlug == BatteryManager.BATTERY_PLUGGED_AC

        when {
            usbCharge -> {
                Toast.makeText(context, context?.getString(R.string.usb_charging_text), Toast.LENGTH_LONG).show()
            }
            acCharge -> {
                Toast.makeText(context, context?.getString(R.string.ac_charging_text), Toast.LENGTH_LONG).show()
            }
            else -> {
                Toast.makeText(context, context?.getString(R.string.not_charging_text), Toast.LENGTH_LONG).show()
            }
        }
    }
}