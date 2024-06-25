package de.example.ricksanimationapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import de.example.ricksanimationapi.MainViewModel
import de.example.ricksanimationapi.databinding.FragmentRickDbCheckBinding

class RickDbCheckFragment : Fragment() {

    private lateinit var binding: FragmentRickDbCheckBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRickDbCheckBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val characters = viewModel.characters
    }
}