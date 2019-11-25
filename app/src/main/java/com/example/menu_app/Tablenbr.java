package com.example.menu_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.menu_app.models.tableNumber;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Tablenbr extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.tablenbr)
    TextInputEditText Tablenbr;
    @BindView(R.id.button1)
    Button StartOrder;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablenbr);
        ButterKnife.bind(this);
        StartOrder.setOnClickListener(this);
        databaseReference= FirebaseDatabase.getInstance().getReference("Tables");

    }

    @Override
    public void onClick(View v) {
        if (v==StartOrder){
            addNbr();

        }
    }
    private void addNbr(){
        String number=Tablenbr.getText().toString().trim();
        if(!TextUtils.isEmpty(number)){
           String id= databaseReference.push().getKey();
            tableNumber tableNumber=new tableNumber(number,id);
            databaseReference.child(id).setValue(tableNumber);
            Toast.makeText(this,"Table Added",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this,"you should enter the table's name",Toast.LENGTH_LONG).show();
        }
    }
}
