package com.example.menu_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuantityActivity extends AppCompatActivity {

    int quantity = 0;
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
            }
        });

    }

    private void display(int number) {
        TextView quantityText = (TextView) findViewById(R.id.quantity);
        quantityText.setText("" + number);
    }

    public void decrement(View view) {
        if (quantity>0) {
            quantity = quantity - 1;
            display(quantity);
        }
    }

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }
}
