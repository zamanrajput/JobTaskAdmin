package com.rajpoot.jobtaskadmin;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeScreen extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        bottomNavigationView = findViewById(R.id.homeBottomNav);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer,
                new HomeScreenFragment()).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selected = null;
                switch (item.getItemId()) {
                    case R.id.homeNav:
                        selected = new HomeScreenFragment();
                        break;
                    case R.id.messagesNav:
                        selected = new MessagesHome();
                        break;
                    case R.id.browseJob:
                        selected = new BrowseJobFragment();
                        break;
                    case R.id.completedJobNav:
                        selected = new CompletedJobsFragment();
                        break;
                    case R.id.profileNav:
                        selected = new Profile();
                        break;
                    default:
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer,
                        selected).commit();


                return true;
            }
        });
    }





    public void OpenCompletedWork(View view) {
        Toast.makeText(getApplicationContext(), "Redirecting for Testing", Toast.LENGTH_LONG).show();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new CompletedJobsFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.completedJobNav);

    }

    public void OpenUserProfile(View view) {
        Toast.makeText(getApplicationContext(), "Redirecting for Testing", Toast.LENGTH_LONG).show();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new Profile()).commit();
        bottomNavigationView.setSelectedItemId(R.id.profileNav);

    }


}