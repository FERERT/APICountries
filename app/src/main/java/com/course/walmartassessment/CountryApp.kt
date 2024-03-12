package com.course.walmartassessment

import android.app.Application
import com.course.domain.di.repositoryModule
import com.course.domain.di.useCaseModule
import com.course.walmartassessment.di.viewModelModule
import org.koin.core.context.startKoin

class CountryApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(repositoryModule)
            modules(useCaseModule)
            modules(viewModelModule)
        }
    }

}