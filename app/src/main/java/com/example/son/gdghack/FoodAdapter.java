package com.example.son.gdghack;

import android.app.Activity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

/**
 * Created by hoang on 11/18/2017.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{
    private static final String TAG = "" ;
    private List<Food> foodList;
    private Activity activity;

    public FoodAdapter(List<Food> foodList, Activity activity) {
        this.foodList = foodList;
        this.activity = activity;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        private TextView fname;
        private TextView price;
        public FoodViewHolder(View itemView) {
            super(itemView);
            fname = (TextView) itemView.findViewById(R.id.nameFood);
            price = (TextView) itemView.findViewById(R.id.price);
        }
    }
    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /** Get layout */
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food,parent,false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        /** Set Value*/
        final Food food = foodList.get(position);
        holder.fname.setText(food.getFname());
        holder.price.setText(food.getPrice());
    }

    @Override
    public int getItemCount() {
        return foodList.size();

    }



}
