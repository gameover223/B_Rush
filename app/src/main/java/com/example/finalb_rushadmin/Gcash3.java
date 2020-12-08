package com.example.finalb_rushadmin;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Gcash3 extends AppCompatActivity {
    private Button SubmitMPIN;
    private ImageButton backButton;
    private  DatabaseHelper myDbGcash;
    private EditText MPIN;
    //    private MainActivity activity = new MainActivity();
//    private String phone;
    String test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcash3);
        myDbGcash = new DatabaseHelper(this);
        SubmitMPIN = (Button)findViewById(R.id.submitMPIN);
        MPIN = (EditText)findViewById(R.id.MPIN);
        backButton = findViewById(R.id.backButton3);
        // phone = activity.getPhone();
        openAct4();
        backToAct2();
    }

    private boolean MPIN_validation(String mobileNo){
        Boolean flag = false;
        String Data ="";
        String Mob = mobileNo;
        Cursor login= myDbGcash.LoginGcash();

        if(login.moveToFirst()){
            do {
                Data = login.getString(3);
                if (Data.equals(Mob)) {
                    flag = true;
                    test = login.getString(3);
                    break;
                }else {
                    flag = false;
                }
            }  while (login.moveToNext());
        }
        return flag;
    }
    private void openAct4(){
        Intent intent = new Intent(this, Gcash4.class);

        SubmitMPIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("ERROR", "INVALID MPIN"+test+"\n"+MPIN.getText().toString());
                boolean flag = MPIN_validation(MPIN.getText().toString());

                if(flag == true){
                    showMessage("Succ", "VALID MPIN");
                    startActivity(intent);
                }else{
                    showMessage("ERROR", "INVALID MPIN");
                }


            }
        });

    }

    private void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    private void backToAct2(){
        Intent intent = new Intent(this, Gcash2.class);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);

            }
        });

    }
}
