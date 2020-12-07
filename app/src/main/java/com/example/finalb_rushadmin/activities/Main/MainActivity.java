package com.team_brush.b_rush.activities.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.team_brush.b_rush.R;
import com.team_brush.b_rush.activities.Home.HomeActivity;

public class MainActivity extends AppCompatActivity {

    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.btn_login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboardActivity();
            }
        });
    }

    private void openDashboardActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}