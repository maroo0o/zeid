package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Set up the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find TextViews by ID
        TextView productNameTextView = findViewById(R.id.productNameTextViewCart);
        TextView productDescriptionTextView = findViewById(R.id.productDescriptionTextViewCart);
        TextView productPriceTextView = findViewById(R.id.productPriceTextViewCart);
        TextView productSizeTextView = findViewById(R.id.productSizeTextViewCart);

        // Get data from Intent extras
        String productName = getIntent().getStringExtra("productName");
        String productDescription = getIntent().getStringExtra("productDescription");
        String productPrice = getIntent().getStringExtra("productPrice");
        String productSize = getIntent().getStringExtra("productSize");

        // Set data to TextViews
        productNameTextView.setText(productName);
        productDescriptionTextView.setText(productDescription);
        productPriceTextView.setText(productPrice);
        productSizeTextView.setText(productSize);

        // Find buttons by ID
        Button checkoutButton = findViewById(R.id.checkoutButton);
        Button backButton = findViewById(R.id.backButton);

        // Set click listeners for the buttons
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Checkout button click
                startActivity(new Intent(CartActivity.this, Checkout2Activity.class));
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Back button click
                startActivity(new Intent(CartActivity.this, MainActivityHome.class));
                finish(); // Close the current activity
            }
        });
    }
}
