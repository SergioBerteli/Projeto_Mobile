package com.example.t3_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t3_mobile.databinding.ActivityMainBinding
import com.example.t3_mobile.databinding.ActivitySigninScreenBinding



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnCriarConta.setOnClickListener {
            val intent = Intent(this, SiginScreenActivity::class.java)
            startActivity(intent)
        }

        binding.btnEntrar.setOnClickListener {
            val intent = Intent(this, Logado::class.java)
            startActivity(intent)
        }
    }
}