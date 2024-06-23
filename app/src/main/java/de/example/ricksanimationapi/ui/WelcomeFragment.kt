package de.example.ricksanimationapi.ui

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import de.example.ricksanimationapi.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    // TODO private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startAnimBtBg()

        binding.apply {

            clWelcomeRick.setOnClickListener {

            }

            clWelcomeAmani.setOnClickListener {
                val navController = Navigation.findNavController(root)
                val directions = WelcomeFragmentDirections.toAmaniDuniaFragment()
                navController.navigate(directions)
            }
        }
    }

    private fun startAnimBtBg() {

        val animRick: AnimationDrawable = binding.clWelcomeRick.background as AnimationDrawable
        val animAmani: AnimationDrawable = binding.clWelcomeAmani.background as AnimationDrawable

        val animWelcomeList: List<AnimationDrawable> = listOf(animAmani, animRick)
        var anim: AnimationDrawable

        repeat(animWelcomeList.size) {
            anim = animWelcomeList[it]
            anim.setEnterFadeDuration(8)
            anim.setExitFadeDuration(8888)
            anim.start()
        }
    }
}