package moe.proncan.myapp4;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Chronometer chronometer;
    Button btnStart, btnStop, btnReset;

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnStart :
                chronometer.start();
                break;
            case R.id.btnStop :
                chronometer.stop();
                break;
            case R.id.btnReset :
                chronometer.setBase(SystemClock.elapsedRealtime());
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnReset = findViewById(R.id.btnReset);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }
}
