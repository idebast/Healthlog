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
import com.idebast.healthlog.R;
import com.idebast.healthlog.fragments.util.DateTimeConvertor;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PolsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PolsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    LocalDateTime newRefDateTime;

    public PolsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PolsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PolsFragment newInstance(String param1, String param2) {
        PolsFragment fragment = new PolsFragment();
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
        return inflater.inflate(R.layout.fragment_pols, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CombinedChart chart;

        chart = view.findViewById(R.id.polsChart);

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

        ArrayList<Entry> entriesGemPols = new ArrayList<>();

        for (HealthDataSetEntry dbe : db) {
            long diffInMinutes;

            if (dbe.datumTijd.isAfter(startDate) || dbe.datumTijd.isEqual(startDate)) {
                diffInMinutes = DateTimeConvertor.dateTimeToNewRef(dbe.datumTijd, startDate);
                if (dbe.gemPols != 0.) {
                    entriesGemPols.add(new Entry((float) diffInMinutes, dbe.gemPols));
                }
            }
        }

        // pols set
        LineDataSet set = new LineDataSet(entriesGemPols, "Pols");

        set.setColor(Color.GREEN);
        set.setLineWidth(1.5f);
        set.setDrawCircleHole(false);
        set.setCircleColor(Color.GREEN);
        set.setCircleRadius(2.5f);
        set.setFillColor(Color.GREEN);
        set.setMode(LineDataSet.Mode.LINEAR);
        set.setDrawValues(false);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);

        d.addDataSet(set);

        return d;
    }

}