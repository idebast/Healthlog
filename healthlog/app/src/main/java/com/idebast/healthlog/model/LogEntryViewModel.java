package com.idebast.healthlog.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class LogEntryViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<LogEntry>> entries;

    public LogEntryViewModel(@NonNull Application application) {
        super(application);
        entries = new MutableLiveData<>(setupLogEntries());
    }

    private ArrayList<LogEntry> setupLogEntries() {
        ArrayList<LogEntry> neededForEntries = new ArrayList<>();
        neededForEntries.add(new LogEntry("21/10/22","08:00",75.5f,112,90, 99,"lichtgroen"));
        neededForEntries.add(new LogEntry());
        neededForEntries.add(new LogEntry());

        return neededForEntries;
    }

    public MutableLiveData<ArrayList<LogEntry>> getEntries() {
        return entries;
    }

    public void insert(LogEntry l){
        ArrayList<LogEntry> tempList = entries.getValue();
        tempList.add(l);
        entries.setValue(tempList);
    }
}
