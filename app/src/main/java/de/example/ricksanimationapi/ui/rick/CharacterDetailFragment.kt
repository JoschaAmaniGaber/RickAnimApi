package de.example.ricksanimationapi.ui.rick

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import de.example.ricksanimationapi.MainViewModel
import de.example.ricksanimationapi.databinding.FragmentCharacterDetailBinding

class CharacterDetailFragment : Fragment() {

    private lateinit var binding: FragmentCharacterDetailBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedCharacter.observe(viewLifecycleOwner) { selectedCharacter ->

            selectedCharacter?.let { character ->
                binding.apply {
                    ivChDetail.load(character.chaImage)
                    ivChDetailBackground.load(character.chaImage)
                    tvChDetailName.text = character.chaName
                    tvChDetailSpecies.text = character.chaSpecies
                    tvType.text =
                        if (character.chaType == "") "Keep it Real"
                        else character.chaType
                }
            }
        }
    }
}