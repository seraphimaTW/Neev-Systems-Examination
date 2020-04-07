package wininfosys.sdet.exam.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import wininfosys.sdet.exam.helper.RestCountry;

import java.io.IOException;
import java.util.Arrays;

public class RestCountriesClient {
    private static final String REST_COUNTRIES_ENDPOINT = "https://restcountries.eu/rest/v2/";
    private static final ObjectMapper MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public RestCountry obtainCountryInfoByName(String countryName) throws IOException, UnirestException {
        String uri = REST_COUNTRIES_ENDPOINT + "name/" + countryName;
        HttpResponse<String> response = Unirest.get(uri).queryString("fields", "name;capital").asString();
        if (response.getStatus() == 404) {
            throw new CountryNotFoundException();
        }
        RestCountry[] countries = MAPPER.readValue(response.getRawBody(), RestCountry[].class);
        return Arrays.stream(countries).filter(it -> it.name.toUpperCase().equals(countryName.toUpperCase())).findFirst().get();
    }

    public RestCountry obtainCountryInfoByCode(String countryCode) throws UnirestException, IOException {
        String uri = REST_COUNTRIES_ENDPOINT + "alpha/" + countryCode;
        HttpResponse<String> response = Unirest.get(uri).queryString("fields", "name;capital").asString();
        if (response.getStatus() == 404) {
            throw new CountryNotFoundException();
        }
        return MAPPER.readValue(response.getRawBody(), RestCountry.class);
    }
}
