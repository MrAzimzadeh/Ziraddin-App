package com.azimzada.falciziraddin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        findViewById<Button>(R.id.button).setOnClickListener()
        {
            var intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent);
        }
    }
}