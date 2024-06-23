package de.example.ricksanimationapi.ui

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.example.ricksanimationapi.databinding.FragmentAmaniDuniaBinding

class AmaniDuniaFragment : Fragment() {

    private lateinit var binding: FragmentAmaniDuniaBinding
    // TODO private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAmaniDuniaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startAnimBtBg()
    }

    private fun startAnimBtBg() {

        val anim1: AnimationDrawable = binding.cl.background as AnimationDrawable
        val anim2: AnimationDrawable = binding.constraintLayout.background as AnimationDrawable
        val animHeader: AnimationDrawable = binding.clAmaniHeader.background as AnimationDrawable

        val animWelcomeList: List<AnimationDrawable> = listOf(animHeader, anim2, anim1)
        var anim: AnimationDrawable

        repeat(animWelcomeList.size) {
            anim = animWelcomeList[it]
            anim.setEnterFadeDuration(8)
            anim.setExitFadeDuration(8888)
            anim.start()
        }
    }
}