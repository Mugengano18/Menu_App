package com.example.menu_app.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.menu_app.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class menulistAdapter extends RecyclerView.Adapter<menulistAdapter.ViewHolder>{
    private static final String TAG = "menulistAdapter";
    private ArrayList<String>Names=new ArrayList<>();
    private ArrayList<String>Images=new ArrayList<>();
    private ArrayList<String>Mone=new ArrayList<>();
    private Context context;


    public menulistAdapter(Context context,ArrayList<String> names, ArrayList<String> images, ArrayList<String> mone) {
        Names = names;
        Images = images;
        Mone = mone;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");

        Glide.with(context)
                .asBitmap()
                .load(Images.get(position))
                .into(holder.imageView);
        holder.menuname.setText(Names.get(position));
        holder.money.setText(Mone.get(position));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on:" + Images.get(position));
                Toast.makeText(context,Names.get(position),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return Images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imageView;
        TextView menuname;
        TextView money;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image1);
            menuname=itemView.findViewById(R.id.Menuname);
            money=itemView.findViewById(R.id.money);
            linearLayout=itemView.findViewById(R.id.parent_layout);
        }
    }
}
