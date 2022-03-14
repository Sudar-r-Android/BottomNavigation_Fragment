package com.example.bottomnavigationfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomnavgation);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomnavigationMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new DashboardFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomnavigationMethod = new
            BottomNavigationView.OnNavigationItemSelectedListener()
            {

                Fragment fragment=null;
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId())
                    {
                        case R.id.home:
                            fragment=new HomeFragment();
                            break;

                        case R.id.dashboard:
                            fragment=new DashboardFragment();
                            break;

                        case R.id.info:
                            fragment=new InfoFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
                    return true;
                }
            };
}