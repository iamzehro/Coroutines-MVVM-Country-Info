package com.zehro.countryinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zehro.countryinfo.ui.theme.CountryInfoTheme
import com.zehro.countryinfo.view.CountryInfoList
import com.zehro.countryinfo.viewmodel.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.refresh()

        setContent {
            CountryInfoTheme {
                CountryInfoList(
                    countries = viewModel.countries.value,
                    countryLoadError = viewModel.countryLoadError.value,
                    loading = viewModel.loading.value
                )

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CountryInfoTheme {
        Greeting("Android")
    }
}