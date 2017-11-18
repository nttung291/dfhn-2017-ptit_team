package com.example.son.gdghack;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.son.gdghack.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity implements View.OnClickListener{

    Button bnLogIn, bnSignup;
    EditText etUserName;
    EditText etPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mAuth = FirebaseAuth.getInstance();

        setupUI();

        bnSignup = (Button) findViewById(R.id.signup);

        View.OnClickListener signupBtn = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final Intent moveToSignUp = new Intent(LogIn.this, LogIn.class);
                LogIn.this.startActivity(moveToSignUp);
            }
        };
        bnSignup.setOnClickListener(signupBtn);
    }

    private void setupUI() {
        bnLogIn = findViewById(R.id.login);
        etPassword = findViewById(R.id.password);
        etUserName = findViewById(R.id.name);
    }

    public void signIn() {
        String email = "";
        String password = "";

        email = "" + etUserName.getText();
        password = "" + etPassword.getText();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(LogIn.this, Booking.class));
                        } else {
                            Toast.makeText(LogIn.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                signIn();
                break;
        }
    }


}
