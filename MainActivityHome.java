package com.example.myapplication;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BroadcastReceiver br = new MyReceiver();
        IntentFilter f1 = new IntentFilter(Intent.ACTION_BATTERY_LOW);
        IntentFilter f2 = new IntentFilter(Intent.ACTION_POWER_CONNECTED);

        registerReceiver(br,f1);
        registerReceiver(br,f2);


        // Reference UI elements
        ImageView iconSearch = findViewById(R.id.iconSearchHome);
        ImageView iconCart = findViewById(R.id.iconCartHome);
        Button shopMenButton = findViewById(R.id.buttonShopMenHome);
        Button shopWomenButton = findViewById(R.id.buttonShopWomenHome);
        ImageView searchView = findViewById(R.id.iconSearchHome);
        ImageView iconProfile = findViewById(R.id.iconSignInHome);

        // Set OnClickListener for the iconProfile
        iconProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click on the profile icon
                // Navigate to the AccountActivity
                Intent intent = new Intent(MainActivityHome.this, register.class);
                startActivity(intent);
            }
        });
        // Set OnClickListener for the iconSearch
        iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle visibility of the SearchView
                if (searchView.getVisibility() == View.VISIBLE) {
                    searchView.setVisibility(View.INVISIBLE);
                } else {
                    searchView.setVisibility(View.VISIBLE);
                }
            }
        });
        // Set click listeners for the buttons
        shopMenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Shop Men button click
                startActivity(new Intent(MainActivityHome.this, MainActivityMen.class));
            }
        });

        shopWomenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Shop Women button click
                startActivity(new Intent(MainActivityHome.this, MainActivityWomen.class));
            }
        });
        // Set OnClickListener for the iconSearch
        iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click on the search icon
                // Open the search bar or navigate to the search activity
                // Add your code here for search functionality
            }
        });

        // Set OnClickListener for the iconCart
        iconCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click on the cart icon
                // Navigate to the CartActivity
                Intent intent = new Intent(MainActivityHome.this, CartActivity.class);
                startActivity(intent);
            }
        });

        // Other initialization code as needed
    }
}
