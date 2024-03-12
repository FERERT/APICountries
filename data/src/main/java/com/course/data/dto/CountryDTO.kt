package com.course.data.dto

import com.google.gson.annotations.Expose

data class CountryDTO(
    @Expose
    val name: String,
    @Expose
    val region: String,
    @Expose
    val code: String,
    @Expose
    val capital: String
)