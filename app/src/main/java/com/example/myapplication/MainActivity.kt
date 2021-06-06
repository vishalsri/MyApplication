package com.example.myapplication

import android.app.Activity
import android.graphics.Color
import android.widget.EditText
import android.widget.TextView
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : Activity() {

    var b1: Button? = null
    var b2: Button? = null
    var ed1: EditText? = null
    var ed2: EditText? = null
    var tx1: TextView? = null
    var counter = 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b1 = findViewById<View>(R.id.button) as Button
        ed1 = findViewById<View>(R.id.editText) as EditText
        ed2 = findViewById<View>(R.id.editText2) as EditText
        b2 = findViewById<View>(R.id.button2) as Button
        tx1 = findViewById<View>(R.id.textView3) as TextView
        tx1!!.visibility = View.GONE
        b1!!.setOnClickListener {
            if (ed1!!.text.toString() == "admin" && ed2!!.text.toString() == "admin") {
                Toast.makeText(
                    applicationContext,
                    "Redirecting...", Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(applicationContext, "Wrong Credentials", Toast.LENGTH_SHORT).show()
                tx1!!.visibility = View.VISIBLE
                tx1!!.setBackgroundColor(Color.RED)
                counter--
                tx1!!.text = Integer.toString(counter)
                if (counter == 0) {
                    b1!!.isEnabled = false
                }
            }
        }
        b2!!.setOnClickListener { finish() }
    }
}