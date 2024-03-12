package com.course.domain.di

import com.course.data.repository.CountryRepository
import com.course.data.repository.CountryRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<CountryRepository> { CountryRepositoryImpl() }
}