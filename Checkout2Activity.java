package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import android.widget.EditText;

public class Checkout2Activity extends AppCompatActivity {
    private EditText cardNumberEditText;
    private EditText addressEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout2);
        cardNumberEditText = findViewById(R.id.editTextCardNumber);
        addressEditText = findViewById(R.id.editTextAddress);
        Button proceedButton = findViewById(R.id.buttonPlaceOrder);

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get values from EditText
                String cardNumber = cardNumberEditText.getText().toString();
                String address = addressEditText.getText().toString();

                // Save data to SharedPreferences
                saveDataToSharedPreferences(cardNumber, address);

                // Start ReceiptActivity
                startActivity(new Intent(Checkout2Activity.this, ReceiptActivity.class));
            }
        });
    }

    private void saveDataToSharedPreferences(String cardNumber, String address) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("CARD_NUMBER", cardNumber);
        editor.putString("ADDRESS", address);

        editor.apply();
    }
}
