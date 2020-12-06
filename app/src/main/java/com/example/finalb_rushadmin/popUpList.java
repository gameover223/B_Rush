package com.example.finalb_rushadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class popUpList extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_list);
        button = (Button) findViewById(R.id.modalBtnBook);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openBusSeats();
            }
        });
    }

    public void openBusSeats(){
        Intent intent = new Intent(this, BusSeats.class);
        startActivity(intent);
    }
}