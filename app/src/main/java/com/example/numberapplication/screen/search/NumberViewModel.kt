package com.example.numberapplication.screen.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.numberapplication.database.DatabaseRepository
import com.example.numberapplication.database.data.FactEntity
import com.example.numberapplication.network.NumberRepository
import kotlinx.coroutines.launch

class NumberViewModel : ViewModel() {

    private val networkRepository = NumberRepository()
    private val databaseRepository = DatabaseRepository()

    val inputNumber = MutableLiveData<String?>()
    val error = MutableLiveData<Boolean>()
    val errorText = MutableLiveData<String>()
    val result = MutableLiveData<String?>()

    val listOfFacts = MutableLiveData<MutableList<FactEntity>?>()
    val lastFact = MutableLiveData<FactEntity?>()

    fun getFact() {
        if (inputNumber.value.isNullOrBlank()) {
            error.value = true
            errorText.value = "Field cannot be empty"
        } else {
            viewModelScope.launch {
                error.value = false
                errorText.value = ""
                val number = inputNumber.value?.toIntOrNull()
                val fact = networkRepository.getFactAboutNumber(number ?: 0)
                val factEntity = FactEntity(
                    number = fact.number,
                    info = fact.info
                )
                val id = databaseRepository.insertFactToDatabase(factEntity)
                factEntity.id = id?.toInt() ?: 0
                lastFact.value = factEntity
                result.value = fact.info
            }
        }
    }

    fun getFactAboutRandomNumber() {
        viewModelScope.launch {
            val fact = networkRepository.getFactAboutRandomNumber()
            val factEntity = FactEntity(
                number = fact.number,
                info = fact.info
            )
            val id = databaseRepository.insertFactToDatabase(factEntity)
            factEntity.id = id?.toInt() ?: 0
            lastFact.value = factEntity
            result.value = fact.info
            inputNumber.value = fact.number
        }
    }

    fun getAllFacts() {
        viewModelScope.launch {
            val list = databaseRepository.getAllFacts()
            listOfFacts.value = list
        }
    }

}