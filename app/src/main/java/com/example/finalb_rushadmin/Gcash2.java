package com.example.finalb_rushadmin;


import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ComponentActivity;

import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Gcash2 extends AppCompatActivity {
    private Button Submit;
    private ImageButton backButton2;
    private EditText Auth_Code;
    String pin;
    private Gcash1 activity = new Gcash1();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcash2);
        Submit = (Button)findViewById(R.id.Submit2);
        Auth_Code = (EditText)findViewById(R.id.Auth_Code);
        backButton2 = findViewById(R.id.backButton2);
        pin=activity.getPin();
        openAct3();
        backToAct1();



    }
    private void openAct3(){
        Intent intent = new Intent(this, Gcash3.class);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = Auth_Code.getText().toString();
                boolean flag = Authentication(code);
                if(flag == true) {
                    showMessage("Success", "code Entered \n");
                    startActivity(intent);
                }else {
                    showMessage("Error", "Wrong code Entered \n");
                }
            }
        });

    }
    private void backToAct1(){
        Intent intent = new Intent(this, Gcash1.class);
        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }

    public boolean Authentication(String code){
        boolean flag;
        if (code.equals(pin)){
            flag = true;
        }else{
            flag = false;
        }

        return flag;
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
