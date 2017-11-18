package com.example.son.gdghack;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BookTable extends AppCompatActivity {

    Toolbar mToolbar;
    TextView tvAppBarTitle;
    ImageView ivBack;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_table);

        mToolbar = findViewById(R.id.toolbar);
        ivBack = findViewById(R.id.iv_back);
        tvAppBarTitle = findViewById(R.id.app_bar_title);

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
