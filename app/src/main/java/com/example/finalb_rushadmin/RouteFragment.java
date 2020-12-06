package com.example.finalb_rushadmin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RouteFragment extends Fragment{
    private Button b1;
    private ImageView imgUp, imgDel;
    private DatabaseHelper databaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bus_route, container, false);
        initializeDatabase();

        b1 = v.findViewById(R.id.btnAddRoute);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddRoute.class);
                startActivity(intent);
            }
        });

        return v;
    }

    public void initializeDatabase()
    {
        if(databaseHelper == null)
        {
            databaseHelper = new DatabaseHelper(getActivity());
        }
    }
}
