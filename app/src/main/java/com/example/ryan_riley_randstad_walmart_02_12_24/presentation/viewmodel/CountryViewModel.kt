package com.example.ryan_riley_randstad_walmart_02_12_24.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ryan_riley_randstad_walmart_02_12_24.data.utils.NetworkHelper
import com.example.ryan_riley_randstad_walmart_02_12_24.domain.usecase.GetCountryFactsUseCase
import kotlinx.coroutines.launch

class CountryViewModel(private val getCountryFactsUseCase: GetCountryFactsUseCase) : ViewModel() {

    private val _countriesFact = MutableLiveData<NetworkHelper>()
    val countriesFact: LiveData<NetworkHelper> = _countriesFact

    fun getCountryFacts() = viewModelScope.launch {
        getCountryFactsUseCase.execute().collect {
            _countriesFact.postValue(it)
        }
    }
}