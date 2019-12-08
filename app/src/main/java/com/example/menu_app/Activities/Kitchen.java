package com.example.menu_app.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.menu_app.R;
import com.example.menu_app.adapter.Adapter;
import com.example.menu_app.adapter.AdapterKitchen;
import com.example.menu_app.models.KitchenR;
import com.example.menu_app.models.Order;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Kitchen extends AppCompatActivity {
RecyclerView recycler;

    DatabaseReference ref;
    ArrayList<KitchenR> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);

        recycler=findViewById(R.id.recycler);
        ref= FirebaseDatabase.getInstance().getReference().child("order");
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
                            list.add(ds.getValue(KitchenR.class));
                        }

                        AdapterKitchen adapter = new AdapterKitchen(Kitchen.this, list);
                        recycler.setAdapter(adapter);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(Kitchen.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }}


