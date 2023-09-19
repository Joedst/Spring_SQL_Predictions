package se.joedst.day1.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.joedst.day1.dto.NewForecastDTO;
import se.joedst.day1.models.Forecast;
import se.joedst.day1.services.ForecastService;

import java.io.IOException;
import java.util.Optional;

import java.util.List;
import java.util.UUID;
// ALLT SOM SPRING CARRYAR NEDAN
// Client anropar api/forecast GET
// Spring kollar vilken funktion som hanterar api/forecast
// Spring anropar funktion
// (vår kod körs)
// Spring tar det som funktionen returnerar och gör till JSON
// Spring skickar tillbaka JSON till client

@RestController
public class ForecastController {

    @Autowired
    private ForecastService forecastService;


    @GetMapping("/api/forecasts") //GetMapping = http get
    public ResponseEntity<List<Forecast>> GetAll(){ //ResponseEntity = ett objekt som blir JSON samt en http status code
        return new ResponseEntity<>(forecastService.getForecasts(), HttpStatus.OK);
    }


    @GetMapping("/api/forecasts/{id}")
    public ResponseEntity<Forecast> Get(@PathVariable UUID id){
        Optional<Forecast> forecast = forecastService.get(id);
        if(forecast.isPresent()) return ResponseEntity.ok(forecast.get());
        return  ResponseEntity.notFound().build();
    }

    @PutMapping("/api/forecasts/{id}")
    public ResponseEntity<Forecast> Update(@PathVariable UUID id, @RequestBody NewForecastDTO newForecastDTO) throws IOException, IOException {


        //mappa från DTO -> entity
        var forecast = new Forecast();
        forecast.setId(id); //Förut så togs id från postman men nu här
        forecast.setDate(newForecastDTO.getDate());
        forecast.setHour(newForecastDTO.getHour());
        forecast.setTemperature(newForecastDTO.getTemperature());
        forecastService.update(forecast);

        forecastService.update(forecast);
        return ResponseEntity.ok(forecast);
    }

    @PostMapping("/api/forecasts")
    public ResponseEntity<Forecast> New( @RequestBody Forecast forecast) throws IOException { // id
        var newCreated = forecastService.add(forecast);
        return ResponseEntity.ok(newCreated); // mer REST ful = created (204) samt url till produkten
    }


}


//Ej spara SMHI i databas, bara ta emot data hit, och skicka ut predictions till databas bara
//Hämta data från en valfri open API provider

//Ett api som returnerar snittet av alla registreringar vald dag

//Ska hämta från två källor tex för att hämta en average som är predictionen vg
//Bara konsollen kommer att uppdatera ej postman pga att listan finns i
//Validering så man inte kan knappa in vad som helst vart som helst min o max