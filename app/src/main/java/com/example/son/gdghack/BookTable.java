package com.example.son.gdghack;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.son.gdghack.adapters.RVTableAdapter;
import com.example.son.gdghack.models.Table;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class BookTable extends AppCompatActivity {
    private static final String TAG = "Amen";
    private Toolbar mToolbar;
    private TextView tvAppBarTitle;
    private ImageView ivBack;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private List<Table> tables;
    private RecyclerView rvTable;
    private RVTableAdapter rvTableAdapter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_table);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("seats");
        setupUI();
        loadData();
    }

    private void loadData() {
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Table table = dataSnapshot.getValue(Table.class);
                tables.add(table);
                rvTableAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.d(TAG, "onChildChanged: ");
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.d(TAG, "onChildRemoved: ");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                Log.d(TAG, "onChildMoved: ");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "onCancelled: ");
            }
        });
    }

    private void setupUI() {
        tables = new ArrayList<>();

        mToolbar = findViewById(R.id.toolbar);
        ivBack = findViewById(R.id.iv_back);
        tvAppBarTitle = findViewById(R.id.app_bar_title);
        rvTable = findViewById(R.id.rv_list_table);
        rvTableAdapter = new RVTableAdapter(tables);
        rvTable.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvTable.setAdapter(rvTableAdapter);

        setSupportActionBar(mToolbar);
        tvAppBarTitle.setText(getString(R.string.table));
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookTable.super.onBackPressed();
            }
        });
    }
}
