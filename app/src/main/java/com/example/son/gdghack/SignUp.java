package com.example.son.gdghack;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {
    private String name, pass, pass1;
    private FirebaseAuth mAuth;
    private Button signup;
    EditText tmp1, tmp2, tmp3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        tmp1 = (EditText) findViewById(R.id.name);

        tmp2= (EditText) findViewById(R.id.password);

        tmp3 = (EditText) findViewById(R.id.rePassword);

        signup = (Button) findViewById(R.id.signup);

        View.OnClickListener signupBtn = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                pass = tmp2.getText().toString();
                name = tmp1.getText().toString();
                pass1 = tmp3.getText().toString();
                if (!check ()) {
                    Toast.makeText(SignUp.this,  "Not allowed!" , Toast.LENGTH_SHORT).show();
                }
                else {
                    createAccount();
                }
            }
        };
        signup.setOnClickListener(signupBtn);
    }
    
    private boolean check (){
        if (name.compareTo("") == 0 || pass.compareTo("") == 0 || pass1.compareTo("") == 0 ) return false;
        if (pass.compareTo(pass1) != 0) return false;
        return true;
    }

    private void createAccount( ){
        String email = name;
        String password = pass;
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(SignUp.this, "Success",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            final Intent moveToLogIn = new Intent(SignUp.this, LogIn.class);
                            SignUp.this.startActivity(moveToLogIn);

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(SignUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }



}
