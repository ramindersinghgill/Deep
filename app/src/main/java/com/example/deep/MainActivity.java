package com.example.deep;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText text1,text2;
    Button btn;
    TextView txt;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1=(EditText)findViewById(R.id.editText);
        text2=(EditText)findViewById(R.id.editText2);
        btn=(Button)findViewById(R.id.button2);
        txt=(TextView)findViewById(R.id.textView);

        firebaseAuth=FirebaseAuth.getInstance();
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=text1.getText().toString();
                String pass=text2.getText().toString();
                if(TextUtils.isEmpty(email)|| TextUtils.isEmpty(pass)){
                    Toast.makeText(MainActivity.this,"fields are empty",Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"task is sucessfull",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),Home .class));

                            }
                            else{
                                Toast.makeText(MainActivity.this,"sign in problem",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
            }
        });

    }
    }

