package com.example.finalb_rushadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class UpdateRoute extends AppCompatActivity {
    private Spinner spinnerTime, spinnerDriver, spinnerBusNum, spinnerDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_route);

        spinnerTime = findViewById(R.id.updatedTime);
        String[] timeSched = getResources().getStringArray(R.array.time_schedule);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, timeSched);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTime.setAdapter(adapter);



        spinnerBusNum = findViewById(R.id.updatedBusNumber);
        String[] busNum = getResources().getStringArray(R.array.bus_number);
        ArrayAdapter adapterB = new ArrayAdapter(this, android.R.layout.simple_spinner_item, busNum);
        adapterB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBusNum.setAdapter(adapterB);

        spinnerDes = findViewById(R.id.updatedDestination);
        String[] desList = getResources().getStringArray(R.array.bus_destination);
        ArrayAdapter destination = new ArrayAdapter(this, android.R.layout.simple_spinner_item, desList);
        destination.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDes.setAdapter(destination);
    }
}