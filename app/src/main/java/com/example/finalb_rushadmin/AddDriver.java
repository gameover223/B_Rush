package com.example.finalb_rushadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDriver extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private Button btnAddDriver;
    private EditText fname, mname, lname, add, bday, num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_driver);
        databaseHelper = new DatabaseHelper(this);
        //get the values
        fname = (EditText) findViewById(R.id.driverFName);
        mname = (EditText) findViewById(R.id.driverMName);
        lname = (EditText) findViewById(R.id.driverLName);
        add = (EditText) findViewById(R.id.driverAddress);
        bday = (EditText) findViewById(R.id.driverBday);
        num = (EditText) findViewById(R.id.driverContactNum);

        //button to insert a new driver
        btnAddDriver = (Button) findViewById(R.id.addDriver);
        InsertDriverData();
    }

    public void InsertDriverData()
    {
        btnAddDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = databaseHelper.insertBusDriver(fname.getText().toString(), mname.getText().toString(), lname.getText().toString(),
                        add.getText().toString(), bday.getText().toString(), num.getText().toString());
                if(isInserted){
                    DriverFragment fragment = new DriverFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.layout, fragment).addToBackStack(null).commit();
                }
                else { Toast.makeText(AddDriver.this, "Failed to insert data", Toast.LENGTH_SHORT).show();}
            }
        });
    }
}