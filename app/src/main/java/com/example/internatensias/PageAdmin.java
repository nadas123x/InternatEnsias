package com.example.internatensias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PageAdmin extends AppCompatActivity {
Button btnAdminResidents,btnAdminDemandes,btnAdminProblemes,logout;
    Button btnAdminMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_admin);

        btnAdminResidents=findViewById(R.id.btnAdminResidants);
        btnAdminDemandes=findViewById(R.id.btnAdminDemandes);
        btnAdminProblemes=findViewById(R.id.btnAdminProblemes);
        logout=findViewById(R.id.logout);

        btnAdminResidents.setOnClickListener(view -> {
            startActivity(new Intent(PageAdmin.this, MenuAdmResident.class));
        });
        btnAdminDemandes.setOnClickListener(view -> {
            startActivity(new Intent(PageAdmin.this, MainActivityDemande.class));
        });
        btnAdminProblemes.setOnClickListener(view -> {
            startActivity(new Intent(PageAdmin.this, ListeProblemes.class));
        });
        logout.setOnClickListener(view -> {
            startActivity(new Intent(PageAdmin.this, LoginAdmin.class));
        });

        btnAdminMsg = (Button)findViewById(R.id.btnAdminMsg);
        btnAdminMsg.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://mail.google.com/mail/u/0/#inbox";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
                startActivity(intent);
            }
        });
    }
}