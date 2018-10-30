package moe.proncan.myapp7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    DatePicker datePicker;
    Button btnReset, btnGetDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView2);
        datePicker = findViewById(R.id.datePicker);
        btnReset = findViewById(R.id.button);
        btnGetDate = findViewById(R.id.button2);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("0000/00/00");
            }
        });

        btnGetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = datePicker.getYear();
                int month = datePicker.getMonth() + 1;
                int date = datePicker.getDayOfMonth();

                textView.setText(year + "/" + month + "/" + date);
            }
        });
    }
}
