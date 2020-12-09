package com.example.finalb_rushadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUser2 extends AppCompatActivity {
    private Button btnAddUser;
    private EditText add, bday, num;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user2);
        //get values
        add = (EditText) findViewById(R.id.getUserAddress);
        bday = (EditText) findViewById(R.id.getUserBday);
        num = (EditText) findViewById(R.id.getUserNum);

        //button to insert data in table
        btnAddUser = (Button) findViewById(R.id.addUser);
        databaseHelper = new DatabaseHelper(this);
        InsertUser();
    }

    public void InsertUser()
    {
        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                String Fname = bundle.getString("First");
                String Mname = bundle.getString("Middle");
                String Lname = bundle.getString("Last");
                String Username = bundle.getString("User");
                String Pass = bundle.getString("Pass");

                boolean isInserted = databaseHelper.insertUser(Fname, Mname, Lname, add.getText().toString(), bday.getText().toString(),
                        num.getText().toString(), Username, Pass);
                if(isInserted) { String str = "Data has been added"; showMessage(str); }
                else { String str = "Failed to add data"; showMessage(str); }
            }
        });
    }

    private void showMessage(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(AddUser2.this);
        alert.setCancelable(true);
        alert.setTitle("Is Data Added?");
        alert.setMessage(message);
        alert.show();
    }
}