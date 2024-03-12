package com.course.walmartassessment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.course.domain.model.Country
import com.course.domain.usecase.GetCountriesUseCase
import com.course.walmartassessment.state.CountryApiState.Success
import com.course.walmartassessment.viewmodel.MainViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @MockK
    private lateinit var useCase: GetCountriesUseCase

    private lateinit var viewModel: MainViewModel
    private val dispatcher: CoroutineDispatcher = Dispatchers.Unconfined

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `should return list from use case`() = runTest {
        val country = Country("Spain", "EU", "SP", "Madrid")
        coEvery { useCase.getCountries(any()) } returns listOf(country)
        viewModel = MainViewModel(useCase, dispatcher)
        assertEquals(country, (viewModel.countryApiState.value as Success).countries.first())
    }

}