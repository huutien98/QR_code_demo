package com.example.scannerqrdemo

import android.R.attr.label
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        actionBar?.hide()

        val bundle = intent.extras
        val dataQr = bundle?.getString("dataQR")
        val dataQr_Image = bundle?.getString("dataQR_Image")

        text_value.text = dataQr
        text_value.text = dataQr_Image


        btn_back.setOnClickListener {
            finish()
        }

        btn_copy.setOnClickListener {
            val clipboard: ClipboardManager =
                getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText(label.toString(),dataQr)
            clipboard.setPrimaryClip(clip)

            Toast.makeText(this,"đã copy vào bộ nhớ đệm",Toast.LENGTH_LONG).show()
        }
    }
}