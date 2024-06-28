package de.example.ricksanimationapi

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import de.example.ricksanimationapi.anims.animLinearStartVerySlow
import de.example.ricksanimationapi.anims.animMode
import de.example.ricksanimationapi.anims.animRoundStartFast
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
        val animBg: AnimationDrawable = binding.animMainBg.background as AnimationDrawable
        animLinearStartVerySlow(animBg)
    }
}



/**
 * if (animMode) startAnim()
 * else noAnim()
private fun noAnim() {
binding.animMainBg.alpha = 0f
}


val animLinear: AnimationDrawable = binding.animMainLinear.background as AnimationDrawable
animLinearStartVerySlow(animLinear)
val animFast: AnimationDrawable = binding.animMainFast.background as AnimationDrawable
animRoundStartFast(animFast)
}
 */