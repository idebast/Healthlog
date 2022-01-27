package com.idebast.healthlog.model;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class LogEntry {

    private String comment;
    private Integer bovendruk,onderdruk,pols;
    private String datum;
    private String time;
    private LocalDateTime timestamp;
    private float gewicht;

    public LogEntry() {
        comment = "";
        bovendruk = 0;
        onderdruk = 0;
        pols = 0;
        datum = "";
        time = "";
        timestamp = LocalDateTime.ofEpochSecond(0, 0, ZoneOffset.UTC);
        gewicht = 0.0f;
    }

    // FIXME: to be removed?
    public LogEntry(String datum, String time, float gewicht, Integer bovendruk, Integer onderdruk, Integer pols, String comment) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        this.datum = datum;
        this.time = time;
        this.timestamp = LocalDateTime.parse(String.format("%s %s:00", datum, time), formatter);
        this.gewicht = gewicht;
        this.bovendruk=bovendruk;
        this.onderdruk = onderdruk;
        this.pols = pols;
        this.comment = comment;
    }

    public LogEntry(LocalDateTime timestamp, float gewicht, Integer bovendruk, Integer onderdruk, Integer pols, String comment) {

        this.timestamp = timestamp;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.datum = timestamp.format(formatter);

        formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.time = timestamp.format(formatter);

        this.gewicht = gewicht;
        this.bovendruk=bovendruk;
        this.onderdruk = onderdruk;
        this.pols = pols;
        this.comment = comment;
    }


    public String getTime() { return this.time; }
    public void setTime(String time) { this.time = time; }

    public String getComment() { return this.comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Integer getBovendruk() { return bovendruk; }
    public void setBovendruk(Integer bovendruk) { this.bovendruk = bovendruk; }

    public Integer getOnderdruk() {
        return onderdruk;
    }
    public void setOnderdruk(Integer onderdruk) {
        this.onderdruk = onderdruk;
    }

    public Integer getPols() {
        return pols;
    }
    public void setPols(Integer pols) {
        this.pols = pols;
    }

    public String getDatum() {
        return datum;
    }
    public void setDatum(String datum) {
        this.datum = datum;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public float getGewicht() {
        return gewicht;
    }
    public void setGewicht(float gewicht) {
        this.gewicht = gewicht;
    }
}
