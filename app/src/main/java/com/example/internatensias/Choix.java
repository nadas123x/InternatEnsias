package com.example.internatensias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choix extends AppCompatActivity {
Button btnvisiteur;
Button button2;
Button btnAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix
        );
        btnAdmin=findViewById(R.id.btnAdmin);
        btnvisiteur=findViewById(R.id.btnvisiteur);
        button2=findViewById(R.id.button2);
        btnvisiteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Choix.this, Visiteurmenu.class));

            }

        });
        button2.setOnClickListener(view -> {
            startActivity(new Intent(Choix.this, login.class));
        });
        btnAdmin.setOnClickListener(view -> {
            startActivity(new Intent(Choix.this, PageAdmin.class));
        });


    }
}