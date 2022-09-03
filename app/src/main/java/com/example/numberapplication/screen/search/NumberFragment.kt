package com.example.numberapplication.screen.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.numberapplication.databinding.FragmentNumberBinding
import com.example.numberapplication.view.adapters.NumberAdapter

class NumberFragment : Fragment() {

    interface OnItemClick {
        fun onItemClick(id: Int?)
    }

    var onItemClick: OnItemClick? = null
    private lateinit var binding: FragmentNumberBinding
    private val viewModel by viewModels<NumberViewModel>()
    private lateinit var adapter: NumberAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onItemClick = context as OnItemClick
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNumberBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.getAllFacts()

        viewModel.listOfFacts.observe(viewLifecycleOwner) {
            adapter = NumberAdapter(it ?: mutableListOf(), object : OnItemClick {
                override fun onItemClick(id: Int?) {
                    onItemClick?.onItemClick(id)
                }
            })
            binding.rvFacts.adapter = adapter
        }

        viewModel.lastFact.observe(viewLifecycleOwner) {
            if (it != null) adapter.addItem(it)
        }

        binding.rvFacts.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        return binding.root
    }

    override fun onDetach() {
        super.onDetach()
        onItemClick = null
    }

}