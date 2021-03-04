package stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.Map;

public class WeatherStepDefs {
    private int cityId;
    private WeatherResponse response;

    @Given("city id: {int}")
    public void set_city_id(int cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityId);
    }

    @Then("lon is: {double}")
    public void check_lon(double lon) {
        Assertions.assertEquals(lon, response.getCoord().getLon(), "Wrong Lon!");
    }

    @Then("lat is: {double}")
    public void check_lat(double lat) {
        Assertions.assertEquals(lat, response.getCoord().getLat(), "Wrong Lat!");
    }

    @Then("weather is:")
    public void check_weather(Map<String, String> params) {
        Assertions.assertEquals(Integer.parseInt(params.get("id")), response.getWeathers().get(0).getId(), "Wrong Weather ID");
        Assertions.assertEquals(params.get("main"), response.getWeathers().get(0).getMain(), "Wrong Weather Main");
        //....
    }
}
