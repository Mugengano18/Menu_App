package com.example.menu_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu_app.Activities.anotherActivity;
import com.example.menu_app.ItemClickListener;
import com.example.menu_app.R;
import com.example.menu_app.models.CustomFilter;
import com.example.menu_app.models.Model;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<MyHolder> implements Filterable {

    public ArrayList<Model> models;
    Context context;
    ArrayList<Model>filterList;
    CustomFilter filter;

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


                String name=models.get(position).getName();
                String price=models.get(position).getPrice();
                BitmapDrawable bitmapDrawable=(BitmapDrawable)holder.image.getDrawable();
                Bitmap bitmap=bitmapDrawable.getBitmap();

                ByteArrayOutputStream stream= new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.JPEG,50,stream);

                byte[]bytes=stream.toByteArray();



                Intent intent=new Intent(context, anotherActivity.class);
                intent.putExtra("Menu",name);
                intent.putExtra("price",price);
                intent.putExtra("imagez",bytes);
                context.startActivity(intent);

            }
        });

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
