package com.example.ej11objeto

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ej11objeto.databinding.ActivityObjetoBinding

class Objeto : AppCompatActivity() {
    private lateinit var binding: ActivityObjetoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObjetoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageView.setBackgroundResource(R.drawable.kart)

        binding.button.setOnClickListener {
            Intent (this, MainActivity::class.java).also {
                val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
                val tam = sharedPreference.getInt("tamMoch", 100)

                val mochila = Mochila(tam)
                val objeto = Objetos()

                Toast.makeText(this, mochila.addObjeto(objeto), Toast.LENGTH_LONG).show()

                val editor = sharedPreference.edit()
                editor.putInt("tamMoch", tam-objeto.getPeso())
                editor.apply()
                startActivity(it)
            }
        }

        binding.button2.setOnClickListener {
            Intent (this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
        sharedPreference.edit().clear().apply()
    }
}