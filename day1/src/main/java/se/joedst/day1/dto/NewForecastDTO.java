package se.joedst.day1.dto;

import java.util.UUID;

public class NewForecastDTO { //Ej extends för extends är ju det från en class plus yttligare, DTO är lite sudo?

    public UUID id;
    public int date; //20230821
    public int hour;

    public float Temperature;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public float getTemperature() {
        return Temperature;
    }

    public void setTemperature(float temperature) {
        Temperature = temperature;
    }
}


//DTO Data Transfer Object - massa egenskaper, inte lika mycket logik, public kan vara ok här
//Bara till för att flytta info från en plats till en annan
//Min max values här, validering