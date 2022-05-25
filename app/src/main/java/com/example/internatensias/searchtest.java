package com.example.internatensias;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

public class searchtest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchtest);
        String q = null;
        Intent search = new Intent();
        search.setAction(Intent.ACTION_WEB_SEARCH);
        search.putExtra(SearchManager.QUERY, q);
        if (search.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(search, "Veuillez choisir un navigateur..."));
        }

    }
}