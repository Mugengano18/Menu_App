package com.example.menu_app.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.menu_app.R;
import com.example.menu_app.adapter.Adapter;
import com.example.menu_app.models.Order;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class Waiter extends AppCompatActivity {

    private TextView goBack;
    RecyclerView recyclerView;
    DatabaseReference ref;
    ArrayList<Order> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiter_view);
        recyclerView=findViewById(R.id.rv);
        goBack = (TextView) findViewById(R.id.goBack);
        SharedPreferences mySharedPreferences = getSharedPreferences("com.example.menu_app", Context.MODE_PRIVATE);
        String key = mySharedPreferences.getString("id", "");
        System.out.println(key);
        ref= FirebaseDatabase.getInstance().getReference().child("order").child(key);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Waiter.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("nooo");
        if (ref != null) {
            System.out.print("yessssss");

            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.exists()) {
                        list = new ArrayList<>();
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            list.add(ds.getValue(Order.class));
                        }
                        System.out.println(list);
                        Adapter adapter = new Adapter(Waiter.this, list);
                        recyclerView.setAdapter(adapter);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(Waiter.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }}
