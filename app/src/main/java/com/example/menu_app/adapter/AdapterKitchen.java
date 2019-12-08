package com.example.menu_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu_app.Activities.Waiter;
import com.example.menu_app.R;
import com.example.menu_app.models.KitchenR;
import com.example.menu_app.models.Order;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdapterKitchen extends RecyclerView.Adapter<AdapterKitchen.MyViewHolder> {

    ArrayList<KitchenR> list;
    ArrayList<Order> list2;
    Context mContext;

DatabaseReference ref;



    public AdapterKitchen(Context context, ArrayList<KitchenR> list) {
        this.list = list;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eachkitchen, parent, false);
        ref = FirebaseDatabase.getInstance().getReference().child("order").child("LvWYnzdAoaAP9efv658");
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        System.out.println(list.get(position).getName());

        if(ref==null) {
            System.out.print("blooo");
        }
        if (ref != null) {
            System.out.print("bloooaaaaaaaaaaaaaaa");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.exists()) {
                        list2 = new ArrayList<>();
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            list2.add(ds.getValue(Order.class));
                        }
                        System.out.println(list2);
                        Adapter adapter = new Adapter(mContext, list2);
                        holder.rv.setAdapter(adapter);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(mContext, databaseError.getMessage(), Toast.LENGTH_LONG).show();
                }
            });


//        Glide.with(mContext)
//                .asBitmap()
//                .load(list.get(position).getDealImage())
//                .into(holder.imageView);

        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, desc;
        TextView imageView;
        Button delete;
RecyclerView rv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rv=itemView.findViewById(R.id.recycler);


        }


    }
}
