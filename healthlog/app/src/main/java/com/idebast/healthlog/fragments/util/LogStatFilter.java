package com.idebast.healthlog.fragments.util;

import com.idebast.healthlog.fragments.HealthDataSetEntry;
import com.idebast.healthlog.model.LogEntry;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class LogStatFilter {
    private ArrayList<LogEntry> mLogEntries;
    final int TIME_INTERVAL=15;
    private HealthDataSetEntry mHealthDataSetEntry;
    private LocalDateTime nextDateTime;
    private int mPosition;

    public LogStatFilter(ArrayList<LogEntry> logEntries) {
        mLogEntries = logEntries;
    }

    public int process (int position){
        LogEntry e = mLogEntries.get(position);

        LocalDateTime startDateTime = e.getTimestamp();
        LocalDateTime endDateTime = startDateTime.plusMinutes(TIME_INTERVAL);

        float gewicht = 0.0f;

        int nBovenDruk = 0;
        int maxBovenDruk = 0;
        int minBovenDruk = e.getBovendruk();
        int sumBovenDruk = 0;
        float gemBovenDruk = 0.0f;

        int nOnderDruk = 0 ;
        int maxOnderDruk = 0;
        int minOnderDruk = e.getOnderdruk();
        int sumOnderDruk = 0;
        float gemOnderDruk = 00f;

        int nPols = 0 ;
        int maxPols = 0;
        int minPols = mLogEntries.get(position).getPols();
        int sumPols = 0;
        float gemPols = 0.0f;

        String comment = "";

        nextDateTime = null; // volgende entry
        mHealthDataSetEntry = null;

        while ( (position < mLogEntries.size()) ) {
            e = mLogEntries.get(position);
            if ((e.getTimestamp().isBefore(endDateTime)) || (e.getTimestamp().isEqual(endDateTime))) {
                //if ((e.getTimestamp().isBefore(endDateTime)) || (e.getTimestamp().isEqual(endDateTime))){
                if (e.getBovendruk() != 0) { nBovenDruk++; sumBovenDruk = sumOnderDruk + e.getBovendruk(); }
                if (e.getBovendruk() > maxBovenDruk) { maxBovenDruk = e.getBovendruk(); }
                if (e.getBovendruk() < minBovenDruk) { minBovenDruk = e.getBovendruk(); }

                if (e.getOnderdruk() != 0) { nOnderDruk++; sumOnderDruk = sumOnderDruk + e.getOnderdruk(); }
                if (e.getOnderdruk() > maxOnderDruk) { maxOnderDruk = e.getOnderdruk(); }
                if (e.getOnderdruk() < minOnderDruk) { minOnderDruk = e.getOnderdruk(); }

                if (e.getPols() != 0) { nPols++; sumPols = sumPols + e.getPols(); }
                if (e.getPols() > maxPols) { maxPols = e.getPols(); }
                if (e.getPols() < minPols) { minPols = e.getPols(); }

                if (e.getComment() != null && !e.getComment().isEmpty()) { comment = e.getComment(); }

                if (e.getGewicht() != 0) { gewicht = (float) e.getGewicht(); }

                position++;
            } else {
                break;
            }
        }

        gemBovenDruk = (nBovenDruk != 0) ? (float) sumBovenDruk / (float) nBovenDruk : 0.0f;
        gemOnderDruk = (nOnderDruk != 0) ? (float) sumOnderDruk / (float) nOnderDruk : 0.0f;
        gemPols = (nPols != 0) ? (float) sumPols / (float) nPols : 0.0f;
        mHealthDataSetEntry = new HealthDataSetEntry(startDateTime, gewicht, minBovenDruk, maxBovenDruk, gemBovenDruk, minOnderDruk, maxOnderDruk, gemOnderDruk, minPols, maxPols, gemPols, comment);

        mPosition = position;
        return position;
    };

    public boolean hasNext () {
        return (mPosition < mLogEntries.size());
    };

    public HealthDataSetEntry result() {
        return mHealthDataSetEntry;
    }
}
