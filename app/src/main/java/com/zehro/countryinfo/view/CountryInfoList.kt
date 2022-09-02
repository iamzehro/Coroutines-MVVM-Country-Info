package com.zehro.countryinfo.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.zehro.countryinfo.model.Country
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun CountryInfoList(
    countries: List<Country>,
    loadError: String,
    showProgress: Boolean
) {
    // List of data
    if (showProgress) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(150.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
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
    Row(modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp), verticalAlignment = Alignment.CenterVertically) {
        it.flag?.let { it1 ->
            Image(
                painter = rememberImagePainter(data = it1),
                contentDescription = "Image",
                modifier = Modifier
                    .height(85.dp)
                    .width(100.dp)
            )
        }
        Column(
            modifier = Modifier.fillMaxHeight().padding(start = 10.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            it.countryName?.let { it1 -> Text(text = it1) }
            it.capital?.let { it1 -> Text(text = it1) }

        }
    }
}
