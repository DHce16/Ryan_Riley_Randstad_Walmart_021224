package com.example.ryan_riley_randstad_walmart_02_12_24.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ryan_riley_randstad_walmart_02_12_24.data.api.APIDetails
import com.example.ryan_riley_randstad_walmart_02_12_24.data.repository.CountryFactsRepositoryImpl
import com.example.ryan_riley_randstad_walmart_02_12_24.domain.usecase.GetCountryFactsUseCase

class CountryViewModelFactory() :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountryViewModel::class.java)) {
            val repository = CountryFactsRepositoryImpl(APIDetails.service)
            val getCountriesFactsUseCase = GetCountryFactsUseCase(repository)
            @Suppress("UNCHECKED_CAST")
            return CountryViewModel(getCountriesFactsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}