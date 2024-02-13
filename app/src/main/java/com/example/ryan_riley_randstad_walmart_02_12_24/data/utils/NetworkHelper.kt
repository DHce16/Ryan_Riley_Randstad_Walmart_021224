package com.example.ryan_riley_randstad_walmart_02_12_24.data.utils

import com.example.ryan_riley_randstad_walmart_02_12_24.data.model.APIResponseItem

sealed class NetworkHelper {
    class Success(val response: ArrayList<APIResponseItem>) : NetworkHelper()
    class Error(val message: String) : NetworkHelper()
    object Loading : NetworkHelper()
}
