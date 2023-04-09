package com.example.volumecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.volumecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState?.getString(KEY) != null) {
            binding.tvHasil.text = savedInstanceState.getString(KEY)
        }
        binding.button.setOnClickListener {
            val panjang = binding.edPanjang.text.toString()
            val lebar = binding.edLebar.text.toString()
            val tinggi = binding.edTinggi.text.toString()
            if(panjang.isEmpty()) {
                binding.edPanjang.error = "Field ini tidak boleh kosong"
            } else if (lebar.isEmpty()) {
                binding.edLebar.error = "Field ini tidak boleh kosong"
            } else if (tinggi.isEmpty()) {
                binding.edTinggi.error = "Field ini tidak boleh kosong"
            } else {
                val calculate = panjang.toDouble() * lebar.toDouble() * tinggi.toDouble()
                binding.tvHasil.text = calculate.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY, binding.tvHasil.text.toString())
    }

    companion object {
        private const val KEY = "hasil"
    }
}