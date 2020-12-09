package com.example.finalb_rushadmin;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.telephony.SmsManager;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class Gcash1 extends AppCompatActivity {
    private Button Submit;
    private EditText MobileNo_Login1;
    private  DatabaseHelper myDbGcash;
    private String pin = "1234";
    private String Phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcash1);
        myDbGcash = new DatabaseHelper(this);
        Submit = findViewById(R.id.Submit);
        MobileNo_Login1 = (EditText) findViewById(R.id.MobileNo_Login1);

        myDbGcash.deleteTestData();
        myDbGcash.insertTestData();
        openAct2();

    }

    private void openAct2(){
        Intent intent = new Intent(this, Gcash2.class);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = login_validation(MobileNo_Login1.getText().toString());
                if(flag == true){
                    showMessage("Success", "Account found please wait for the text message \n");
                    sendText();
                    startActivity(intent);
                }
                else {
                    showMessage("ERROR", "No Account found with that mobile number \n");
                }

            }
        });
    }
    private boolean login_validation(String mobileNo){
        Boolean flag = false;
        String Data ="";
        String Mob = mobileNo;
        Cursor login= myDbGcash.LoginGcash();

        if(login.moveToFirst()){
            do {
                Data = login.getString(1);
                if (Data.equals(Mob)) {
                    flag = true;
                    break;
                }else {
                    flag = false;
                }
            }  while (login.moveToNext());
        }
        return flag;
    }

    private void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    private void sendText(){
        String From="1231231";
        String msg="This is a sample code, its not yet randomized"+pin;
        Intent intent=new Intent(getApplicationContext(),Gcash2.class);
        PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
        SmsManager sms=SmsManager.getDefault();
        sms.sendTextMessage(From, null, msg, pi,null);

    }
    public String getPin(){
        return pin;
    }
    public String getPhone(){
        Phone=MobileNo_Login1.getText().toString();
        return Phone;
    }
}