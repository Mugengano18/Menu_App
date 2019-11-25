package com.example.menu_app.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.menu_app.R;
import com.example.menu_app.adapter.menulistAdapter;

import java.util.ArrayList;

public class Menulist extends AppCompatActivity {
    private static final String TAG = "Menulist";

    private ArrayList<String> Names=new ArrayList<>();
    private ArrayList<String> Imageurls=new ArrayList<>();
    private ArrayList<String> Money=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menulist);
        Log.d(TAG, "onCreate: started");
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        menulistAdapter adapter=new menulistAdapter(this,Names,Imageurls,Money);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ImageBitmaps();

    }
    private void  ImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing images");

        Imageurls.add("https://images.unsplash.com/photo-1498837167922-ddd27525d352?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        Names.add("Chicken Masala");
        Money.add("2000");

        Imageurls.add("https://images.unsplash.com/photo-1482049016688-2d3e1b311543?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=653&q=80");
        Names.add("Rice");
        Money.add("3000");

        Imageurls.add("https://images.unsplash.com/photo-1504674900247-0877df9cc836?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80");
        Names.add("Chicken Masala");
        Money.add("9000");

        Imageurls.add("https://images.unsplash.com/photo-1484723091739-30a097e8f929?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        Names.add("Chicken Masala");
        Money.add("6000");

        Imageurls.add("https://images.unsplash.com/photo-1551024709-8f23befc6f87?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        Names.add("Chicken Masala");
        Money.add("4000");

        Imageurls.add("https://images.unsplash.com/photo-1547595628-c61a29f496f0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        Names.add("Chicken Masala");
        Money.add("7000");

        Imageurls.add("https://images.unsplash.com/photo-1513558161293-cdaf765ed2fd?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        Names.add("Water melon");
        Money.add("3000");

        Imageurls.add("https://images.unsplash.com/photo-1438557068880-c5f474830377?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        Names.add("snifter");
        Money.add("2000");

        Imageurls.add("https://images.unsplash.com/photo-1545438102-799c3991ffb2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        Names.add("cocktail");
        Money.add("1000");

        Imageurls.add("https://images.unsplash.com/photo-1470337458703-46ad1756a187?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        Names.add("Liquor");
        Money.add("9000");

        Imageurls.add("https://images.unsplash.com/photo-1532550907401-a500c9a57435?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        Names.add("Chicken");
        Money.add("1000");

        Imageurls.add("https://images.unsplash.com/photo-1516684669134-de6f7c473a2a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        Names.add("Fried Chicken");
        Money.add("7000");

        Imageurls.add("https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        Names.add("Pizza");
        Money.add("9000");

        Imageurls.add("https://images.unsplash.com/photo-1520201163981-8cc95007dd2a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        Names.add("Pizza cheese");
        Money.add("2000");

        Imageurls.add("https://images.unsplash.com/photo-1549611016-3a70d82b5040?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        Names.add("hamburger");
        Money.add("1500");

        Imageurls.add("https://images.unsplash.com/photo-1555939594-58d7cb561ad1?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60");
        Names.add("fried meat");
        Money.add("5000");

    }
}
