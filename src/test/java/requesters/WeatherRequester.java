package requesters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.WeatherResponse;
import org.springframework.web.client.RestTemplate;

public class WeatherRequester {
    private final String PREFIX = "https://samples.openweathermap.org/data/2.5/weather?id=";
    private final String POSTFIX = "&appid=b1b15e88fa797225412429c1c50c122a1";

    public WeatherResponse requestWeather(int cityId) throws JsonProcessingException {
        final String URL = PREFIX + cityId + POSTFIX;

        //Request weather & get response
        RestTemplate restTemplate = new RestTemplate();
        String jsonToParse = restTemplate.getForEntity(URL, String.class).getBody();

        //Map JSON to our model (to WeatherResponse)
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonToParse, WeatherResponse.class);
    }
}
