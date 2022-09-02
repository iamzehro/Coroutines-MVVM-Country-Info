package com.zehro.countryinfo.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zehro.countryinfo.model.Country
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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
        viewModelScope.launch {
            fetchCountries()

        }
    }

    private suspend fun fetchCountries() {
        loading.value = true

        delay(2000L) // to simulate network request

        val dummyData: List<Country> = generateDummyCountries()

        countries.value = dummyData
        countryLoadError.value = "ERROR" // simulate a failure
        loading.value = false
    }

    private fun generateDummyCountries(): List<Country> {
        val countries: ArrayList<Country> = arrayListOf<Country>()
        countries.add(Country("Homer", "dummyCapital2", "https://upload.wikimedia.org/wikipedia/en/0/02/Homer_Simpson_2006.png"))
        countries.add(Country("Marge", "dummyCapital3", "https://upload.wikimedia.org/wikipedia/en/0/0b/Marge_Simpson.png"))
        countries.add(Country("Bart", "dummyCapital1", "https://upload.wikimedia.org/wikipedia/en/a/aa/Bart_Simpson_200px.png"))
        countries.add(Country("Lisa", "dummyCapital4", "https://upload.wikimedia.org/wikipedia/en/e/ec/Lisa_Simpson.png"))
        countries.add(Country("Maggie", "dummyCapital5", "https://upload.wikimedia.org/wikipedia/en/9/9d/Maggie_Simpson.png"))
        return countries
    }

    private fun onError(msg: String) {
        countryLoadError.value = msg
        loading.value = false
    }
}