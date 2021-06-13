package com.example.pruebabetterfly.presenter.pages.characterslist.elements

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pruebabetterfly.R
import com.example.pruebabetterfly.core.entities.ECharacter
import com.example.pruebabetterfly.databinding.ItemCharacterBinding
import com.example.pruebabetterfly.presenter.pages.character.CharacterActivity


class ItemCharacterAdapter(private val ECharacters:ArrayList<ECharacter>):
    RecyclerView.Adapter<CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater:LayoutInflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(layoutInflater.inflate(R.layout.item_character,parent,false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item: ECharacter = ECharacters[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, CharacterActivity::class.java)
            intent.putExtra("characterId",item.id)
            holder.itemView.context.startActivity(intent);
        }
    }

    override fun getItemCount(): Int {
        return ECharacters.size
    }
}

class CharacterViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding= ItemCharacterBinding.bind(view)

    fun bind(item: ECharacter){
        binding.tvName.text= item.name
        binding.tvStatusSpecie.text="${item.status} - ${item.species}"
        binding.tvLocation.text= item.location.name
        Glide.with(binding.ivPhoto.context)
            .load(item.image)
            .into(binding.ivPhoto);

    }



}
