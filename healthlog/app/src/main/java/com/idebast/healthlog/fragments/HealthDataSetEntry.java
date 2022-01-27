package com.idebast.healthlog.fragments;

import java.time.LocalDateTime;

public class HealthDataSetEntry {

    // public Date datumTijd;
    public LocalDateTime datumTijd=null;
    public float gewicht = 0.0f;
    public int minBovendruk = 0;
    public int maxBovendruk = 0;
    public float gemBovendruk =0.0f;

    public int maxOnderdruk = 0;
    public int minOnderdruk = 0;
    public float gemOnderdruk = 0.0f;

    public int maxPols = 0;
    public int minPols = 0;
    public float gemPols = 0;

    //final int glucose;
    public String opmerkingen = null;

    public void clear() {
        datumTijd = null;
        gewicht = 0.0f;
        maxBovendruk = 0;
        minBovendruk = 0;
        gemBovendruk = 0;

        maxOnderdruk = 0;
        minOnderdruk = 0;
        gemOnderdruk = 0;

        maxPols = 0;
        minPols = 0;
        gemPols = 0;

        opmerkingen = null;
    };

    public HealthDataSetEntry() {
    };

    public HealthDataSetEntry(LocalDateTime dt, float g, int minb, int maxb, float gemb, int mino, int maxo, float gemo, int minp, int maxp, float gemp, String s) {
        datumTijd = dt;
        gewicht = g;
        maxBovendruk = maxb;
        minBovendruk = minb;
        gemBovendruk = gemb;

        maxOnderdruk = maxo;
        minOnderdruk = mino;
        gemOnderdruk = gemo;

        maxPols = maxp;
        minPols = minp;
        gemPols = gemp;

        opmerkingen = s;
    }
}
