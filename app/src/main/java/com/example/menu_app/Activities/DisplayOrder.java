package com.example.menu_app.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu_app.R;
import com.example.menu_app.adapter.DisplayAdapter;
import com.example.menu_app.models.Order;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayOrder extends AppCompatActivity {
    private List<Order> listData;
    private RecyclerView rv;
    private DisplayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_order);
        rv=(RecyclerView)findViewById(R.id.recyclerViewOrder);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        listData=new ArrayList<>();
        SharedPreferences mySharedPreferences = getSharedPreferences("com.example.menu_app", Context.MODE_PRIVATE);
        String id = mySharedPreferences.getString("id", "");

        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference(id);
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                        Order l=npsnapshot.getValue(Order.class);
                        listData.add(l);
                    }
                    adapter=new DisplayAdapter(listData);
                    rv.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}

