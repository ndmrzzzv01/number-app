package com.example.numberapplication.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.numberapplication.database.data.FactEntity
import com.example.numberapplication.databinding.ItemFactBinding
import com.example.numberapplication.screen.search.NumberFragment
import com.example.numberapplication.view.holders.NumberHolder

class NumberAdapter(
    private var listOfFacts: MutableList<FactEntity>,
    private val listener: NumberFragment.OnItemClick
) : RecyclerView.Adapter<NumberHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberHolder = NumberHolder(
        ItemFactBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ), listener
    )

    override fun onBindViewHolder(holder: NumberHolder, position: Int) =
        holder.bind(listOfFacts[position])

    override fun getItemCount(): Int = listOfFacts.size

    fun addItem(fact: FactEntity) {
        listOfFacts.add(0, fact)
        notifyItemInserted(0)
    }

}