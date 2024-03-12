package com.course.data.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CountryApiClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl(COUNTRY_API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val countryService: CountryService = retrofit.create(CountryService::class.java)

}