package com.example.t3_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t3_mobile.databinding.ActivitySigninScreenBinding




class SiginScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivitySigninScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnConfCriacao.setOnClickListener{
            finish()
        }
    }

}