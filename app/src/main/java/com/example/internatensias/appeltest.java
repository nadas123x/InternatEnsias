package com.example.internatensias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class appeltest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appeltest);
        Intent Mylntent = new Intent();
        Mylntent.setAction(Intent.ACTION_DIAL);
        Mylntent.setData(Uri.parse("te1:0666666666"));
        if (Mylntent.resolveActivity(getPackageManager()) != null)
        { startActivity(Mylntent);
        }

    }
}