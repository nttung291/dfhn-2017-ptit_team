package com.example.son.gdghack;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.son.gdghack.adapters.RVTableAdapter;

/**
 * Created by S.O.N on 11/18/2017.
 */

public class CustomDialogClass extends Dialog implements
        android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;
    private TextView tvTable;
    private TextView tvFloor;
    private TextView tvNumberSeat;
    private TextView tvDes;

    public CustomDialogClass(Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        yes = (Button) findViewById(R.id.btn_confirm);
        no = (Button) findViewById(R.id.btn_cancel);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        tvDes = findViewById(R.id.tv_des);
        tvFloor = findViewById(R.id.tv_floor);
        tvNumberSeat = findViewById(R.id.tv_numberSeat);
        tvTable = findViewById(R.id.tv_table_number);

        Log.d("YEAH", "onCreate: " + RVTableAdapter.preTable.getTableNo());
        tvTable.setText(String.format("%d", RVTableAdapter.preTable.getTableNo()));
        tvDes.setText(tvDes.getText().toString() + RVTableAdapter.preTable.getDescription());
        tvFloor.setText(tvFloor.getText().toString() + RVTableAdapter.preTable.getFloor());
        tvNumberSeat.setText(tvNumberSeat.getText().toString() + RVTableAdapter.preTable.getSeatAmount());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_confirm:
                c.startActivity(new Intent(c.getApplicationContext(), DeliveryNow.class));
                break;
            case R.id.btn_cancel:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
