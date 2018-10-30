package moe.proncan.chap06;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button check;
    TextView waTime, waConvert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        check = findViewById(R.id.button);
        waTime = findViewById(R.id.textView);
        waConvert = findViewById(R.id.textView2);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hour = String.format((Integer.parseInt(waTime.getText().toString())/1000/60/60)%60 + "");
                String min = String.format((Integer.parseInt(waTime.getText().toString())/1000/60)%60 + "");
                String sec = String.format((Integer.parseInt(waTime.getText().toString())/1000)%60 + "");

                waTime.setText(SystemClock.elapsedRealtime() + "");
                waConvert.setText(hour + "시간 " + min + "분 " +  sec + "초");
            }
        });

    }
}
