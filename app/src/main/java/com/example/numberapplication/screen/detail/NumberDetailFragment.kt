package com.example.numberapplication.screen.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.numberapplication.databinding.FragmentDetailNumberBinding

class NumberDetailFragment : Fragment() {

    companion object {
        private const val ID = "number"
        fun newInstance(id: Int?): NumberDetailFragment {
            val fragment = NumberDetailFragment()
            fragment.arguments = Bundle().apply {
                putInt(ID, id ?: 0)
            }
            return fragment
        }
    }

    private lateinit var binding: FragmentDetailNumberBinding
    private val viewModel by viewModels<NumberDetailViewModel>()
    private var id: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        id = arguments?.getInt(ID)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailNumberBinding.inflate(layoutInflater, container, false)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFactAboutNumber(id ?: 0)
    }

}