package com.idebast.healthlog.fragments;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.idebast.healthlog.fragments.util.DateTimeConvertor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LineChartXAxisValueFormatter implements IAxisValueFormatter {
    private LocalDateTime newRefDateTime;

    public LineChartXAxisValueFormatter(LocalDateTime newRefDateTime) {
        this.newRefDateTime = newRefDateTime;
    }

    @Override
    public String getFormattedValue(float adt, AxisBase axis) {
        LocalDateTime date = DateTimeConvertor.newRefTodateTime ((long) adt, newRefDateTime);

        return date.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
    }
}
