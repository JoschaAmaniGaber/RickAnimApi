package de.example.ricksanimationapi

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import de.example.ricksanimationapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)

        onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                binding.fragmentContainerView.findNavController().navigateUp()
            }
        })

        val bg_anim_main: AnimationDrawable = binding.root.background as AnimationDrawable
        bg_anim_main.setEnterFadeDuration(8)
        bg_anim_main.setExitFadeDuration(2222)
        bg_anim_main.start()
    }

}