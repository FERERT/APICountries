package com.course.data.networking

import com.course.data.dto.CountryDTO
import retrofit2.http.GET

interface CountryService {

    @GET(COUNTRY_API_ENDPOINT)
    suspend fun getCountries(): List<CountryDTO>

}