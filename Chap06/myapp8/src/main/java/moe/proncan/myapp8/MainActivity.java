package moe.proncan.myapp8;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnEnd;
    RadioButton radioButton1, radioButton2;
    CalendarView calendarView;
    TimePicker timePicker;
    Chronometer chronometer;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnEnd);
        radioButton1 = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        calendarView = findViewById(R.id.calendarView);
        timePicker = findViewById(R.id.timePicker);
        chronometer = findViewById(R.id.chronometer);
        textView = findViewById(R.id.textView);

        timePicker.setVisibility(View.INVISIBLE);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date = new Date(calendarView.getDate());
                int hour = timePicker.getHour();
                int min = timePicker.getMinute();
                textView.setText((date.getYear()+1900) + "년 " + date.getMonth() + "월 " + date.getDate() + "일 " + hour + "시 " + min + "분 예약됨");
                chronometer.stop();
            }
        });

        radioButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    calendarView.setVisibility(View.VISIBLE);
                    timePicker.setVisibility(View.INVISIBLE);
                }
            }
        });

        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    timePicker.setVisibility(View.VISIBLE);
                    calendarView.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
