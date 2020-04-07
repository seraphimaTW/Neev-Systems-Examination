package wininfosys.sdet.exam

import io.mockk.every
import io.mockk.mockk
import wininfosys.sdet.exam.client.RestCountriesClient
import wininfosys.sdet.exam.helper.RestCountriesHelper
import wininfosys.sdet.exam.helper.RestCountry
import org.junit.jupiter.api.Test

import kotlin.test.assertEquals

class ExaminationTest {
    companion object {
        const val COUNTRY_TEST_NAME = "test-country-name"
        const val CAPITAL_TEST_NAME = "test-capital-name"
    }
        private val mockkRestCountriesClient = mockk<RestCountriesClient>(relaxUnitFun = true) {
        every { obtainCountryInfoByName(any()) } returns RestCountry(COUNTRY_TEST_NAME, CAPITAL_TEST_NAME)
        every { obtainCountryInfoByCode(any()) } returns RestCountry(COUNTRY_TEST_NAME, CAPITAL_TEST_NAME)
    }

    @Test
    fun `get capital city name by country name`() {
        val restCountriesHelper = RestCountriesHelper(mockkRestCountriesClient)
        assertEquals(CAPITAL_TEST_NAME, restCountriesHelper.getCapitalByCountryName("test"))
    }

    @Test
    fun `get capital city name by country code`() {
        val restCountriesHelper = RestCountriesHelper(mockkRestCountriesClient)
        assertEquals(CAPITAL_TEST_NAME, restCountriesHelper.getCapitalByCountryCode("tt"))
    }
}