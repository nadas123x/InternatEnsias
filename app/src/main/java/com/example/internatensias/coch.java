package com.example.internatensias;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class coch extends AppCompatActivity {
    EditText textrec;
    EditText textrec1;
    Button button;
    DatabaseReference reff;
    cochambre cochambre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coch);
        textrec=(EditText)findViewById(R.id.textrec);
        textrec1=(EditText)findViewById(R.id.textrec1);
        button=(Button)findViewById(R.id.button);
        cochambre= new cochambre();
        reff= FirebaseDatabase.getInstance().getReference().child("cochambre");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cochambre.setNom1(textrec.getText().toString().trim());
                cochambre.setNom2(textrec1.getText().toString().trim());
                reff.push().setValue(cochambre);


            }
        });
    }
}
