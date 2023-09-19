package se.joedst.day1.models;

import java.util.UUID;



public class Forecast {
    private UUID id;
    private int date; //20230821
    private int hour;

    //private String lastModifiedBy;

    //private boolean deleted; exempel på soft delete eller active, då när man updaterar om man vill ta bort den, så kan man bara ha en funktion som "avaktiverar" den


    private float temperature;

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
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}