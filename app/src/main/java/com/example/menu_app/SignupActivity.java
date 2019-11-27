package com.example.menu_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignupActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText password;
    private Button signUp;
    private TextView loginPage;
    private FirebaseAuth authentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        authentication = FirebaseAuth.getInstance();

        name = (EditText) findViewById(R.id.name);
        email= (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signUp = (Button) findViewById(R.id.signup);
        loginPage = (TextView) findViewById(R.id.loginPage);

        loginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String mail = email.getText().toString();
                String pass = password.getText().toString();
                String username = name.getText().toString();

                if(email.getText().length()==0){
                    email.setError("This field is required!");
                    email.requestFocus();
                }
                else if(password.getText().length()==0){
                    password.setError("This field is required");
                    password.requestFocus();
                }
                else if(email.getText().length()==0 && password.getText().length()==0){
                    Toast.makeText(SignupActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else if(email.getText().length()!=0 && password.getText().length()!=0){

                    authentication.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Toast.makeText(SignupActivity.this, "Your account have been registered!", Toast.LENGTH_SHORT).show();
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignupActivity.this, "Authentication failed! Please try again!", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                                finish();
                            }
                        }
                    });
                }

            }
        });
    }
}
