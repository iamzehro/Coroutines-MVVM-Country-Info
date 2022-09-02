package com.zehro.countryinfo.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.zehro.countryinfo.model.Country
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(

): ViewModel() {
    var countries = mutableStateOf(emptyList<Country>())
    var countryLoadError = mutableStateOf("")
    var loading = mutableStateOf(false)
    //private val countries = MutableLiveData<List<Country>>()
    //private val countryLoadError = MutableLiveData<String?>()
    //private val loading = MutableLiveData<Boolean>()

    init {
        //refresh()
    }

    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
        loading.value = true

        val dummyData: List<Country> = generateDummyCountries()

        countries.value = dummyData
        countryLoadError.value = ""
        loading.value = false
    }

    private fun generateDummyCountries(): List<Country> {
        val countries: ArrayList<Country> = arrayListOf<Country>()
        countries.add(Country("dummy1", "dummyCapital1", ""))
        countries.add(Country("dummy2", "dummyCapital2", ""))
        countries.add(Country("dummy3", "dummyCapital3", ""))
        countries.add(Country("dummy4", "dummyCapital4", ""))
        countries.add(Country("dummy5", "dummyCapital5", ""))
        return countries
    }

    private fun onError(msg: String) {
        countryLoadError.value = msg
        loading.value = false
    }
}