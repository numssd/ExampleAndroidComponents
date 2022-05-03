package com.example.exampleandroidcomponents

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.SimpleCursorAdapter
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_test_content_provider.*

class TestContentProviderActivity : AppCompatActivity() {

    private var contactList = listOf(
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,
        ContactsContract.CommonDataKinds.Phone._ID
    ).toTypedArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_content_provider)

        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, Array(1){Manifest.permission.READ_CONTACTS
            },121)
        }
        else
            readContact()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode==121 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            readContact()
        }
    }

    private fun readContact() {

        val from = listOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER).toTypedArray()
        val to = intArrayOf(android.R.id.text1,android.R.id.text2)

        val rs= contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,contactList,
            null,null,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)

        val adapter =SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,rs,from,to,0)

        listview.adapter = adapter

    }
}