package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityMen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men3);

        // Reference UI elements
        ImageView iconHome = findViewById(R.id.iconHome);
        ImageView productImage1 = findViewById(R.id.productImage1);
        TextView productName1 = findViewById(R.id.productName1);
        TextView productDescription1 = findViewById(R.id.productDescription1);
        TextView productPrice1 = findViewById(R.id.productPrice1);
        RadioGroup radioGroupSizes1 = findViewById(R.id.radioGroupSizes1);
        RadioButton radioButtonSizeS1 = findViewById(R.id.radioButtonSizeS1);
        RadioButton radioButtonSizeM1 = findViewById(R.id.radioButtonSizeM1);
        RadioButton radioButtonSizeL1 = findViewById(R.id.radioButtonSizeL1);
        Button buyNowButton1 = findViewById(R.id.buyNowButton1);

        ImageView productImage2 = findViewById(R.id.productImage2);
        TextView productName2 = findViewById(R.id.productName2);
        TextView productDescription2 = findViewById(R.id.productDescription2);
        TextView productPrice2 = findViewById(R.id.productPrice2);
        RadioGroup radioGroupSizes2 = findViewById(R.id.radioGroupSizes2);
        RadioButton radioButtonSizeS2 = findViewById(R.id.radioButtonSizeS2);
        RadioButton radioButtonSizeM2 = findViewById(R.id.radioButtonSizeM2);
        RadioButton radioButtonSizeL2 = findViewById(R.id.radioButtonSizeL2);
        Button buyNowButton2 = findViewById(R.id.buyNowButton2);

        ImageView productImage3 = findViewById(R.id.productImage3);
        TextView productName3 = findViewById(R.id.productName3);
        TextView productDescription3 = findViewById(R.id.productDescription3);
        TextView productPrice3 = findViewById(R.id.productPrice3);
        RadioGroup radioGroupSizes3 = findViewById(R.id.radioGroupSizes3);
        RadioButton radioButtonSizeS3 = findViewById(R.id.radioButtonSizeS3);
        RadioButton radioButtonSizeM3 = findViewById(R.id.radioButtonSizeM3);
        RadioButton radioButtonSizeL3 = findViewById(R.id.radioButtonSizeL3);
        Button buyNowButton3 = findViewById(R.id.buyNowButton3);

        buyNowButton1 = findViewById(R.id.buyNowButton1);
        buyNowButton1.setOnClickListener(v -> {
            // Handle Buy Now button click for product 1

            // Get data for the selected product
            String productName = productName1.getText().toString();
            String productDescription = productDescription1.getText().toString();
            String productPrice = productPrice1.getText().toString();

            // You can get the selected size from the RadioGroup if needed
            int selectedRadioButtonId = radioGroupSizes1.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedSize = selectedRadioButton.getText().toString();

            // Create an Intent to start the CartActivity
            Intent intent = new Intent(MainActivityMen.this, CartActivity.class);

            // Pass data to the CartActivity using Intent extras
            intent.putExtra("productName", productName);
            intent.putExtra("productDescription", productDescription);
            intent.putExtra("productPrice", productPrice);
            intent.putExtra("selectedSize", selectedSize);

            // Start the CartActivity
            startActivity(intent);
        });
        buyNowButton2 = findViewById(R.id.buyNowButton2);
        buyNowButton2.setOnClickListener(v -> {
            // Handle Buy Now button click for product 1

            // Get data for the selected product
            String productName = productName2.getText().toString();
            String productDescription = productDescription2.getText().toString();
            String productPrice = productPrice2.getText().toString();

            // You can get the selected size from the RadioGroup if needed
            int selectedRadioButtonId = radioGroupSizes2.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedSize = selectedRadioButton.getText().toString();

            // Create an Intent to start the CartActivity
            Intent intent = new Intent(MainActivityMen.this, CartActivity.class);

            // Pass data to the CartActivity using Intent extras
            intent.putExtra("productName", productName);
            intent.putExtra("productDescription", productDescription);
            intent.putExtra("productPrice", productPrice);
            intent.putExtra("selectedSize", selectedSize);

            // Start the CartActivity
            startActivity(intent);
        });
        buyNowButton3 = findViewById(R.id.buyNowButton3);
        buyNowButton3.setOnClickListener(v -> {
            // Handle Buy Now button click for product 1

            // Get data for the selected product
            String productName = productName3.getText().toString();
            String productDescription = productDescription3.getText().toString();
            String productPrice = productPrice3.getText().toString();

            // You can get the selected size from the RadioGroup if needed
            int selectedRadioButtonId = radioGroupSizes3.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedSize = selectedRadioButton.getText().toString();

            // Create an Intent to start the CartActivity
            Intent intent = new Intent(MainActivityMen.this, CartActivity.class);

            // Pass data to the CartActivity using Intent extras
            intent.putExtra("productName", productName);
            intent.putExtra("productDescription", productDescription);
            intent.putExtra("productPrice", productPrice);
            intent.putExtra("selectedSize", selectedSize);

            // Start the CartActivity
            startActivity(intent);
        });

    }
}