package de.example.ricksanimationapi.ui

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.example.ricksanimationapi.anims.animMode
import de.example.ricksanimationapi.anims.animRoundStartVerySlow
import de.example.ricksanimationapi.anims.animsRoundFast
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
        if (animMode) startAnim()
        else noAnim()
    }

    private fun noAnim() {
        binding.clRickDbBgNoAnim.alpha = 1f
    }

    private fun startAnim() {

        val animDetails: AnimationDrawable = binding.clAmaniDetails.background as AnimationDrawable
        val animHeader: AnimationDrawable = binding.clAmaniHeader.background as AnimationDrawable
        val animLinks: AnimationDrawable = binding.clAmaniLinks.background as AnimationDrawable
        val animList: List<AnimationDrawable> = listOf(animDetails, animLinks, animHeader)
        animsRoundFast(animList)

        val animDbBgInside: AnimationDrawable = binding.clRickDbBgInside.background as AnimationDrawable
        animRoundStartVerySlow(animDbBgInside)
    }

}