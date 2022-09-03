package com.example.numberapplication.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.numberapplication.databinding.ActivityMainBinding
import com.example.numberapplication.screen.search.NumberFragment
import com.example.numberapplication.screen.detail.NumberDetailFragment

class MainActivity : AppCompatActivity(), NumberFragment.OnItemClick {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(binding.container.id, NumberFragment())
                .commit()
        }
    }

    override fun onItemClick(id: Int?) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.container.id, NumberDetailFragment.newInstance(id))
            .addToBackStack(null)
            .commit()
    }

}