package de.example.ricksanimationapi.ui.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import de.example.ricksanimationapi.MainViewModel
import de.example.ricksanimationapi.R
import de.example.ricksanimationapi.databinding.FragmentHalloBinding

class HalloFragment : Fragment() {

    private lateinit var binding: FragmentHalloBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHalloBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            viewModel.loadInfo()
            val navController = Navigation.findNavController(binding.root)
            val directions = R.id.startFragment
            navController.navigate(directions)
        }
    }
}