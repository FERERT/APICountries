package com.course.data.repository

import com.course.data.dto.CountryDTO
import com.course.data.networking.CountryApiClient
import com.course.data.networking.CountryService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

interface CountryRepository {
    suspend fun getCountries(dispatcher: CoroutineDispatcher): List<CountryDTO>
}

class CountryRepositoryImpl(
    private val countryService: CountryService = CountryApiClient.countryService
): CountryRepository {

    override suspend fun getCountries(
        dispatcher: CoroutineDispatcher
    ): List<CountryDTO> {
        return withContext(dispatcher) {
            countryService.getCountries()
        }
    }
}