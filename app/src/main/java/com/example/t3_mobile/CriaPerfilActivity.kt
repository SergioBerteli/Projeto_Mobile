package com.example.t3_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t3_mobile.databinding.ActivityCriaPerfilBinding

class CriaPerfilActivity : AppCompatActivity() {
    lateinit var binding: ActivityCriaPerfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCriaPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCriaPerfil.setOnClickListener {
            finish()
        }
    }


}