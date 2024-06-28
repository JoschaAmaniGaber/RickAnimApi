package de.example.ricksanimationapi.ui.rick

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import de.example.ricksanimationapi.MainViewModel
import de.example.ricksanimationapi.adapter.CharacterAdapter
import de.example.ricksanimationapi.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment() {

    private lateinit var binding: FragmentCharacterBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.characters.observe(viewLifecycleOwner) { characters ->
            val adapter = CharacterAdapter(characters) { selectedCharacter ->
                val direction = CharacterFragmentDirections.toChaDetailFragment()
                findNavController().navigate(direction)
                viewModel.setSelectedCharacter(selectedCharacter)
            }

            binding.apply {
                rvCharacters.adapter = adapter
            }
        }
    }
}