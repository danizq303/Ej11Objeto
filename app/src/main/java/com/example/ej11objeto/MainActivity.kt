package com.example.ej11objeto

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ej11objeto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageView.setBackgroundResource(R.drawable.paisaje)

        binding.imageButton.setOnClickListener {
            when ((1..4).random()) {
                1 -> Intent (this, Objeto::class.java).also {
                    val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
                    val tam = sharedPreference.getInt("tamMoch", 100)

                    val editor = sharedPreference.edit()
                    editor.putInt("tamMoch", tam)
                    editor.apply()

                    startActivity(it)
                }
                2 -> Intent (this, Ciudad::class.java).also {
                    startActivity(it)
                }
                3 -> Intent (this, Mercader::class.java).also {
                    startActivity(it)
                }
                4 -> Intent (this, Enemigo::class.java).also {
                    startActivity(it)
                }
            }
        }
    }


}