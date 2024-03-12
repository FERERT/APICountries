package com.course.domain.usecase

import com.course.data.repository.CountryRepository
import com.course.data.repository.CountryRepositoryImpl
import com.course.domain.model.Country
import com.course.domain.model.transformCountryDTO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class GetCountriesUseCase(private val repository: CountryRepository) {

    suspend fun getCountries(dispatcher: CoroutineDispatcher = Dispatchers.IO): List<Country> {
        val countryDTOList = repository.getCountries(dispatcher)
        return countryDTOList.map { transformCountryDTO(it) }
    }

}