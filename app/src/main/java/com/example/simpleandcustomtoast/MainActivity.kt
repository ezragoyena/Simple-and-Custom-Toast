package com.example.simpleandcustomtoast

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSimpleToast = findViewById<Button>(R.id.btnSimpleToast)
        val btnCustomToast = findViewById<Button>(R.id.btnCustomToast)

        btnSimpleToast.setOnClickListener {
            val toast = Toast.makeText(this,"This is a simple toast!", Toast.LENGTH_LONG )
            toast.show()
        }

        btnCustomToast.setOnClickListener {
            val toast = Toast(this)
            val layoutInflater = LayoutInflater.from(this)
            val customToastView = layoutInflater.inflate(R.layout.custom_toast, null)
            toast.view = customToastView
            toast.show()
        }

    }
}