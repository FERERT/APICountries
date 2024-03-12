package com.course.domain.model

import com.course.data.dto.CountryDTO

data class Country(
    val name: String,
    val region: String,
    val code: String,
    val capital: String
)

fun transformCountryDTO(countryDTO: CountryDTO): Country {
    return Country(countryDTO.name, countryDTO.region, countryDTO.code, countryDTO.capital)
}
