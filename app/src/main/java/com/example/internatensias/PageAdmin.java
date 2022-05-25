package com.example.internatensias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PageAdmin extends AppCompatActivity {
Button btnAdminResidents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_admin);
        btnAdminResidents=findViewById(R.id.btnAdminResidants);
        btnAdminResidents.setOnClickListener(view -> {
            startActivity(new Intent(PageAdmin.this, MenuAdmResident.class));
        });
    }
}