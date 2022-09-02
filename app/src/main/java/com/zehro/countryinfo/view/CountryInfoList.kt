package com.zehro.countryinfo.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zehro.countryinfo.model.Country
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun CountryInfoList(
    countries: List<Country>,
    countryLoadError: String,
    loading: Boolean
) {
    // List of data
    if(loading) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = "Loading")
        }
    }
    LazyColumn(
        content = {
            items(countries) { country ->
                CountryItem(country)
            }
        }
    )
}

@Composable
fun CountryItem(it: Country) {
    Column() {
        it.countryName?.let { it1 -> Text(text = it1) }
        it.capital?.let { it1 -> Text(text = it1) }

    }

}
