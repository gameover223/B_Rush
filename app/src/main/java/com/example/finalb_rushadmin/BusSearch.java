package com.example.finalb_rushadmin;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class BusSearch extends AppCompatActivity {
    private Button button;
    Dialog micDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        
        button = (Button) findViewById(R.id.searchBtn);
        micDialog = new Dialog(this);
       button.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               openBusList();
           }
       });
    }

    public void openBusList(){
        Intent intent = new Intent(this, busList.class);
        startActivity(intent);
    }


    public void showMicPop(View v){
        micDialog.setContentView(R.layout.popupmic);
        micDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        micDialog.show();
    }

}
