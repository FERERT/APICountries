package com.course.domain.di

import com.course.domain.usecase.GetCountriesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetCountriesUseCase(get()) }
}