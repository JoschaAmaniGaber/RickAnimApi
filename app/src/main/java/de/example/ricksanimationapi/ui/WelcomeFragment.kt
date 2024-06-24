package de.example.ricksanimationapi.ui

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import de.example.ricksanimationapi.MainViewModel
import de.example.ricksanimationapi.anims.animMode
import de.example.ricksanimationapi.anims.animRoundStartVerySlow
import de.example.ricksanimationapi.anims.animsRoundFast
import de.example.ricksanimationapi.anims.animsRoundSlow
import de.example.ricksanimationapi.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    private val viewModel: MainViewModel by activityViewModels()

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

        if (animMode) startAnim()
        else noAnim()

        binding.clWelcomeRick.setOnClickListener {
            viewModel.loadCharacters()
            val navController = Navigation.findNavController(binding.root)
            val directions = WelcomeFragmentDirections.toRickDbCheckFragment()
            navController.navigate(directions)
        }

        binding.clWelcomeAmani.setOnClickListener {
            val navController = Navigation.findNavController(binding.root)
            val directions = WelcomeFragmentDirections.toAmaniDuniaFragment()
            navController.navigate(directions)
        }
    }

    private fun noAnim() {
        binding.animOffRick.alpha = 1f
        binding.animOffAmani.alpha = 1f
        binding.animOffRickInside.alpha = 1f
        binding.animOffAmaniInside.alpha = 1f
    }

    private fun startAnim() {

        val animBorder: AnimationDrawable = binding.clWelcomeBorder.background as AnimationDrawable
        animRoundStartVerySlow(animBorder)

        val animRick: AnimationDrawable = binding.clWelcomeRick.background as AnimationDrawable
        val animAmani: AnimationDrawable = binding.clWelcomeAmani.background as AnimationDrawable
        val animListFast: List<AnimationDrawable> = listOf(animRick, animAmani)
        animsRoundFast(animListFast)

        val animRickBorder: AnimationDrawable =
            binding.clWelcomeRickBorder.background as AnimationDrawable
        val animAmaniBorder: AnimationDrawable =
            binding.clWelcomeAmaniBorder.background as AnimationDrawable
        val animListVerySlow: List<AnimationDrawable> = listOf(animRickBorder, animAmaniBorder)
        animsRoundSlow(animListVerySlow)
    }
}