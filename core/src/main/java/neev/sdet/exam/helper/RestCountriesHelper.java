package neev.sdet.exam.helper;

import com.mashape.unirest.http.exceptions.UnirestException;
import neev.sdet.exam.client.RestCountriesClient;
import java.io.IOException;

public class RestCountriesHelper {
    private RestCountriesClient restCountriesClient;

    public RestCountriesHelper() {
        this.restCountriesClient = new RestCountriesClient();
    }

    public RestCountriesHelper(RestCountriesClient restCountriesClient) {
        this.restCountriesClient = restCountriesClient;
    }

    public String getCapitalByCountryName(String countryName) throws IOException, UnirestException {
        RestCountry restCountry = restCountriesClient.obtainCountryInfoByName(countryName);
        return restCountry.capital;
    }

    public String getCapitalByCountryCode(String countryCode) throws IOException, UnirestException {
        RestCountry restCountry = restCountriesClient.obtainCountryInfoByCode(countryCode);
        return restCountry.capital;
    }
}
