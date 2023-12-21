package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import android.content.SharedPreferences;
import android.content.Context;
import android.os.Build;
import android.Manifest;
import android.content.pm.PackageManager;

public class ReceiptActivity extends AppCompatActivity {
    private TextView cardNumberTextView;
    private TextView addressTextView;
    private static final int REQUEST_CODE = 123; // You can use any integer value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        // Initialize TextViews
        cardNumberTextView = findViewById(R.id.carddetails); // Use the correct ID
        addressTextView = findViewById(R.id.addressdetails); // Use the correct ID

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
        }

        // Get references to UI elements
        final TextView textViewDetails = findViewById(R.id.textViewDetails);
        Button btnDownload = findViewById(R.id.btnDownload);

        // Set receipt details
        String receiptDetails = "Product: Item 1\nPrice: $10.00\nQuantity: 2\nTotal: $20.00";
        textViewDetails.setText(receiptDetails);

        // Set click listener for download button
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check external storage state
                String state = Environment.getExternalStorageState();
                Intent downloadIntent = new Intent(ReceiptActivity.this, DownloadService.class);
                downloadIntent.putExtra("receiptDetails", receiptDetails);
                startService(downloadIntent);


                if (Environment.MEDIA_MOUNTED.equals(state)) {
                    // External storage is available, proceed with file creation and writing

                    // Create a file to save the receipt
                    File receiptFile = new File(getExternalFilesDir(null), "Receipt.txt");
                    Log.d("File Path", receiptFile.getAbsolutePath());


                    try {
                        // Write receipt details to the file
                        FileWriter writer = new FileWriter(receiptFile);
                        writer.append(receiptDetails);
                        writer.flush();
                        writer.close();

                        // Display a message indicating successful download
                        Toast.makeText(ReceiptActivity.this, "Receipt downloaded successfully", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                        // Display an error message if the download fails
                        Toast.makeText(ReceiptActivity.this, "Error downloading receipt: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // External storage is not available or in a state where writing is not allowed
                    Toast.makeText(ReceiptActivity.this, "External storage not available for writing", Toast.LENGTH_SHORT).show();
                }

            }
        });

        retrieveDataFromSharedPreferences();
    }

    private void retrieveDataFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        // Retrieve data using keys
        String cardNumber = sharedPreferences.getString("CARD_NUMBER", "");
        String address = sharedPreferences.getString("ADDRESS", "");

        // Display data in TextViews
        cardNumberTextView.setText("Card Number: " + cardNumber); // Update the display format as needed
        addressTextView.setText("Address: " + address); // Update the display format as needed
    }
}
