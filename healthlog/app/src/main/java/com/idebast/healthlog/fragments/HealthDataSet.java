package com.idebast.healthlog.fragments;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class HealthDataSet {
    public static ArrayList<HealthDataSetEntry> data;

    public static void fillDataSet() throws ParseException {
        data = new ArrayList<HealthDataSetEntry>();

        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-10-25T22:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 119, 123, 121.7f, 77, 79, 77.7f, 68, 70, 69.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-10-26T08:00:00", DateTimeFormatter.ISO_DATE_TIME), 87.7f, 126, 132, 129.0f, 82, 86, 83.7f, 77, 79, 78.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-10-26T16:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 133, 145, 139.7f, 82, 85, 83.0f, 60, 63, 61.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-10-26T18:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 128, 140, 132.7f, 81, 89, 83.7f, 65, 68, 66.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-10-26T22:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 133, 141, 136.3f, 87, 88, 87.3f, 62, 65, 64.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-10-27T09:30:00", DateTimeFormatter.ISO_DATE_TIME), 87.3f, 126, 137, 131.0f, 84, 90, 86.7f, 83, 85, 84.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-10-27T19:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 121, 133, 126.3f, 85, 89, 86.3f, 73, 75, 74.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-10-28T09:30:00", DateTimeFormatter.ISO_DATE_TIME), 86.5f, 123, 127, 125.3f, 81, 87, 83.3f, 76, 78, 77.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-10-28T15:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 117, 124, 120.0f, 80, 81, 80.7f, 70, 76, 72.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-10-28T22:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 129, 138, 132.3f, 85, 90, 87.3f, 66, 70, 67.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-10-29T16:00:00", DateTimeFormatter.ISO_DATE_TIME), 86.1f, 109, 115, 112.8f, 74, 80, 77.3f, 64, 68, 65.8f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-10-29T19:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 114, 126, 119.3f, 79, 81, 80.0f, 71, 74, 72.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-10-29T22:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 115, 123, 118.7f, 79, 81, 80.3f, 72, 76, 74.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-10-30T22:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 116, 139, 126.3f, 71, 89, 81.0f, 71, 75, 72.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-10-31T15:00:00", DateTimeFormatter.ISO_DATE_TIME), 85.4f, 115, 116, 115.7f, 80, 84, 82.0f, 69, 71, 70.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-10-31T21:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 116, 119, 117.7f, 84, 90, 86.3f, 71, 78, 74.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-01T15:00:00", DateTimeFormatter.ISO_DATE_TIME), 85.3f, 103, 107, 105.7f, 76, 81, 78.0f, 73, 74, 73.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-01T20:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 103, 113, 109.7f, 73, 76, 74.3f, 79, 83, 80.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-02T15:00:00", DateTimeFormatter.ISO_DATE_TIME), 84.9f, 107, 109, 107.7f, 75, 77, 76.0f, 68, 70, 69.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-02T23:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 119, 130, 126.0f, 77, 86, 81.7f, 68, 69, 68.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-03T15:00:00", DateTimeFormatter.ISO_DATE_TIME), 84.4f, 111, 119, 114.3f, 73, 78, 75.7f, 77, 78, 77.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-03T20:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 113, 123, 116.7f, 75, 78, 76.0f, 73, 77, 74.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-04T22:30:00", DateTimeFormatter.ISO_DATE_TIME), 84.5f, 105, 112, 108.3f, 70, 74, 72.3f, 63, 69, 65.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-05T15:00:00", DateTimeFormatter.ISO_DATE_TIME), 84.5f, 123, 130, 127.3f, 77, 85, 81.0f, 65, 70, 67.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-05T22:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 108, 110, 109.0f, 70, 73, 71.3f, 66, 67, 66.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-06T12:30:00", DateTimeFormatter.ISO_DATE_TIME), 84.4f, 114, 117, 115.3f, 72, 79, 75.3f, 71, 76, 73.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-06T19:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 116, 122, 118.0f, 71, 72, 71.7f, 68, 70, 69.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-07T12:00:00", DateTimeFormatter.ISO_DATE_TIME), 84.3f, 124, 126, 125.0f, 78, 81, 80.0f, 75, 80, 78.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-07T19:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 102, 117, 108.7f, 66, 71, 68.0f, 74, 76, 75.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-07T22:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 103, 116, 109.7f, 71, 74, 72.3f, 63, 70, 65.7f, ""));
        //database.add(new DatabaseEntry(LocalDateTime.parse("2021-11-08T00:00:00", DateTimeFormatter.ISO_DATE_TIME), 84.1f, , , , , , , , , , ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-09T20:00:00", DateTimeFormatter.ISO_DATE_TIME), 84.2f, 123, 132, 127.3f, 75, 80, 77.7f, 62, 67, 64.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-10T13:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 129, 134, 132.3f, 83, 86, 84.7f, 58, 62, 60.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-10T19:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 111, 114, 112.7f, 75, 76, 75.3f, 72, 74, 73.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-11T15:00:00", DateTimeFormatter.ISO_DATE_TIME), 83.7f, 110, 117, 113.7f, 74, 77, 75.0f, 64, 79, 70.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-11T22:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 115, 117, 116.0f, 78, 80, 78.7f, 62, 64, 63.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-12T15:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 112, 115, 113.0f, 75, 75, 75.0f, 64, 71, 66.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-13T20:00:00", DateTimeFormatter.ISO_DATE_TIME), 83.5f, 103, 104, 103.7f, 66, 71, 67.7f, 57, 63, 60.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-13T22:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 111, 118, 114.0f, 71, 74, 72.3f, 61, 63, 62.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-14T12:00:00", DateTimeFormatter.ISO_DATE_TIME), 83.4f, 116, 124, 119.3f, 76, 81, 78.3f, 65, 71, 67.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-14T15:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 109, 120, 116.0f, 72, 77, 74.7f, 61, 65, 62.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-14T20:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 106, 117, 112.0f, 70, 77, 73.3f, 61, 63, 61.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-14T22:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 115, 119, 117.0f, 73, 80, 75.7f, 60, 66, 63.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-15T19:30:00", DateTimeFormatter.ISO_DATE_TIME), 83.4f, 108, 116, 111.0f, 72, 74, 72.7f, 60, 69, 64.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-15T23:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 100, 104, 102.3f, 66, 70, 67.7f, 63, 68, 65.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-16T12:00:00", DateTimeFormatter.ISO_DATE_TIME), 83.1f, 111, 114, 113.0f, 76, 79, 78.0f, 71, 79, 73.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-16T17:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 103, 110, 106.3f, 70, 75, 73.0f, 60, 62, 61.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-16T22:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 104, 115, 110.0f, 72, 73, 72.3f, 62, 65, 63.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-17T12:00:00", DateTimeFormatter.ISO_DATE_TIME), 83.0f, 111, 122, 115.0f, 81, 83, 82.0f, 82, 89, 85.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-17T20:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 100, 109, 104.3f, 64, 70, 67.7f, 65, 80, 70.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-18T12:00:00", DateTimeFormatter.ISO_DATE_TIME), 83.1f, 110, 123, 115.7f, 79, 83, 81.3f, 72, 75, 73.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-18T15:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 92, 103, 99.0f, 65, 72, 69.0f, 71, 76, 73.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-18T18:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 102, 104, 103.0f, 69, 72, 70.5f, 69, 76, 72.5f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-18T22:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 102, 108, 105.7f, 69, 72, 70.3f, 62, 73, 66.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-19T11:00:00", DateTimeFormatter.ISO_DATE_TIME), 82.8f, 113, 117, 114.7f, 77, 80, 78.3f, 69, 79, 73.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-19T17:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 106, 118, 113.0f, 77, 84, 81.3f, 72, 90, 78.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-19T22:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 118, 122, 120.7f, 87, 89, 87.7f, 75, 96, 82.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-20T12:00:00", DateTimeFormatter.ISO_DATE_TIME), 82.2f, 115, 131, 123.7f, 88, 92, 90.3f, 83, 104, 90.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-20T22:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 95, 102, 99.0f, 68, 71, 69.7f, 65, 90, 74.0f, "95/70: outlier?"));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-21T12:00:00", DateTimeFormatter.ISO_DATE_TIME), 82.3f, 104, 116, 109.7f, 77, 83, 80.7f, 74, 92, 80.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-21T17:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 93, 108, 101.3f, 69, 71, 70.0f, 60, 76, 66.3f, "93/70: outlier?"));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-21T22:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 99, 104, 101.3f, 67, 73, 69.7f, 69, 81, 73.3f, ""));
        //database.add(new DatabaseEntry(LocalDateTime.parse("2021-11-22T00:00:00", DateTimeFormatter.ISO_DATE_TIME), 82.4f, , , , , , , , , , "endocrino: stop keto,  spiro,  bipressil"));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-23T17:00:00", DateTimeFormatter.ISO_DATE_TIME), 81.8f, 112, 115, 113.7f, 85, 86, 85.3f, 86, 91, 88.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-24T14:00:00", DateTimeFormatter.ISO_DATE_TIME), 81.7f, 123, 137, 129.3f, 90, 94, 92.3f, 92, 122, 102.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-24T22:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 124, 127, 125.7f, 90, 97, 94.0f, 89, 98, 92.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-25T10:00:00", DateTimeFormatter.ISO_DATE_TIME), 81.7f, 131, 144, 139.7f, 89, 95, 91.0f, 91, 95, 92.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-25T16:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 133, 143, 136.3f, 87, 91, 89.0f, 72, 87, 77.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-26T11:00:00", DateTimeFormatter.ISO_DATE_TIME), 81.3f, 120, 135, 127.0f, 88, 94, 91.3f, 74, 99, 83.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-26T16:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 139, 148, 143.3f, 92, 94, 93.0f, 64, 78, 70.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-26T22:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 137, 142, 139.0f, 86, 91, 88.3f, 61, 72, 65.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-27T11:30:00", DateTimeFormatter.ISO_DATE_TIME), 81.1f, 135, 142, 138.7f, 93, 95, 93.7f, 65, 69, 67.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-27T23:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 139, 148, 142.3f, 90, 92, 91.3f, 78, 90, 82.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-28T12:30:00", DateTimeFormatter.ISO_DATE_TIME), 81.8f, 132, 139, 136.3f, 82, 83, 82.3f, 54, 61, 58.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-28T20:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 147, 148, 147.7f, 91, 92, 91.7f, 62, 72, 65.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-28T22:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 148, 155, 151.3f, 90, 93, 91.3f, 61, 69, 64.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-29T15:30:00", DateTimeFormatter.ISO_DATE_TIME), 81.8f, 144, 154, 150.0f, 90, 96, 93.0f, 60, 63, 61.3f, "start amlodipine 5mg"));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-29T22:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 142, 143, 142.7f, 88, 89, 88.3f, 61, 72, 65.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-30T12:00:00", DateTimeFormatter.ISO_DATE_TIME), 81.2f, 137, 148, 143.3f, 89, 92, 90.3f, 61, 71, 65.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-30T18:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 140, 147, 144.3f, 83, 90, 87.0f, 52, 63, 56.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-11-30T22:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 149, 161, 153.0f, 85, 96, 88.7f, 52, 56, 53.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-01T10:30:00", DateTimeFormatter.ISO_DATE_TIME), 80.9f, 132, 151, 139.3f, 79, 90, 84.0f, 60, 64, 61.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-01T21:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 154, 160, 157.7f, 90, 92, 90.7f, 59, 74, 64.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-01T23:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 135, 146, 141.0f, 88, 91, 89.3f, 64, 77, 68.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-02T09:00:00", DateTimeFormatter.ISO_DATE_TIME), 81.0f, 118, 132, 125.7f, 80, 87, 83.0f, 64, 87, 77.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-02T16:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 135, 147, 142.7f, 84, 89, 86.7f, 54, 57, 55.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-02T23:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 137, 144, 141.7f, 92, 95, 93.3f, 77, 87, 82.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-03T17:00:00", DateTimeFormatter.ISO_DATE_TIME), 80.6f, 117, 134, 124.7f, 86, 92, 88.3f, 89, 90, 89.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-03T21:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 143, 148, 145.0f, 81, 85, 82.3f, 57, 58, 57.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-03T23:45:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 128, 144, 136.7f, 83, 90, 87.7f, 56, 60, 57.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-04T10:00:00", DateTimeFormatter.ISO_DATE_TIME), 80.7f, 120, 124, 122.7f, 75, 78, 76.7f, 62, 71, 67.3f, "start preventief movicol"));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-04T16:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 134, 146, 140.0f, 82, 89, 84.3f, 62, 68, 64.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-04T21:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 132, 144, 139.3f, 80, 85, 83.0f, 60, 66, 62.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-05T10:00:00", DateTimeFormatter.ISO_DATE_TIME), 81.6f, 118, 133, 125.7f, 79, 83, 81.3f, 78, 82, 80.7f, ""));
        //database.add(new DatabaseEntry(LocalDateTime.parse("2021-12-06T06:00:00", DateTimeFormatter.ISO_DATE_TIME), 81.9f, , , , , , , , , , ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-07T16:30:00", DateTimeFormatter.ISO_DATE_TIME), 82.0f, 113, 124, 118.3f, 78, 83, 80.0f, 84, 85, 84.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-09T08:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 0, 0, 0.0f, 0, 0, 0.0f, 0, 0, 0.0f, "operatie"));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-15T16:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 132, 143, 139.3f, 91, 95, 92.7f, 88, 99, 91.7f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-16T19:00:00", DateTimeFormatter.ISO_DATE_TIME), 86.3f, 150, 164, 155.7f, 88, 89, 88.7f, 70, 71, 70.5f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-17T10:30:00", DateTimeFormatter.ISO_DATE_TIME), 86.4f, 137, 164, 151.3f, 87, 89, 88.3f, 70, 71, 70.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-17T17:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 135, 157, 145.3f, 89, 96, 91.0f, 71, 78, 75.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-18T11:00:00", DateTimeFormatter.ISO_DATE_TIME), 85.8f, 122, 133, 127.0f, 82, 88, 85.0f, 61, 67, 64.8f, "Stop amlor,  restart bipressil 0.5mg,  2x100mg spiro"));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-18T16:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 137, 146, 141.7f, 80, 85, 82.7f, 58, 69, 61.8f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-18T21:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 137, 144, 141.0f, 88, 94, 90.7f, 64, 72, 68.8f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-19T10:30:00", DateTimeFormatter.ISO_DATE_TIME), 84.1f, 129, 139, 133.3f, 84, 89, 86.3f, 64, 68, 65.8f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-19T17:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 122, 129, 125.0f, 76, 80, 78.3f, 62, 68, 65.5f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-20T10:00:00", DateTimeFormatter.ISO_DATE_TIME), 82.4f, 131, 139, 136.3f, 86, 91, 88.0f, 65, 68, 67.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-20T20:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 119, 130, 124.7f, 74, 77, 76.0f, 62, 67, 64.5f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-21T10:30:00", DateTimeFormatter.ISO_DATE_TIME), 80.9f, 112, 122, 117.7f, 77, 82, 79.3f, 59, 65, 62.5f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-23T17:30:00", DateTimeFormatter.ISO_DATE_TIME), 79.6f, 123, 133, 127.7f, 71, 78, 74.0f, 57, 72, 61.5f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-24T10:00:00", DateTimeFormatter.ISO_DATE_TIME), 79.8f, 117, 130, 124.0f, 70, 79, 75.3f, 61, 73, 69.3f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-25T11:30:00", DateTimeFormatter.ISO_DATE_TIME), 80.5f, 140, 152, 145.7f, 78, 91, 84.7f, 60, 65, 61.5f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-25T18:30:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 120, 134, 127.0f, 69, 77, 72.0f, 62, 67, 64.5f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-26T14:30:00", DateTimeFormatter.ISO_DATE_TIME), 81.6f, 127, 135, 131.0f, 74, 79, 77.3f, 60, 70, 63.5f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-26T20:00:00", DateTimeFormatter.ISO_DATE_TIME), 0.0f, 131, 149, 139.7f, 74, 83, 79.3f, 64, 82, 70.0f, ""));
        data.add(new HealthDataSetEntry(LocalDateTime.parse("2021-12-27T17:30:00", DateTimeFormatter.ISO_DATE_TIME), 81.0f, 104, 117, 111.0f, 65, 70, 67.3f, 82, 85, 84.0f, ""));
    }

}
