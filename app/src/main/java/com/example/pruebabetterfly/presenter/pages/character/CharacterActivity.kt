package com.example.pruebabetterfly.presenter.pages.character

import android.R
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.pruebabetterfly.databinding.ActivityCharacterBinding
import com.example.pruebabetterfly.presenter.pages.character.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterActivity : AppCompatActivity() {

    private val characterViewModel: CharacterViewModel by viewModels()
    private lateinit var binding: ActivityCharacterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val characterId = intent.getIntExtra("characterId",0)
        if (characterId != null) {
            characterViewModel.getCharacterById(characterId = characterId.toString())
            characterViewModel.characterModel.observe(this, Observer {
                if(it!=null){
                    Glide.with(this)
                        .load(it.image)
                        .centerCrop()
                        .into(binding.imageView)
                    binding.tvName.text = it.name
                    binding.tvGender.text = it.gender
                    binding.tvLocation.text = it.location.name
                    binding.tvSpecie.text= it.species
                    binding.tvStatus.text= it.status
                }
            })
        }

        characterViewModel.message.observe(
            this,{
                Toast.makeText(this,it, Toast.LENGTH_SHORT).show()
            }
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }
}