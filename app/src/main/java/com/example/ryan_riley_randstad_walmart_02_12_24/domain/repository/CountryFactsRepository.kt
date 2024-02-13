package com.example.ryan_riley_randstad_walmart_02_12_24.domain.repository

import com.example.ryan_riley_randstad_walmart_02_12_24.data.utils.NetworkHelper
import kotlinx.coroutines.flow.Flow

interface CountryFactsRepository {
    suspend fun getCountryFacts(): Flow<NetworkHelper>
}