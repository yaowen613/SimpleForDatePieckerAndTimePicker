package com.yaowen.calendarview03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.tpPicker);
        datePicker.setCalendarViewShown(false);
//        datePicker.setSpinnersShown(false);
        datePicker.init(2015, 10, 27, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat format = new SimpleDateFormat("你选择的是：" + "yyyy年MM月dd日 HH:mm");
                Toast.makeText(MainActivity.this, format.format(calendar.getTime()), Toast.LENGTH_SHORT).show();
            }
        });
        timePicker.setIs24HourView(true);//设置日期是否为24小时制
        //为timepicker添加监听事件
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                //提示时间的变化，显示变化后的时间
                Toast.makeText(MainActivity.this, "你选择的是：" + hourOfDay + "时" + minute + "分", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
