package com.example.menu_app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu_app.R;
import com.example.menu_app.models.Order;

import java.util.List;

public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.ViewHolder>{
private List<Order> listData;

public DisplayAdapter(List<Order> listData) {
        this.listData = listData;
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data,parent,false);
        return new ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order ld=listData.get(position);
        System.out.println(ld.getName()+"hhh");

        holder.txtname.setText(ld.getName());
        holder.txtmovie.setText(ld.getTotalPrice());
        }

@Override
public int getItemCount() {
        return listData.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder{
    private TextView txtname,txtmovie;
    public ViewHolder(View itemView) {
        super(itemView);

        txtname=(TextView)itemView.findViewById(R.id.nametxt);
        txtmovie=(TextView)itemView.findViewById(R.id.movietxt);
    }
}
}
