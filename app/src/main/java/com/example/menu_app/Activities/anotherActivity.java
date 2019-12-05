package com.example.menu_app.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menu_app.R;
import com.example.menu_app.models.Order;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class anotherActivity extends AppCompatActivity {
    TextView menuname;
    TextView price1;
    ImageView image3;
    int quantity = 1;
    int price = 0;
    private Button add;
    TextView price2;
    String prize;
    String Name;
    String id;
    DatabaseReference databaseReference1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        menuname = findViewById(R.id.Menuname1);
        price2=findViewById(R.id.price);
        price1 = findViewById(R.id.money2);
        Intent intent1=getIntent();
        id=intent1.getStringExtra("id");
//        System.out.println(id);
        image3 = findViewById(R.id.image2);
        ActionBar actionBar = getSupportActionBar();
        Intent intent = getIntent();
         Name = intent.getStringExtra("Menu");
        prize = intent.getStringExtra("price");
        price2.setText(prize);
        byte[] mbytes = getIntent().getByteArrayExtra("imagez");
        Bitmap bitmap = BitmapFactory.decodeByteArray(mbytes, 0, mbytes.length);
        actionBar.setTitle(Name);
        menuname.setText(Name);
        price1.setText(prize);
        image3.setImageBitmap(bitmap);
        add = (Button) findViewById(R.id.add);
//        databaseReference1= FirebaseDatabase.getInstance().getReference(id);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(anotherActivity.this, "Item added!", Toast.LENGTH_SHORT).show();
//                save();
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
        if (quantity>1) {
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
        price = quantity * Integer.parseInt(prize);

        return price;
    }



//
//    public void save(){
//    Order order=new Order(Name,quantity,price);
//    databaseReference1.child(id).setValue(order);
//
//
//}





}