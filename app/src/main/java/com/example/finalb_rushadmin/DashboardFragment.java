package com.example.finalb_rushadmin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {

    BarChart mpBarChart;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        super.onCreate(savedInstanceState);
        mpBarChart = v.findViewById(R.id.mp_groupBarChart);
        BarDataSet barDataSet1 = new BarDataSet(barEntries1(), "Morning Trip");
        barDataSet1.setColor(Color.rgb(184,75,17));
        BarDataSet barDataSet2 = new BarDataSet(barEntries2(), "Noon Trip");
        barDataSet2.setColor(Color.rgb(76,175,80));
        BarDataSet barDataSet3 = new BarDataSet(barEntries3(), "Evening Trip");
        barDataSet3.setColor(Color.rgb(0,150,136));


        BarData data = new BarData(barDataSet1, barDataSet2, barDataSet3);
        mpBarChart.setData(data);

        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        XAxis xAxis = mpBarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);

        mpBarChart.setDragEnabled(true);
        mpBarChart.setVisibleXRangeMaximum(3);

        float barSpace = 0.08f;
        float groupSpace = 0.16f;
        data.setBarWidth(0.20f);

        mpBarChart.getXAxis().setAxisMinimum(0);
        mpBarChart.getXAxis().setAxisMaximum(0+mpBarChart.getData().getGroupWidth(groupSpace, barSpace)*7);
        mpBarChart.getAxisLeft().setAxisMinimum(0);

        mpBarChart.groupBars( 0, groupSpace, barSpace);

        mpBarChart.invalidate();



        return v;
    }
    private ArrayList<BarEntry> barEntries1(){
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 238));
        barEntries.add(new BarEntry(2, 519));
        barEntries.add(new BarEntry(3, 461));
        barEntries.add(new BarEntry(4, 485));
        barEntries.add(new BarEntry(5, 349));
        barEntries.add(new BarEntry(6, 754));
        barEntries.add(new BarEntry(7, 578));
        return barEntries;
    }
    private ArrayList<BarEntry> barEntries2(){
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 238));
        barEntries.add(new BarEntry(2, 519));
        barEntries.add(new BarEntry(3, 461));
        barEntries.add(new BarEntry(4, 485));
        barEntries.add(new BarEntry(5, 349));
        barEntries.add(new BarEntry(6, 754));
        barEntries.add(new BarEntry(7, 578));
        return barEntries;
    }
    private ArrayList<BarEntry> barEntries3(){
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 238));
        barEntries.add(new BarEntry(2, 519));
        barEntries.add(new BarEntry(3, 461));
        barEntries.add(new BarEntry(4, 485));
        barEntries.add(new BarEntry(5, 349));
        barEntries.add(new BarEntry(6, 754));
        barEntries.add(new BarEntry(7, 578));
        return barEntries;
    }
}