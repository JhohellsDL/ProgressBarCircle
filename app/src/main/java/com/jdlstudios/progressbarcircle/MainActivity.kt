package com.jdlstudios.progressbarcircle

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jdlstudios.progressbarcircle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonGo.setOnClickListener {
            animatedText()
            animatedProgressBar()
        }

    }

    override fun onResume() {
        super.onResume()
        animatedText()
        animatedProgressBar()
    }

    private fun animatedProgressBar() {
        val progressAnimator = ObjectAnimator.ofInt(binding.progressBar, "progress", 0 ,60)
        progressAnimator.duration = 1000
        progressAnimator.start()
    }

    private fun animatedText() {
        val valueAnimator = ValueAnimator.ofInt(0, 60)
        valueAnimator.duration = 1000
        valueAnimator.addUpdateListener {
            val animatedValue = it.animatedValue as Int
            binding.textTest.text = animatedValue.toString()
        }
        valueAnimator.start()
    }
}