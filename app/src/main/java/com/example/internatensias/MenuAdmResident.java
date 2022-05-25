package com.example.internatensias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MenuAdmResident extends AppCompatActivity {
    Button listeresid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_adm_resident);
        listeresid=findViewById(R.id.listeresid);

        listeresid.setOnClickListener(view -> {
            startActivity(new Intent(MenuAdmResident.this, MainActivity2.class));
        });
    }
}