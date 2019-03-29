/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.aisha;

import com.github.prominence.openweathermap.api.OpenWeatherMapManager;
import com.github.prominence.openweathermap.api.WeatherRequester;
import com.github.prominence.openweathermap.api.constants.Accuracy;
import com.github.prominence.openweathermap.api.constants.Language;
import com.github.prominence.openweathermap.api.constants.Unit;
import com.github.prominence.openweathermap.api.exception.DataNotFoundException;
import com.github.prominence.openweathermap.api.exception.InvalidAuthTokenException;
import com.github.prominence.openweathermap.api.model.response.Weather;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ajay
 */
public class WeatherMethods {
    Weather weatherResponse;
    public String getMyWeather()
    {
        
        try {
            OpenWeatherMapManager openWeatherManager = new OpenWeatherMapManager("f4df9c1aed9db5ffc8bb586450e8a36f");
            WeatherRequester weatherRequester = openWeatherManager.getWeatherRequester();
            
            weatherResponse = weatherRequester.setLanguage(Language.ENGLISH)
                    .setUnitSystem(Unit.METRIC_SYSTEM)
                    .setAccuracy(Accuracy.ACCURATE)
                    .getByCityName("Noida");           
        } catch (InvalidAuthTokenException | DataNotFoundException ex) {
            Logger.getLogger(Test11.class.getName()).log(Level.SEVERE, null, ex);
        }
        String unit=String.valueOf(weatherResponse.getTemperatureUnit()); 
       String temp= String.valueOf(weatherResponse.getTemperature()) ;
       //String info=String.valueOf(weatherResponse.getWeatherInfo());
       return temp+" "+unit;
    }
    
}
