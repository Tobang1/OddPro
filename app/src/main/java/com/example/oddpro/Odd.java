package com.example.oddpro;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Odd extends AppCompatActivity {

    // declare variables
    RecyclerView recyclerView;
    ArrayList<FreeOdd> freeOddArrayList;
    MyAdapter myAdapter;
    FirebaseFirestore db;
    ProgressDialog progressDialog;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odd);
//bottom navigator
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.Odd);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching Data");
        progressDialog.show();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        freeOddArrayList = new ArrayList<FreeOdd>();
        myAdapter = new  MyAdapter(Odd.this,freeOddArrayList);

        recyclerView.setAdapter(myAdapter);
        EventChangeListener();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
// if button is selected for animation
                switch (item.getItemId())
                {

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class ));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Odd:
                        return true;

                    case R.id.LiveScore:
                        startActivity(new Intent(getApplicationContext(), LiveScore.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Settings:
                        startActivity(new Intent(getApplicationContext(), Settings.class));
                        overridePendingTransition(0,0);

                        return true;
                }
                //anything else is selected it should return false
                return false;
            }
        });

    }

    private void EventChangeListener() {
        //db to fetch data from freeOdd and table freeHome, freeAway. League
        db.collection("freeOdd").orderBy("freeHome", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if (error != null) {

                            if (progressDialog.isShowing())
                                progressDialog.dismiss();

// error if not connecting to firestore
                            Log.e("firestore error", error.getMessage());
                            return;
                        }
                        for (DocumentChange dc : value.getDocumentChanges()) {
                            if (dc.getType() == DocumentChange.Type.ADDED) {

                                freeOddArrayList.add(dc.getDocument().toObject(FreeOdd.class));
                            }
                            myAdapter.notifyDataSetChanged();

                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
                        }
                    }
                });
    }
}