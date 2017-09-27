package com.apps.sam.newsexample.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.apps.sam.newsexample.R
import kotlinx.android.synthetic.main.activity_message.*

class MessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        txtId.text = intent.getStringExtra("id")
                ?: throw IllegalStateException("field id missing in Intent")
        txtType.text = intent.getStringExtra("type")
                ?: throw java.lang.IllegalStateException("field type missing in Intent")
        txtMessage.text = intent.getStringExtra("message")
                ?: throw java.lang.IllegalStateException("field message missing in Intent")
    }
}
