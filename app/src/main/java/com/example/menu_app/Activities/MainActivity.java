package com.example.menu_app.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.menu_app.R;
import com.example.menu_app.models.KitchenR;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btnWaiter)Button waiter;
    @BindView(R.id.btnKitchen)Button kitchen;
    @BindView(R.id.btnReceipts)Button receipts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        waiter.setOnClickListener(this);
        kitchen.setOnClickListener(this);
        receipts.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == waiter) {
            Intent waiter = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(waiter);
        }

        if(v == kitchen) {
            Intent kitchen = new Intent(MainActivity.this, Kitchen.class);
            startActivity(kitchen);
        }

        if(v == receipts) {
            Intent receipts = new Intent(MainActivity.this, Tablenbr.class);
            startActivity(receipts);
        }

    }
}
