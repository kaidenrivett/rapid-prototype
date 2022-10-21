package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Button watchdog,monitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        watchdog=findViewById(R.id.button);
        monitor=findViewById(R.id.button2);
        watchdog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //watchdogactivity
                Intent i = new Intent(MainActivity.this,watchdogTimerActivity.class);
                startActivity(i);
                finish();
            }
        });
        monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,monitorVitals.class);
                startActivity(i);
                finish();
            }
        });


    }

}