package com.example.son.gdghack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DeliveryNow extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_now);
        addControl();
        addEvent();
    }
    private void addControl(){
        recyclerView = (RecyclerView) findViewById(R.id.DeliveryNow);
        foodList = new ArrayList<>();
        foodAdapter = new FoodAdapter(foodList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(foodAdapter);
    }

    private void addEvent() {
        /** Call method add data*/
        createData();
    }

    /** Add data to bookList*/
    public void createData() {
        Food food = new Food("Pho cuon","120.000");
        foodList.add(food);
        food = new Food("Banh cuon","150.000");
        foodList.add(food);
        food = new Food("My xao","110.000");
        foodList.add(food);
        food = new Food("Com rang","100.000");
        foodList.add(food);
        food = new Food("Suon xao chua ngot","120.000");
        foodList.add(food);
        foodAdapter.notifyDataSetChanged();
    }

}
