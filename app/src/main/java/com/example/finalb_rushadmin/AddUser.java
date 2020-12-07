package com.example.finalb_rushadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddUser extends AppCompatActivity {
    private Button b1;
    private EditText fname, mname, lname, user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        //get the values to be passed
        fname = (EditText) findViewById(R.id.getUserFName);
        mname = (EditText) findViewById(R.id.getUserMName);
        lname = (EditText) findViewById(R.id.getUserLName);
        user = (EditText) findViewById(R.id.getUsername);
        pass = (EditText) findViewById(R.id.getUserPass);

        //pass the values
        b1 = (Button) findViewById(R.id.btnNext);
        ToAddUser2();
    }

    public void ToAddUser2()
    {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddUser.this, AddUser2.class);
                String first = fname.getText().toString();
                String middle = mname.getText().toString();
                String last = lname.getText().toString();
                String users = user.getText().toString();
                String passes = pass.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("First", first);
                bundle.putString("Middle", middle);
                bundle.putString("Last", last);
                bundle.putString("User", users);
                bundle.putString("Pass", passes);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}