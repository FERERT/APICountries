package com.course.walmartassessment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.course.domain.di.useCaseModule
import com.course.domain.usecase.GetCountriesUseCase
import com.course.walmartassessment.state.CountryApiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val useCase: GetCountriesUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _countryApiState: MutableLiveData<CountryApiState> =
        MutableLiveData(CountryApiState.Loading)
    val countryApiState: LiveData<CountryApiState> = _countryApiState

    init {
        getCountries()
    }

    private fun getCountries() {
        viewModelScope.launch(dispatcher) {
            try {
                val response = useCase.getCountries(dispatcher)
                val sortedCountries = response.sortedBy { it.name }
                _countryApiState.postValue(CountryApiState.Success(sortedCountries))
            } catch (ex: Exception) {
                Log.d("Error", ex.message ?: "There was an error")
                _countryApiState.postValue(
                    CountryApiState.Failure("Error loading countries")
                )
            }
        }
    }
}