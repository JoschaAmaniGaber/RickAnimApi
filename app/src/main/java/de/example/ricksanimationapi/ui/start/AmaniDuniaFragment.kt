package de.example.ricksanimationapi.ui.start

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

        /**
         * TODO if (animMode) startAnim() | else noAnim()
         */
    }
}



/**
private fun noAnim() {
binding.clRickDbBgNoAnim.alpha = 1f
}
private fun startAnim() {
val animDetails: AnimationDrawable = binding.ivAmaniHeader.background as AnimationDrawable
val animBg: AnimationDrawable = binding.clRickDbBgNoAnim.background as AnimationDrawable
val animRadial: AnimationDrawable = binding.animAmaniRadialBg.background as AnimationDrawable
animLinearStartSlow(animBg)
animRoundStartFast(animDetails)
animRoundStartFast(animRadial)
}
 */