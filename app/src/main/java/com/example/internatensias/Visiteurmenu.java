package com.example.internatensias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Visiteurmenu extends AppCompatActivity {
Button Internat;
    Button demande,faq,contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visiteurmenu);
        Internat=findViewById(R.id.Internat);
        demande=findViewById(R.id.demande);
        contact=findViewById(R.id.contact);
        faq=findViewById(R.id.faq);


        Internat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Visiteurmenu.this, Visiteurpage.class));

            }



        });

        demande.setOnClickListener(view -> {
            startActivity(new Intent(Visiteurmenu.this, Adddemande.class));
        });

        faq.setOnClickListener(view -> {
            startActivity(new Intent(Visiteurmenu.this, faqVisiteur.class));
        });
        contact.setOnClickListener(view -> {
            startActivity(new Intent(Visiteurmenu.this, contactVisiteur.class));
        });
    }
}