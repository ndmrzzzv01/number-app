package com.example.numberapplication.screen.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.numberapplication.database.DatabaseRepository
import com.example.numberapplication.database.data.FactEntity
import kotlinx.coroutines.launch

class NumberDetailViewModel : ViewModel() {

    private val databaseRepository = DatabaseRepository()
    val chosenNumber = MutableLiveData<FactEntity?>()

    fun getFactAboutNumber(id: Int) {
        viewModelScope.launch {
            val fact = databaseRepository.getFact(id)
            chosenNumber.value = fact
        }
    }

}