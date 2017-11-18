package com.example.son.gdghack;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.son.gdghack.event.OnClickPickTime;
import com.example.son.gdghack.models.Guest;
import com.example.son.gdghack.models.User;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.*;

public class Booking extends AppCompatActivity {

    Button btnChangeDate, btnChangeTime, btnContinue;
    TextView txtDate, txtTime;
    Calendar cal;
    Date date, gio;
    Toolbar toolbar;
    Guest guest;
    EditText numberGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        setupUI();
    }

    private void setupUI() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        numberGuest = findViewById(R.id.numberGuest);
        btnContinue = findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guest = new Guest(txtDate.getText().toString(),txtTime.getText().toString(),Integer.parseInt(numberGuest.getText().toString()));
                startActivity(new Intent(Booking.this, BookTable.class));

            }
        });

        btnChangeDate = (Button) findViewById(R.id.btnEditDate);
        txtDate = (TextView) findViewById(R.id.date);
        btnChangeDate.setOnClickListener(showDatePicker);

        //Set ngày giờ hiện tại khi mới chạy lần đầu
        cal=Calendar.getInstance();
        SimpleDateFormat dft=null;
        //Định dạng kiểu ngày / tháng /năm
        dft=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String strDate=dft.format(cal.getTime());
        //hiển thị lên giao diện
        txtDate.setText(strDate);

        txtTime = (TextView) findViewById(R.id.time);
        btnChangeTime = (Button) findViewById(R.id.btnEditTime);
        btnChangeTime.setOnClickListener(showTimePicker);
        //Định dạng giờ phút am/pm
        dft = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String strTime = dft.format(cal.getTime());
        //đưa lên giao diện
        txtTime.setText(strTime);
        //lấy giờ theo 24 để lập trình theo Tag
        dft = new SimpleDateFormat("HH:mm", Locale.getDefault());
        txtTime.setTag(dft.format(cal.getTime()));
    }

    // Sự kiện khi click vào nút changedate
    View.OnClickListener showDatePicker = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener() {
                //Sự kiện khi click vào nút Done trên Dialog
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    // Set text cho textView
                    txtDate.setText(day + "/" + (month +1) + "/" + year);
                    //Lưu vết lại ngày mới cập nhật
                    cal.set(year, month, day);
                    date = cal.getTime();
                }
            };
            String s=txtDate.getText()+"";
            //Lấy ra chuỗi của textView Date
            String strArrtmp[]=s.split("/");
            int ngay=Integer.parseInt(strArrtmp[0]);
            int thang=Integer.parseInt(strArrtmp[1]) - 1;
            int nam=Integer.parseInt(strArrtmp[2]);
            //Hiển thị ra Dialog
            DatePickerDialog pic=new DatePickerDialog(
                    Booking.this,
                    callback, nam, thang, ngay);
            pic.show();
        }
    };

    View.OnClickListener showTimePicker = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TimePickerDialog.OnTimeSetListener callback = new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                    //Xử lý lưu giờ và AM,PM
                    String s = hour + ":" + minute;
                    int hourTam = hour;
                    if (hourTam > 12)
                        hourTam = hourTam - 12;
                    txtTime.setText
                            (hourTam + ":" + minute + (hour > 12 ? " PM" : " AM"));
                    //lưu giờ thực vào tag
                    txtTime.setTag(s);
                    //lưu vết lại giờ
                    cal.set(Calendar.HOUR_OF_DAY, hour);
                    cal.set(Calendar.MINUTE, minute);
                    gio = cal.getTime();
                }
            };
            String s = txtTime.getTag() + "";
            String strArr[] = s.split(":");
            int gio = Integer.parseInt(strArr[0]);
            int phut = Integer.parseInt(strArr[1]);
            TimePickerDialog time = new TimePickerDialog(
                    Booking.this,
                    callback, gio, phut, true);
            time.setTitle("Chọn giờ hoàn thành");
            time.show();
        }
    };


}
