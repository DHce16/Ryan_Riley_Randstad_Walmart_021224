package com.example.ryan_riley_randstad_walmart_02_12_24.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ryan_riley_randstad_walmart_02_12_24.R
import com.example.ryan_riley_randstad_walmart_02_12_24.data.api.APIDetails
import com.example.ryan_riley_randstad_walmart_02_12_24.data.repository.CountryFactsRepositoryImpl
import com.example.ryan_riley_randstad_walmart_02_12_24.data.utils.NetworkHelper
import com.example.ryan_riley_randstad_walmart_02_12_24.domain.usecase.GetCountryFactsUseCase
import com.example.ryan_riley_randstad_walmart_02_12_24.presentation.viewmodel.CountryViewModel
import com.example.ryan_riley_randstad_walmart_02_12_24.presentation.viewmodel.CountryViewModelFactory


class CountryFragment() : Fragment() {
    private val viewModel: CountryViewModel by viewModels {
        CountryViewModelFactory()
    }
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CountryRecyclerViewAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar = view.findViewById(R.id.progressBar)
        recyclerView = view.findViewById(R.id.countryRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = CountryRecyclerViewAdapter(arrayListOf())
        recyclerView.adapter = adapter

        viewModel.countriesFact.observe(viewLifecycleOwner, Observer { networkcase ->
            when (networkcase) {
                is NetworkHelper.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is NetworkHelper.Error -> {
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(
                        context,
                        "Error fetching data: ${networkcase.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
                is NetworkHelper.Success -> {
                    progressBar.visibility = View.INVISIBLE
                    adapter.updateCountries(networkcase.response)
                }
            }
        })
        viewModel.getCountryFacts()
    }
}