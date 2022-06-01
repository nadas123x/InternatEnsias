package com.example.internatensias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MenuAdmResident extends AppCompatActivity {
    Button listeresid;
    Button profil,contacts,Chambres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_adm_resident);
        profil=findViewById(R.id.profil);
        contacts=findViewById(R.id.profil);
        Chambres=findViewById(R.id.Chambres);

        listeresid=findViewById(R.id.listeresid);

        listeresid.setOnClickListener(view -> {
            startActivity(new Intent(MenuAdmResident.this, MainActivity2.class));
        });
        profil.setOnClickListener(view -> {
            startActivity(new Intent(MenuAdmResident.this, MainActivityProfil.class));
        });
        contacts.setOnClickListener(view -> {
            startActivity(new Intent(MenuAdmResident.this, MainActivity2.class));
        });
        Chambres.setOnClickListener(view -> {
            startActivity(new Intent(MenuAdmResident.this, MainActivityChambres.class));
        });
    }
}