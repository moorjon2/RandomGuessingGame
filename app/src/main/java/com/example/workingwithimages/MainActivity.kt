package com.example.workingwithimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Switch
import com.example.workingwithimages.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var fruits = mutableListOf(R.drawable.apple, R.drawable.grape, R.drawable.orange)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnApple.setOnClickListener {
            snackStart(it)
        }
        binding.btnGrape.setOnClickListener {
            snackStart(it)
        }
        binding.btnRandom.setOnClickListener {
            snackStart(it)
        }

        binding.switchFruit.setOnCheckedChangeListener { _, isChecked ->
            toggleImage(isChecked)
        }
    }

    private fun snackStart(it: View) {
        Snackbar.make(it, "Switch to Start game", Snackbar.LENGTH_LONG).show()
    }

    private fun toggleImage(isChecked: Boolean) {
        var r: Int = 0

        if (isChecked) {
            binding.switchFruit.text = getString(R.string.stopGame)

            binding.btnRandom.setOnClickListener {
                r = (fruits).shuffled().first()
                binding.IVRandom.setImageResource(r)
            }
            binding.btnGrape.setOnClickListener {
                binding.IVMyFruit.setImageResource(R.drawable.grape)
            }
            binding.btnApple.setOnClickListener {
                binding.IVMyFruit.setImageResource(R.drawable.apple)
            }
        } else {
            binding.switchFruit.text = getString(R.string.startGame)
        }
            //checkImages(r)
    }

    // TODO: need to implement winning condition
    // Unsure as to how to implement this logic
    // Need to check if the random image and the image from one of the two
    // buttons (btnGrape/btnApple) are the same. While the switch is checked
    // If they are the same show a Snackbar with the message "Congratulations! You win"
    // else if they are not the same "Sorry, you loose"
    private fun checkImages(image: Int) {
        return if (fruits.contains(image)) {
            Snackbar.make(binding.root, "Congratulations", Snackbar.LENGTH_LONG).show()
        } else {
            Snackbar.make(binding.root, "Sorry you lose", Snackbar.LENGTH_LONG).show()
        }
    }
}