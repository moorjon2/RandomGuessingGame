package com.example.workingwithimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workingwithimages.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var fruits = mutableListOf(R.drawable.apple, R.drawable.grape, R.drawable.orange)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fruits.add(R.drawable.ic_orange_vector)
        binding.btnRandom.setOnClickListener {
            val r = (fruits).shuffled().first()
            binding.imageViewFruit.setImageResource(r)
            //Snackbar.make(it, "random number is $r", Snackbar.LENGTH_LONG).show()
        }

        binding.imageViewFruit.setImageResource(R.drawable.ic_orange_vector)
        binding.switchFruit.setOnCheckedChangeListener { _, isChecked ->
            toggleImage(isChecked)
        }
    }

    private fun toggleImage(isChecked: Boolean) {
        if (isChecked) {
            binding.imageViewFruit.setImageResource(R.drawable.grape)
            binding.switchFruit.text = getString(R.string.switch_apple)
        } else {
            binding.imageViewFruit.setImageResource(R.drawable.apple)
            binding.switchFruit.text = getString(R.string.switch_grapes)
        }
    }
}