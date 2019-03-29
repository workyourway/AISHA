/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.aisha;

import com.github.prominence.openweathermap.api.DailyForecastRequester;
import com.github.prominence.openweathermap.api.OpenWeatherMapManager;
import com.github.prominence.openweathermap.api.WeatherRequester;
import com.github.prominence.openweathermap.api.constants.Accuracy;
import com.github.prominence.openweathermap.api.constants.Language;
import com.github.prominence.openweathermap.api.constants.Unit;
import com.github.prominence.openweathermap.api.exception.DataNotFoundException;
import com.github.prominence.openweathermap.api.exception.InvalidAuthTokenException;
import com.github.prominence.openweathermap.api.model.response.DailyForecast;
import com.github.prominence.openweathermap.api.model.response.Weather;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author Ajay
 */
public class Test11 {
    public static void main(String []ar) throws InvalidAuthTokenException
    {
        try {
            OpenWeatherMapManager openWeatherManager = new OpenWeatherMapManager("f4df9c1aed9db5ffc8bb586450e8a36f");
            WeatherRequester weatherRequester = openWeatherManager.getWeatherRequester();
            
            Weather weatherResponse = weatherRequester.setLanguage(Language.ENGLISH)
                    .setUnitSystem(Unit.METRIC_SYSTEM)
                    .setAccuracy(Accuracy.ACCURATE)
                    .getByCityName("Noida");
           System.out.println(weatherResponse.getTemperature()+" "+weatherResponse.getTemperatureUnit());
           //System.out.println(weatherResponse.getWeatherSystemInfo());
          String test=weatherResponse.getWeatherInfo().toString();
          String test1[]=test.split(";");
          
            for (String test11 : test1) {
                System.out.println(test11);
            }
          System.out.println(test1.length);
          
            /* System.out.println(weatherResponse.getClouds());
            //System.out.println(weatherResponse.getDataCalculationDate().toString());
            System.out.println(weatherResponse.getResponseCode());
            System.out.println(weatherResponse.getPressure()+" "+weatherResponse.getPressureUnit());
            System.out.println(weatherResponse.getHumidityPercentage());*/
        } catch (InvalidAuthTokenException | DataNotFoundException ex) {
            Logger.getLogger(Test11.class.getName()).log(Level.SEVERE, null, ex);
        }
       /* OpenWeatherMapManager openWeatherManager = new OpenWeatherMapManager("ae0517369cad91b97ae115ac95178fd2");
        DailyForecastRequester forecastRequester = openWeatherManager.getDailyForecastRequester();
        try {
            System.out.println( forecastRequester.setAmountOfDays(3).getByCoordinates(28.5726, 77.3548));
        } catch (DataNotFoundException ex) {
            Logger.getLogger(Test11.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    
}
