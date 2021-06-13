package com.example.pruebabetterfly.presenter.pages.characterslist

import android.R
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebabetterfly.databinding.ActivityMainBinding
import com.example.pruebabetterfly.presenter.pages.characterslist.elements.ItemCharacterAdapter
import com.example.pruebabetterfly.presenter.pages.characterslist.viewmodel.CharacterListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val characterListViewModel: CharacterListViewModel by viewModels()
    private lateinit var adapter: ItemCharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initRecyclerView()
        characterListViewModel.characterList.observe(this, Observer {
            if (it != null) {
                characterListViewModel.characters.addAll(it)
                adapter.notifyDataSetChanged()
            }

        })
        characterListViewModel.getAllCharacter()
        characterListViewModel.message.observe(
            this,{
                Toast.makeText(this,it, Toast.LENGTH_SHORT).show()
            }
        )
    }

    private fun initRecyclerView(){
        adapter= ItemCharacterAdapter(characterListViewModel.characters)
        binding.rvCharacters.layoutManager=LinearLayoutManager(this)
        binding.rvCharacters.adapter=adapter
    }



}