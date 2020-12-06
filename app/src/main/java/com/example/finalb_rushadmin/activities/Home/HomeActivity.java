package com.team_brush.b_rush.activities.Home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.team_brush.b_rush.R;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ConstraintLayout constraintLayout = findViewById(R.id.content_constraint_layout);


        MaterialToolbar materialToolbar = findViewById(R.id.material_toolbar);
        setSupportActionBar(materialToolbar);

        drawerLayout = findViewById(R.id.base_drawer);
        navigationView = findViewById(R.id.nav_drawer);
        appBarLayout = findViewById(R.id.base_appbar);
        collapsingToolbarLayout = findViewById(R.id.toolbar_layout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                materialToolbar,
                R.string.openNavDrawer,
                R.string.closeNavDrawer
        );

//        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavController navController = Navigation.findNavController(this, R.id.base_fragment);
        NavigationUI.setupWithNavController(navigationView, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                System.out.println(destination.getLabel());
                collapsingToolbarLayout.setTitle(destination.getLabel());
                getSupportActionBar().setTitle(destination.getLabel());
            }
        });

    }
}