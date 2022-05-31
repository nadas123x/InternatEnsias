package com.example.internatensias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class proposResid extends AppCompatActivity {
Button buv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propos_resid);
        buv=findViewById(R.id.buv);

        buv.setOnClickListener(view -> {
            startActivity(new Intent(proposResid.this, buvette.class));
        });
    }
}