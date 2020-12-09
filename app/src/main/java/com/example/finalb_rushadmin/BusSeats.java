package com.example.finalb_rushadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class BusSeats extends AppCompatActivity {
    Dialog selectSeatPop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_seats);

        selectSeatPop = new Dialog(this);
    }


    public void selectSeatPop(View v){
        selectSeatPop.setContentView(R.layout.activity_seat_selection);
        selectSeatPop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        selectSeatPop.show();
    }
}