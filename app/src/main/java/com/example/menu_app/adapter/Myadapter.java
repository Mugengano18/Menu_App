package com.example.menu_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu_app.Activities.anotherActivity;
import com.example.menu_app.ItemClickListener;
import com.example.menu_app.R;
import com.example.menu_app.models.CustomFilter;
import com.example.menu_app.models.Model;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<MyHolder> implements Filterable {

    public ArrayList<Model> models;
    Context context;
    ArrayList<Model>filterList;
    CustomFilter filter;
    DatabaseReference databaseReference;

    public Myadapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
        this.filterList=models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.name.setText(models.get(position).getName());
        holder.price.setText(models.get(position).getPrice());
        holder.image.setImageResource(models.get(position).getImage());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {

                Toast.makeText(context, models.get(position).getName(), Toast.LENGTH_SHORT).show();

            }
        });
        databaseReference= FirebaseDatabase.getInstance().getReference("Orders");
        holder.Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddToFirebase(position);
                Toast.makeText(context, "Order added", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void AddToFirebase(int position) {
        int id1=models.get(position).getId();
        String name=models.get(position).getName();
        String price=models.get(position).getPrice();
        int image=models.get(position).getImage();
        if (!TextUtils.isEmpty(name)){
            String id=databaseReference.push().getKey();
            Model savedItems=new Model(name,price,image,id1);
            databaseReference.child(id).setValue(savedItems);
        }else {
            Toast.makeText(context,"it failed",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    @Override
    public Filter getFilter() {

        if (filter==null){
            filter=new CustomFilter(filterList,this);
        }
        return filter;
    }
}
