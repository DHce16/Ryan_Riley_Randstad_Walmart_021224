package com.example.ryan_riley_randstad_walmart_02_12_24.data.repository

import com.example.ryan_riley_randstad_walmart_02_12_24.data.api.CountryAPIService
import com.example.ryan_riley_randstad_walmart_02_12_24.data.utils.NetworkHelper
import com.example.ryan_riley_randstad_walmart_02_12_24.domain.repository.CountryFactsRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow

class CountryFactsRepositoryImpl(val apiService: CountryAPIService) : CountryFactsRepository {
    override suspend fun getCountryFacts(): Flow<NetworkHelper> {
        return flow {
            try {
                emit(NetworkHelper.Loading)
                val response = apiService.getCountryFacts()
                if (response.isSuccessful && response.body() != null) {
                    emit(NetworkHelper.Success(response.body()!!))
                } else {
                    emit(NetworkHelper.Error(response.message()))
                }

            } catch (e: Exception) {
                emit(NetworkHelper.Error(e.message.toString()))
            }
        }
    }
}