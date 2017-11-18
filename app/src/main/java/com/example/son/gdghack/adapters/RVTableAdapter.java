package com.example.son.gdghack.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import com.example.son.gdghack.R;
import com.example.son.gdghack.models.Table;

import java.util.List;

/**
 * Created by S.O.N on 11/18/2017.
 */

public class RVTableAdapter extends RecyclerView.Adapter<RVTableAdapter.TableViewHolder> {

    private static final String TAG = "Amen";
    private Context context;
    private List<Table> tables;
    public static ToggleButton preToggle;
    public static Table preTable;

    class TableViewHolder extends RecyclerView.ViewHolder {

        ToggleButton toggleButton;

        public TableViewHolder(View itemView) {
            super(itemView);
            toggleButton = itemView.findViewById(R.id.toggle_bt);
            toggleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (preToggle != null) {
                        preToggle.setChecked(false);
                    }
                    preToggle = toggleButton;
                    preTable = findTable(Integer.parseInt(preToggle.getText().toString()));
                }
            });
        }

        public void setData(Table table) {
            Log.d(TAG, "setData: " + table.toString());
            toggleButton.setText(String.format("%d",table.getTableNo()));
            toggleButton.setTextOn(String.format("%d",table.getTableNo()));
            toggleButton.setTextOff(String.format("%d",table.getTableNo()));
            if (table.getStatus() == 1) {
                toggleButton.setBackgroundColor(Color.parseColor("#cc222222"));
                toggleButton.setClickable(false);
            }
        }
    }

    public RVTableAdapter(List<Table> tables) {
        this.tables = tables;
    }

    @Override
    public TableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_table, parent, false);
        return new TableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TableViewHolder holder, int position) {
        holder.setData(tables.get(position));
    }

    @Override
    public int getItemCount() {
        return tables.size();
    }

    public Table findTable(int number) {
        for (Table table : tables) {
            if (table.getTableNo() == number) return table;
        }
        return null;
    }

}
