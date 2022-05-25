package com.example.roommvvmcoroutines

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.roommvvmcoroutines.ui.AddF1DriverActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAddF1Driver = findViewById<Button>(R.id.addDriver)
        buttonAddF1Driver.setOnClickListener {
            startActivity(Intent(this, AddF1DriverActivity::class.java))
        }
    }
}