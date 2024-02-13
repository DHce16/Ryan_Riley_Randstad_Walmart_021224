package com.example.ryan_riley_randstad_walmart_02_12_24.data.api

import com.example.ryan_riley_randstad_walmart_02_12_24.data.model.APIResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface CountryAPIService {

    @GET(APIDetails.ENDPOINT)
    suspend fun getCountryFacts(): Response<ArrayList<APIResponseItem>>
}