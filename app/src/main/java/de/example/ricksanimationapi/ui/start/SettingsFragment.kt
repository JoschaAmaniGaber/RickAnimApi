package de.example.ricksanimationapi.ui.start

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import de.example.ricksanimationapi.MainViewModel
import de.example.ricksanimationapi.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding
    private val viewModel: MainViewModel by activityViewModels()
}