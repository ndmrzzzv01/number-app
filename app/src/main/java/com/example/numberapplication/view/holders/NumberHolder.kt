package com.example.numberapplication.view.holders

import androidx.recyclerview.widget.RecyclerView
import com.example.numberapplication.database.data.FactEntity
import com.example.numberapplication.databinding.ItemFactBinding
import com.example.numberapplication.screen.search.NumberFragment

class NumberHolder(
    private val binding: ItemFactBinding,
    private val listener: NumberFragment.OnItemClick
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(fact: FactEntity) {
        binding.apply {
            tvNumber.text = fact.number
            tvFact.text = fact.info
            itemView.setOnClickListener {
                listener.onItemClick(fact.id)
            }
        }
    }

}