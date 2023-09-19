package se.joedst.day1.controllers;


import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se.joedst.day1.models.Forecast;
import se.joedst.day1.services.ForecastService;

import java.util.List;
import java.util.UUID;
// Client anropar api/forecast GET
// Spring kollar vilken funktion som hanterar api/forecast
// Spring anropar funktion
// (vår kod körs)
//Spring tar det som funktionen returnerar och gör till JSON
//Spring skickar tillbaka JSON till client

@RestController
public class ForecastController {

    @Autowired
    private ForecastService forecastService;

/*
    @GetMapping("/api/products/{id}")
    public ResponseEntity<Forecast> Get(@PathVariable UUID id){
        Optional<Forecast> product = ForecastService.getById(id);
        if(product.isPresent()) return ResponseEntity.ok(product.get());
        return  ResponseEntity.notFound().build();
    }

 */




    @GetMapping("/api/forecasts") //GetMapping = http get
    public ResponseEntity<List<Forecast>> GetAll(){ //ResponseEntity = ett objekt som blir JSON samt en http status code
        return new ResponseEntity<>(forecastService.getForecasts(), HttpStatus.OK);
    }



}


//Ej spara SMHI i databas, bara ta emot data hit, och skicka ut predictions till databas bara