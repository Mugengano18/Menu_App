package com.example.menu_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu_app.R;
import com.example.menu_app.models.Order;

import java.util.ArrayList;


    public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

        ArrayList<Order> list;
        Context mContext;

        public Adapter(Context context, ArrayList<Order> list) {
            this.list = list;
            this.mContext = context;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_item, parent, false);

            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            System.out.println(list.get(position).getName()+"yo");
            System.out.println(list.get(position));

            holder.id.setText(list.get(position).getName());
            holder.desc.setText(Integer.toString(list.get(position).getQuantity()));
            holder.imageView.setText(Integer.toString(list.get(position).getTotalPrice()));



//        Glide.with(mContext)
//                .asBitmap()
//                .load(list.get(position).getDealImage())
//                .into(holder.imageView);

        }


        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView id, desc;
            TextView imageView;


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                id = itemView.findViewById(R.id.name1);
                desc = itemView.findViewById(R.id.quantity1);
                imageView = itemView.findViewById(R.id.price1);

            }


        }
    }