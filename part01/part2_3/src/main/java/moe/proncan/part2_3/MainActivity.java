package moe.proncan.part2_3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);

        Button btn1 = new Button(this);
        btn1.setText("btn1");
        linearLayout.addView(btn1);

        Button btn2 = new Button(this);
        btn2.setText("btn2");
        linearLayout.addView(btn2);

        setContentView(linearLayout);
    }
}
