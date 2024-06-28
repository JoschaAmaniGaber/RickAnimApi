package de.example.ricksanimationapi.ui.start

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import de.example.ricksanimationapi.MainViewModel
import de.example.ricksanimationapi.R
import de.example.ricksanimationapi.anims.animMode
import de.example.ricksanimationapi.anims.animRoundStartFast
import de.example.ricksanimationapi.anims.animRoundStartVerySlow
import de.example.ricksanimationapi.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // if (animMode) startAnim()
       // else noAnim()

        binding.animRick.setOnClickListener {
            viewModel.loadInfo()
            val navController = Navigation.findNavController(binding.root)
            val directions = R.id.dbCheckFragment
            navController.navigate(directions)
        }

        binding.animAmani.setOnClickListener {
            val navController = Navigation.findNavController(binding.root)
            val directions = StartFragmentDirections.actionStartFragmentToDbCheckFragment()
            navController.navigate(directions)
        }
    }


   // private fun noAnim() {
   //     // TODO alpha = 1f
   // }
//
   // private fun startAnim() {
   //     val animRick: AnimationDrawable = binding.animAmani.background as AnimationDrawable
   //     animRoundStartFast(animRick)
   //     val wow: AnimationDrawable = binding.clWelcomeBallRick.background as AnimationDrawable
   //     animRoundStartFast(wow)
   //     val animAmani: AnimationDrawable = binding.animRick.background as AnimationDrawable
   //     animRoundStartVerySlow(animAmani)
   //     val animRound: AnimationDrawable = binding.animPlanetRick.background as AnimationDrawable
   //     animRoundStartVerySlow(animRound)
   // }

}