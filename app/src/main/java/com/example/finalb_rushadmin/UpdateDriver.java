package com.example.finalb_rushadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDriver extends AppCompatActivity {
    private Button cancel, update;
    private EditText fname, mname, lname, add, bday, contact;
    private DatabaseHelper databaseHelper;
    private String FirstName, MiddleName, LastName, Address, Bday, Contact;
    private long personID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_driver);
        databaseHelper = new DatabaseHelper(this);
        long driverID = getDriverID();
        displayData(driverID);

        fname = (EditText) findViewById(R.id.updatedDriverFName);
        mname = (EditText) findViewById(R.id.updatedDriverMName);
        lname = (EditText) findViewById(R.id.updatedDriverLName);
        add = (EditText) findViewById(R.id.updatedDriverAddress);
        bday = (EditText) findViewById(R.id.updatedDriverBday);
        contact = (EditText) findViewById(R.id.updatedDriverContactNum);

        fname.setText(FirstName);
        mname.setText(MiddleName);
        lname.setText(LastName);
        add.setText(Address);
        bday.setText(Bday);
        contact.setText(Contact);

        cancel = (Button) findViewById(R.id.cancelDriverUpdate);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DriverFragment driverFragment = new DriverFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.layout, driverFragment).addToBackStack(null).commit();
            }
        });

        update = (Button) findViewById(R.id.updateDriver);
        updateDriver();
    }

   private Long getDriverID(){
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("Name");
        String[] strSplit = name.split("-");
        long res = Long.parseLong(strSplit[0]);
        return res;
    }

    private void displayData(long driverID){
        Cursor cursor = databaseHelper.getDriver(driverID);
        if(cursor.getCount() == 0){ Toast.makeText(UpdateDriver.this, "Database is empty", Toast.LENGTH_SHORT).show(); }
        else{
            personID = cursor.getLong(cursor.getColumnIndex("PersonID"));
            Cursor driver = databaseHelper.getPerson(personID);
            FirstName = driver.getString(driver.getColumnIndex("FirstName"));
            MiddleName = driver.getString(driver.getColumnIndex("MiddleName"));
            LastName = driver.getString(driver.getColumnIndex("LastName"));
            Address = driver.getString(driver.getColumnIndex("Address"));
            Bday = driver.getString(driver.getColumnIndex("Birthday"));
            Contact = driver.getString(driver.getColumnIndex("Contact_Number"));
        }
    }

    private void updateDriver(){
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = String.valueOf(personID);
                boolean isUpdated = databaseHelper.updateDriver(id, fname.getText().toString(), mname.getText().toString(), lname.getText().toString(),
                        add.getText().toString(), bday.getText().toString(), contact.getText().toString());
                if(isUpdated){ String str = "Data is updated"; showMessage(str);}
                else{ String str = "Failed to update data"; showMessage(str); }
            }
        });
    }
    private void showMessage(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(UpdateDriver.this);
        alert.setCancelable(true);
        alert.setTitle("Is Data Updated?");
        alert.setMessage(message);
        alert.show();
    }
}