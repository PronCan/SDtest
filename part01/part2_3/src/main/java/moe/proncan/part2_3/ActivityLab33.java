package moe.proncan.part2_3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityLab33 extends AppCompatActivity implements View.OnClickListener {
    Button trueBtn, falseBtn;
    TextView textView;

    @Override
    public void onClick(View v) {
        if (v == trueBtn) {
            textView.setVisibility(View.VISIBLE);
        } else if(v==falseBtn) {
            textView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab33);

        trueBtn = findViewById(R.id.button);
        falseBtn = findViewById(R.id.button2);
        textView = findViewById(R.id.text1);

        trueBtn.setOnClickListener(this);
        falseBtn.setOnClickListener(this);

    }
}
