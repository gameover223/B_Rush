package com.team_brush.b_rush.fragments.Dashboard;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.android.material.textfield.TextInputLayout;
import com.team_brush.b_rush.R;

import java.util.ArrayList;
import java.util.Calendar;

import static com.github.mikephil.charting.utils.ColorTemplate.COLORFUL_COLORS;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeekStatisticFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeekStatisticFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WeekStatisticFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeekStatisticFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WeekStatisticFragment newInstance(String param1, String param2) {
        WeekStatisticFragment fragment = new WeekStatisticFragment();
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

    // Dropdown Text
    private TextInputLayout textInputLayout;
    private AutoCompleteTextView autoCompleteTextView;

    // Pie Charts
    private PieChart pieTimeDay, pieTimeNight;
    private PieDataSet dataSetTimeDay, dataSetTimeNight;
    private PieData dataTimeDay, dataTimeNight;
    private Legend legendDay, legendNight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_week_statistic, container, false);

        setWeekDropdown(root);
        createPieChartTime(root);

        return root;
    }

    private void setWeekDropdown(View root) {
        Calendar cal = Calendar.getInstance();
        int week = cal.get(Calendar.WEEK_OF_MONTH) == 5 ? cal.get(Calendar.WEEK_OF_MONTH) - 2 : cal.get(Calendar.WEEK_OF_MONTH) - 1;

        textInputLayout = root.findViewById(R.id.dropdown_week);
        autoCompleteTextView = root.findViewById(R.id.dropdown_week_choices);

        final String[] items = new String[] {
                "Week 1",
                "Week 2",
                "Week 3",
                "Week 4",
        };

        final ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getContext(), R.layout.layout_dropdown_list, items);
        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView.setText(arrayAdapter.getItem(week).toString(), false);
    }

    public void createPieChartTime(View root) {

        // Pie Time (Day)
        pieTimeDay = root.findViewById(R.id.timeFreqDayWeek);
        // Sample Data
        ArrayList<PieEntry> timeFreqDay = new ArrayList<>();
        timeFreqDay.add(new PieEntry(10, "5:30 AM"));
        timeFreqDay.add(new PieEntry(3, "6:30 AM"));
        timeFreqDay.add(new PieEntry(1, "8:30 AM"));
        timeFreqDay.add(new PieEntry(1, "4:30 AM"));

        dataSetTimeDay = new PieDataSet(timeFreqDay, "");
        dataSetTimeDay.setColors(COLORFUL_COLORS);
        dataSetTimeDay.setValueTextColor(Color.WHITE);
        dataSetTimeDay.setValueTextSize(12f);

        dataTimeDay = new PieData(dataSetTimeDay);

        pieTimeDay.setData(dataTimeDay);
        pieTimeDay.setUsePercentValues(true);
        pieTimeDay.getDescription().setEnabled(false);
        pieTimeDay.setCenterText("Time Frequency (Day)");
        pieTimeDay.setHoleColor(Color.TRANSPARENT);
        pieTimeDay.setEntryLabelColor(Color.TRANSPARENT);
        pieTimeDay.animate();

        legendDay = pieTimeDay.getLegend();
        legendDay.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legendDay.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);

        // Pie Time (Night)
        pieTimeNight = root.findViewById(R.id.timeFreqNightWeek);
        // Sample Data
        ArrayList<PieEntry> timeFreqNight = new ArrayList<>();
        timeFreqNight.add(new PieEntry(14, "5:30 PM"));
        timeFreqNight.add(new PieEntry(10, "6:30 PM"));
        timeFreqNight.add(new PieEntry(4, "8:30 PM"));
        timeFreqNight.add(new PieEntry(1, "4:30 PM"));
        timeFreqNight.add(new PieEntry(1, "9:30 PM"));

        dataSetTimeNight = new PieDataSet(timeFreqNight, "");
        dataSetTimeNight.setColors(COLORFUL_COLORS);
        dataSetTimeNight.setValueTextColor(Color.WHITE);
        dataSetTimeNight.setValueTextSize(12f);

        dataTimeNight = new PieData(dataSetTimeNight);

        pieTimeNight.setData(dataTimeNight);
        pieTimeNight.setUsePercentValues(true);
        pieTimeNight.getDescription().setEnabled(false);
        pieTimeNight.setCenterText("Time Frequency (Night)");
        pieTimeNight.setHoleColor(Color.TRANSPARENT);
        pieTimeNight.setEntryLabelColor(Color.TRANSPARENT);
        pieTimeNight.animate();

        legendNight = pieTimeNight.getLegend();
        legendNight.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legendNight.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
    }

}