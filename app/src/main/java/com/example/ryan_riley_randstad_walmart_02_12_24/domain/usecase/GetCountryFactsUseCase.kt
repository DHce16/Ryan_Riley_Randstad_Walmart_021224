package com.example.ryan_riley_randstad_walmart_02_12_24.domain.usecase

import com.example.ryan_riley_randstad_walmart_02_12_24.domain.repository.CountryFactsRepository

class GetCountryFactsUseCase(private val repository: CountryFactsRepository) {
    suspend fun execute() = repository.getCountryFacts()
}