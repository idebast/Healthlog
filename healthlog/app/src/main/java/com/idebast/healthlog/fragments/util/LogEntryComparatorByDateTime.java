package com.idebast.healthlog.fragments.util;

import com.idebast.healthlog.model.LogEntry;

import java.util.Comparator;

// https://coderanch.com/t/676834/java/Sorting-ArrayList-Based-Columns
// https://stackoverflow.com/questions/24975167/java-how-to-use-compareto-to-sort-an-arraylist
public class LogEntryComparatorByDateTime implements Comparator<LogEntry> {
    @Override
    public int compare(LogEntry o1, LogEntry o2) {
        return o1.getTimestamp().compareTo(o2.getTimestamp());
    }
}
