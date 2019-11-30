package com.example.menu_app.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menu_app.R;

public class QuantityActivity extends AppCompatActivity {

    int quantity = 0;
    int price = 0;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantity);

        add = (Button) findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuantityActivity.this, "Item added!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(QuantityActivity.this, SignupActivity.class));
                finish();
            }
        });

    }

    private void display(int number) {
        TextView quantityText = (TextView) findViewById(R.id.quantity);
        quantityText.setText("" + number);
    }

    private void displayPrice(int price) {
        TextView priceText = (TextView) findViewById(R.id.price);
        priceText.setText("Frw " + price);
    }

    public void decrement(View view) {
        if (quantity>0) {
            quantity = quantity - 1;
            display(quantity);
        }
        price = calculatePrice();
        displayPrice(price);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
        price = calculatePrice();
        displayPrice(price);
    }

    private int calculatePrice() {
        price = quantity * 3000;
        return price;
    }
}
