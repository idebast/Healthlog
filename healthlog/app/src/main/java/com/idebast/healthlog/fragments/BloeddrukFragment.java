package com.idebast.healthlog.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.idebast.healthlog.R;
import com.idebast.healthlog.fragments.util.DateTimeConvertor;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BloeddrukFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BloeddrukFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    LocalDateTime newRefDateTime;

    public BloeddrukFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BloeddrukFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BloeddrukFragment newInstance(String param1, String param2) {
        BloeddrukFragment fragment = new BloeddrukFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bloeddruk, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CombinedChart chart;

        chart = view.findViewById(R.id.bloeddrukChart);

        chart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.LINE, // DrawOrder.SCATTER
        });

        CombinedData data = new CombinedData();

        newRefDateTime  = HealthDataSet.data.get(0).datumTijd; // first entry is new reference epoch

        data.setData(generateLineData(HealthDataSet.data, newRefDateTime));

        XAxis xAxis = chart.getXAxis();

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new LineChartXAxisValueFormatter(newRefDateTime));

        chart.getDescription().setEnabled(false);
        chart.setData(data);
        chart.setNoDataText(""); // verwijder "no chart data available" boodschap
        chart.invalidate();
    }

    private LineData generateLineData(ArrayList<HealthDataSetEntry> db, LocalDateTime startDate) {
        LineData d = new LineData();

        ArrayList<Entry> entriesBovendruk = new ArrayList<>();
        ArrayList<Entry> entriesOnderdruk = new ArrayList<>();

        for (HealthDataSetEntry dbe : db) {
            long diffInMinutes;

            if (dbe.datumTijd.isAfter(startDate) || dbe.datumTijd.isEqual(startDate)) {
                diffInMinutes = DateTimeConvertor.dateTimeToNewRef(dbe.datumTijd, startDate);
                if (dbe.gemBovendruk != 0.0f) {
                    entriesBovendruk.add(new Entry((float) diffInMinutes, dbe.gemBovendruk));
                    entriesOnderdruk.add(new Entry((float) diffInMinutes, dbe.gemOnderdruk));
                }
            }
        }

        // bovendruk set
        LineDataSet set1 = new LineDataSet(entriesBovendruk, "Bovendruk");

        set1.setColor(Color.RED);
        set1.setLineWidth(1.5f);
        set1.setDrawCircleHole(false);
        set1.setCircleColor(Color.RED);
        set1.setCircleRadius(2.5f);
        set1.setFillColor(Color.RED);
        set1.setMode(LineDataSet.Mode.LINEAR);
        set1.setDrawValues(false);
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);

        // onderdruk set
        LineDataSet set2 = new LineDataSet(entriesOnderdruk, "Onderdruk");

        set2.setColor(Color.BLUE);
        set2.setLineWidth(1.5f);
        set2.setDrawCircleHole(false);
        set2.setCircleColor(Color.BLUE);
        set2.setCircleRadius(2.5f);
        set2.setFillColor(Color.BLUE);
        set2.setMode(LineDataSet.Mode.LINEAR);
        set2.setDrawValues(false);
        set2.setAxisDependency(YAxis.AxisDependency.LEFT);

        d.addDataSet(set1);
        d.addDataSet(set2);

        return d;
    }

    private ScatterData generateScatterData(ArrayList<HealthDataSetEntry> db, LocalDateTime startDate) {
        ScatterData d = new ScatterData();

        ArrayList<Entry> entries = new ArrayList<>();

        for (HealthDataSetEntry dbe : db) {
            long diffInMinutes;

            if (dbe.datumTijd.isAfter(startDate) || dbe.datumTijd.isEqual(startDate)) {
                diffInMinutes = DateTimeConvertor.dateTimeToNewRef(dbe.datumTijd, startDate);
                entries.add(new Entry((float)diffInMinutes, dbe.gemBovendruk));
            }
        }

        ScatterDataSet set = new ScatterDataSet(entries, "");

        set.setColor(Color.RED);
        set.setDrawValues(true);
        set.setValueTextSize(10f);
        set.setValueTextColor(Color.RED);

        set.setColor(Color.RED);
        set.setValueTextColor(Color.BLACK);
        set.setValueTextSize(18f);

        d.addDataSet(set);

        return d;
    }
}