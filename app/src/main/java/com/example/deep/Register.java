package com.example.deep;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText text3, text4,text5,text6;
    Button sign;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        text3=(EditText)findViewById(R.id.editText3);
        text4=(EditText)findViewById(R.id.editText4);
        text5=(EditText)findViewById(R.id.editText5);
        text6=(EditText)findViewById(R.id.editText6);
        sign=(Button)findViewById(R.id.button);
        firebaseAuth=FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser()!=null){
        //startActivity(new Intent(getApplicationContext(),MainActivity.class));
        //finish();
        }
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=text3.getText().toString();
                String email =text4.getText().toString();
                String phone=text5.getText().toString();
                String pass=text6.getText().toString();
                if(TextUtils.isEmpty(name)) {
                    Toast.makeText(getApplicationContext(), "enter the namel", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(getApplicationContext(),"enter the email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(phone))
                {
                    Toast.makeText(getApplicationContext(),"enter the phone",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(pass))
                {
                    Toast.makeText(getApplicationContext(),"enter the password",Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"registration problem",Toast.LENGTH_SHORT).show();

                            return;
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"user register",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            return;
                        }
                    }
                });


            }
        });
    }
    }

