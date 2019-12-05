package com.example.menu_app.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.menu_app.R;
import com.example.menu_app.adapter.Myadapter;
import com.example.menu_app.models.Model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menulist extends AppCompatActivity implements View.OnClickListener{
    RecyclerView recyclerView;
    Myadapter myadapter;
    SharedPreferences preferences;
    private FirebaseAuth Auth;
    String Number;
    private FirebaseAuth.AuthStateListener AuthListener;
    int quantity = 1;
    int price = 0;
    String prize;
    @BindView(R.id.View)
    Button viewOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menulist);
        ButterKnife.bind(this);
        recyclerView=findViewById(R.id.recyclerView);
        preferences=this.getSharedPreferences("Preference",MODE_PRIVATE);
        getMyList();
        viewOrder.setOnClickListener(this);

        Auth=FirebaseAuth.getInstance();
        AuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser client=firebaseAuth.getCurrentUser();
                if(client != null){
                    ActionBar actionBar = getSupportActionBar();
                    Intent intent = getIntent();
                    Number = intent.getStringExtra("table");
                    intent.putExtra("table",Number);
                    actionBar.setTitle("Table "+Number);
                }
            }
        };


    }

    @Override
    public void onStart(){
        super.onStart();
        Auth.addAuthStateListener(AuthListener);
    }

    @Override
    public void onStop(){
        super.onStop();
        if(AuthListener != null){
            Auth.removeAuthStateListener(AuthListener);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        menuInflater.inflate(R.menu.logout,menu);
        MenuItem item=menu.findItem(R.id.search);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(item);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                myadapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myadapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.sorting){
            sortDialog();
            return true;
        }else if (id == R.id.logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void sortDialog(){
        String[] options={"Ascending","Descending"};
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setTitle("Sort by");
        builder.setIcon(R.drawable.ic_sort_black_24dp);

        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which==0){
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putString("Sort","ascending");
                    editor.apply();
                    getMyList();
                }
                if (which==1){
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putString("Sort","descending");
                    editor.apply();
                    getMyList();
                }
            }
        });

        builder.create().show();
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(Menulist.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }



    private void  getMyList(){
        ArrayList<Model>models=new ArrayList<>();

        Model model= new Model("Caprese Salad with Pesto Sauce","3500",R.drawable.caprese,1);
        models.add(model);


        model= new Model("Panzenella","3000",R.drawable.panzenella,2);
        models.add(model);


        model= new Model("Bagel and Lox","2500",R.drawable.bagel,3);
        models.add(model);


        model= new Model("Deep-Dish Pizza","1500",R.drawable.deep,4);
        models.add(model);


        model= new Model("Sausage Gravy","6000",R.drawable.sausage,5);
        models.add(model);


        model= new Model("Texas Barbecue","3000",R.drawable.texas,6);
        models.add(model);


        model= new Model("Fried Green Tomatoes","2000",R.drawable.alabama,7);
        models.add(model);


        model= new Model("Fried Catfish","2500",R.drawable.arkansas,7);
        models.add(model);


        model= new Model("Fish Tacos","2000",R.drawable.california,8);
        models.add(model);


        model= new Model("Warm Lobster Roll","7000",R.drawable.warm,9);
        models.add(model);


        model= new Model("Spaghetti Allo Scolio","10900",R.drawable.spaghetti,10);
        models.add(model);


        model= new Model("Chocolate Chip Cookie","1600",R.drawable.chocolate,11);
        models.add(model);


        model= new Model("Fruit Salad","4600",R.drawable.fruit,12);
        models.add(model);


        model= new Model("Avocado, spinach & feta","5000",R.drawable.avocado,13);
        models.add(model);


        model= new Model("Iced Tea with Fresh Juice","2500",R.drawable.iced,14);
        models.add(model);


        model= new Model("Yogurt Smoothies","3200",R.drawable.yogurt,15);
        models.add(model);


        model= new Model("the christian brothers brandy","9000",R.drawable.christian,16);
        models.add(model);


        model= new Model("d’ussé","10000",R.drawable.usse,17);
        models.add(model);


        model= new Model("cardenal mendoza","4000",R.drawable.cardenal,18);
        models.add(model);


        model= new Model("Blueberry Mojito","2900",R.drawable.blueberry,19);
        models.add(model);


        model= new Model("Watermelon Lychee Granita","7000",R.drawable.watermelon,20);
        models.add(model);


        model= new Model("Grape juice","700",R.drawable.grape,21);
        models.add(model);


        model= new Model("Orange juice","1000",R.drawable.orange,22);
        models.add(model);


        model= new Model("Fried Chicken","4000",R.drawable.fried,23);
        models.add(model);

        String sortSetting =preferences.getString("Sort","ascending");

        if (sortSetting.equals("ascending")){
            Collections.sort(models,Model.By_Menu_Ascending);
        }else if (sortSetting.equals("descending")){
            Collections.sort(models,Model.By_Menu_Descending);
        }


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myadapter=new Myadapter(this,models);
        recyclerView.setAdapter(myadapter);



    }

    @Override
    public void onClick(View v) {
        if (v== viewOrder){
            Intent intent=new Intent(Menulist.this,OrderedItems.class);
            startActivity(intent);
        }
    }

//    private void display(int number) {
//        TextView quantityText = (TextView) findViewById(R.id.quantity);
//        quantityText.setText("" + number);
//    }
//
//    private void displayPrice(int price) {
//        TextView priceText = (TextView) findViewById(R.id.price);
//        priceText.setText("Frw " + price);
//    }
//
//    public void decrement(View view) {
//        if (quantity>1) {
//            quantity = quantity - 1;
//            display(quantity);
//        }
////        price = calculatePrice();
//        displayPrice(price);
//    }
//
//    public void increment(View view) {
//        quantity = quantity + 1;
//        display(quantity);
////        price = calculatePrice();
//        displayPrice(price);
//    }
//
////    private int calculatePrice() {
////        price = quantity * Integer.parseInt(prize);
////
////        return price;
////    }
}
