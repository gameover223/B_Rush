package com.team_brush.b_rush.fragments.Dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.team_brush.b_rush.R;
import com.team_brush.b_rush.fragments.Dashboard.adapters.StatisticViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatisticFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatisticFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StatisticFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StatisticFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StatisticFragment newInstance(String param1, String param2) {
        StatisticFragment fragment = new StatisticFragment();
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

    private ViewPager viewPager;
    private TabLayout tabLayout;

    // Fragment
    private MonthStatisticFragment monthStatisticFragment;
    private WeekStatisticFragment weekStatisticFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_statistic, container, false);

        viewPager = root.findViewById(R.id.view_pager_statistic);
        tabLayout = root.findViewById(R.id.tab_stat);

        tabLayout.setupWithViewPager(viewPager);

        monthStatisticFragment = new MonthStatisticFragment();
        weekStatisticFragment = new WeekStatisticFragment();

        StatisticViewPagerAdapter statisticViewPagerAdapter = new StatisticViewPagerAdapter(getChildFragmentManager(), 0);
        statisticViewPagerAdapter.addFragment(weekStatisticFragment, "Week");
        statisticViewPagerAdapter.addFragment(monthStatisticFragment, "Month");

        viewPager.setAdapter(statisticViewPagerAdapter);

        return root;
    }
}