package de.example.ricksanimationapi.ui.rick

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import de.example.ricksanimationapi.MainViewModel
import de.example.ricksanimationapi.R
import de.example.ricksanimationapi.data.remote.ApiStatus
import de.example.ricksanimationapi.databinding.FragmentDbCheckBinding

class DbCheckFragment : Fragment() {

    private lateinit var binding: FragmentDbCheckBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDbCheckBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLoadLocations.setOnClickListener {
            viewModel.loadLocations()
            // TODO
        }

        binding.btnLoadCharacters.setOnClickListener {
            viewModel.loadCharacters()
            // TODO
        }

        binding.btnAllCharacters.setOnClickListener {
            val navController = Navigation.findNavController(binding.root)
            val directions = R.id.characterFragment
            navController.navigate(directions)
        }

        viewModel.loading.observe(viewLifecycleOwner) {

            when (it) {
                ApiStatus.CHARACTER_LOADING -> TODO()
                ApiStatus.CHARACTER_API_ERROR -> TODO()
                ApiStatus.CHARACTER_API_DONE -> TODO()
                ApiStatus.CHARACTER_DB_ERROR -> TODO()
                ApiStatus.CHARACTER_PAGE_DONE -> TODO()
                ApiStatus.CHARACTER_DB_DONE -> TODO()
                ApiStatus.LOCATION_LOADING -> TODO()
                ApiStatus.LOCATION_API_ERROR -> TODO()
                ApiStatus.LOCATION_API_DONE -> TODO()
                ApiStatus.LOCATION_DB_ERROR -> TODO()
                ApiStatus.LOCATION_PAGE_DONE -> TODO()
                ApiStatus.LOCATION_DB_DONE -> TODO()
                ApiStatus.EPISODE_LOADING -> TODO()
                ApiStatus.EPISODE_API_ERROR -> TODO()
                ApiStatus.EPISODE_API_DONE -> TODO()
                ApiStatus.EPISODE_DB_ERROR -> TODO()
                ApiStatus.EPISODE_PAGE_DONE -> TODO()
                ApiStatus.EPISODE_DB_DONE -> TODO()
                ApiStatus.INFO_LOADING -> TODO()
                ApiStatus.INFO_ERROR -> TODO()
                ApiStatus.INFO_DONE -> TODO()
            }

        }
    }
}


/**
 *
 *
 *
 *
 *
// round very slow
val animHeaderBg: AnimationDrawable = binding.clRickDbHeaderOutside.background as AnimationDrawable
animRoundStartVerySlow(animHeaderBg)

// radial fast
val animHeader: AnimationDrawable = binding.clRickDbHeader.background as AnimationDrawable
val animDbStatus: AnimationDrawable = binding.tvDatabaseStatus.background as AnimationDrawable
val animCharacterDb: AnimationDrawable = binding.tvCharacterDb.background as AnimationDrawable
val animLocationDb: AnimationDrawable = binding.tvLocationDb.background as AnimationDrawable
val animEpisodeDb: AnimationDrawable = binding.tvEpisodeDb.background as AnimationDrawable
val animList: List<AnimationDrawable> = listOf(
animHeader,
animDbStatus,
animCharacterDb,
animLocationDb,
animEpisodeDb
)
animsRoundFast(animList)

// round fast
val animeDbCheck: AnimationDrawable =binding.clRickDbCheck.background as AnimationDrawable
animRoundStartFast(animeDbCheck)
 */
