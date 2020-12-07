package com.example.finalb_rushadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class BusSeats extends AppCompatActivity {
    Dialog gCashDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_seats);
        gCashDialog = new Dialog(this);
    }

    public void showCashPop(View v){
        gCashDialog.setContentView(R.layout.activity_g_cash_pop);
        gCashDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        gCashDialog.show();
    }
}