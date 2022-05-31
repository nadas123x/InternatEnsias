package com.example.internatensias;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivityProfil extends AppCompatActivity
{
    RecyclerView recview;
    myadapterDemande adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maindemande);
        setTitle("Rechercher");






        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<demande> options =
                new FirebaseRecyclerOptions.Builder<demande>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("DemandeBenef"), demande.class)
                        .build();

        adapter=new myadapterDemande(options);
        recview.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.searchmenu,menu);

        MenuItem item=menu.findItem(R.id.search);

        SearchView searchView=(SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String s) {

                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void processsearch(String s)
    {
        FirebaseRecyclerOptions<demande> options =
                new FirebaseRecyclerOptions.Builder<demande>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("DemandeBenef").orderByChild("nom").startAt(s).endAt(s+"\uf8ff"), demande.class)
                        .build();

        adapter=new myadapterDemande(options);
        adapter.startListening();
        recview.setAdapter(adapter);

    }
}