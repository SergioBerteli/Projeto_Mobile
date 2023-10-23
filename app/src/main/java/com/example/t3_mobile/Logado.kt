package com.example.t3_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.t3_mobile.databinding.ActivityLogadoBinding

class Logado : AppCompatActivity() {
    lateinit var binding: ActivityLogadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogadoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        replaceFragment(InicioFragment())

        binding.navbar.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.home -> replaceFragment(InicioFragment())
                R.id.profiles -> replaceFragment(PerfisFragment())
                R.id.addmed -> replaceFragment(NovoMedFragment())
                R.id.cart -> replaceFragment(ListaComprasFragment())
                R.id.list-> replaceFragment(MedicamentosFragment())

                else -> {

                }

            }
            true

        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager= supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainframe,fragment)
        fragmentTransaction.commit()
    }
}
