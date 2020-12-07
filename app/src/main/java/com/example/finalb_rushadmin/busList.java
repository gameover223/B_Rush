package com.example.finalb_rushadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class busList extends AppCompatActivity {
    Dialog listDialog;
    Dialog micDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);
        listDialog = new Dialog(this);
        micDialog = new Dialog(this);
    }

    public void showBusList(View v){
        Button modalBack;
        Button modalBook;
        listDialog.setContentView(R.layout.activity_pop_up_list);
        listDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        listDialog.show();
        modalBack = (Button) listDialog.findViewById(R.id.modalBtnBack);
        modalBook = (Button) listDialog.findViewById(R.id.modalBtnBook);
        modalBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                listDialog.dismiss();
            }
        });
        modalBook.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openBusSeats();
            }
        });

    }

    public void showMicPop(View v){
        micDialog.setContentView(R.layout.popupmic);
        micDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        micDialog.show();
    }

    public void openBusSeats(){
        Intent intent = new Intent(this, BusSeats.class);
        startActivity(intent);
    }
}