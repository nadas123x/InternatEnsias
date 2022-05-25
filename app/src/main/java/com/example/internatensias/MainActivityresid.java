package com.example.internatensias;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivityresid extends AppCompatActivity {
Button logout,propos,faqq;
ImageView botchat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mainn);
        Toast.makeText(MainActivityresid.this, " Vous êtes les bienvenus", Toast.LENGTH_LONG).show();
        logout=findViewById(R.id.logout);
        propos=findViewById(R.id.propos);
        faqq=findViewById(R.id.faqq);
        botchat=findViewById(R.id.botchat);

        logout.setOnClickListener(view -> {
            startActivity(new Intent(MainActivityresid.this, login.class));
        });
        propos.setOnClickListener(view -> {
            startActivity(new Intent(MainActivityresid.this, proposResid.class));
        });
        faqq.setOnClickListener(view -> {
            startActivity(new Intent(MainActivityresid.this, faqVisiteur.class));
        });
        botchat.setOnClickListener(view -> {
            startActivity(new Intent(MainActivityresid.this, MainActivitybot.class));
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuother:
                Intent appel = new Intent(MainActivityresid.this, datainsert.class);
                startActivity(appel);

            case R.id.menuother2:
                Toast.makeText(this, "other_menu2 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuother3:
                Intent appel3 = new Intent(MainActivityresid.this, email.class);
                startActivity(appel3);
            case R.id.menuother4:
                Intent appel2 = new Intent(MainActivityresid.this, coch.class);
                startActivity(appel2);

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}