package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityWomen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women2);

        // Reference UI elements
        ImageView iconHome = findViewById(R.id.iconHome);

        // Product 1 elements
        TextView productName1 = findViewById(R.id.productNameWomen1);
        TextView productDescription1 = findViewById(R.id.productDescriptionWomen1);
        TextView productPrice1 = findViewById(R.id.productPriceWomen1);
        RadioGroup radioGroupSizes1 = findViewById(R.id.radioGroupSizeWomens1);
        Button buyNowButton1 = findViewById(R.id.buyNowButtonWomen1);

        // Product 2 elements
        TextView productName2 = findViewById(R.id.productNameWomen2);
        TextView productDescription2 = findViewById(R.id.productDescriptionWomen2);
        TextView productPrice2 = findViewById(R.id.productPriceWomen2);
        RadioGroup radioGroupSizes2 = findViewById(R.id.radioGroupSizes2);
        Button buyNowButton2 = findViewById(R.id.buyNowButtonWomen2);

        // Product 3 elements
        TextView productName3 = findViewById(R.id.productNameWomen3);
        TextView productDescription3 = findViewById(R.id.productDescriptionWomen3);
        TextView productPrice3 = findViewById(R.id.productPriceWomen3);
        RadioGroup radioGroupSizes3 = findViewById(R.id.radioGroupSizesWomen3);
        Button buyNowButton3 = findViewById(R.id.buyNowButtonWomen3);

        // Set OnClickListener for Buy Now buttons
        setBuyNowClickListener(buyNowButton1, productName1, productDescription1, productPrice1, radioGroupSizes1);
        setBuyNowClickListener(buyNowButton2, productName2, productDescription2, productPrice2, radioGroupSizes2);
        setBuyNowClickListener(buyNowButton3, productName3, productDescription3, productPrice3, radioGroupSizes3);

        // Add other logic as needed
    }

    private void setBuyNowClickListener(Button buyNowButton, TextView productName, TextView productDescription, TextView productPrice, RadioGroup radioGroupSizes) {
        buyNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get data for the selected product
                String name = productName.getText().toString();
                String description = productDescription.getText().toString();
                String price = productPrice.getText().toString();

                // You can get the selected size from the RadioGroup if needed
                int selectedRadioButtonId = radioGroupSizes.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                String size = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "";

                // Create an Intent to start the CartActivity
                Intent intent = new Intent(MainActivityWomen.this, CartActivity.class);

                // Pass data to the CartActivity using Intent extras
                intent.putExtra("productName", name);
                intent.putExtra("productDescription", description);
                intent.putExtra("productPrice", price);
                intent.putExtra("productSize", size);

                // Start the CartActivity
                startActivity(intent);
            }
        });
    }
}
