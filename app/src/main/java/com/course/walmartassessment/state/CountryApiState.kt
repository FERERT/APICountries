package com.course.walmartassessment.state

sealed class CountryApiState {

    data class Success(val countries: List<com.course.domain.model.Country>): CountryApiState()
    data class Failure(val errorMessage: String): CountryApiState()
    data object Loading: CountryApiState()

}