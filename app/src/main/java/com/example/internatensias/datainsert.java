package com.example.internatensias;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class datainsert extends AppCompatActivity {
    EditText textrec;
    Button button;
    DatabaseReference reff;
    member member;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_datainsert);
            textrec=(EditText)findViewById(R.id.textrec);
            button=(Button)findViewById(R.id.button);
            member= new member();
            reff= FirebaseDatabase.getInstance().getReference().child("member");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    member.setReclamation(textrec.getText().toString().trim());
                    reff.push().setValue(member);
                    Toast.makeText(datainsert.this, "data insered successfully", Toast.LENGTH_SHORT).show();

                }
            });
        }
        }

