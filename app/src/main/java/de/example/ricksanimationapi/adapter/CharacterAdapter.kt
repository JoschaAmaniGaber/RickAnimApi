package de.example.ricksanimationapi.adapter

import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import de.example.ricksanimationapi.R
import de.example.ricksanimationapi.anims.animRoundStartFast
import de.example.ricksanimationapi.data.model.enteties.character.Character
import de.example.ricksanimationapi.databinding.ItemCharacterBinding

class CharacterAdapter(
    private var characters: List<Character>,
    private val onSelectCharacter: (Character) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.CharacterHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterAdapter.CharacterHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemCharacterBinding.inflate(inflater, parent, false)
        return CharacterHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterAdapter.CharacterHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    override fun getItemCount(): Int = characters.size

    inner class CharacterHolder(
        private val binding: ItemCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character) = binding.apply {

            val character: Character = character
            ivCharacter.load(character.chaImage)
            tvCharacterName.text = character.chaName

            clItemClickable.setOnClickListener {
                onSelectCharacter(character)
            }


            var animStatus: AnimationDrawable = statusBackground.background as AnimationDrawable
            animRoundStartFast(animStatus)

        }
    }

}