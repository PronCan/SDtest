package moe.proncan.javacode;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1);
        LinearLayout[] linearLayouts = new LinearLayout[7];

        for(int i = 0; i < linearLayouts.length; i++) {
            linearLayouts[i] = new LinearLayout(this);
            linearLayouts[i].setLayoutParams(params);
        }

        linearLayouts[0].setOrientation(LinearLayout.VERTICAL);
        linearLayouts[1].setOrientation(LinearLayout.HORIZONTAL);
        linearLayouts[4].setOrientation(LinearLayout.VERTICAL);

        linearLayouts[2].setBackgroundColor(Color.RED);
        linearLayouts[5].setBackgroundColor(Color.YELLOW);
        linearLayouts[3].setBackgroundColor(Color.BLUE);
        linearLayouts[6].setBackgroundColor(Color.GREEN);

        linearLayouts[0].addView(linearLayouts[1]);
        linearLayouts[0].addView(linearLayouts[2]);

        linearLayouts[1].addView(linearLayouts[3]);
        linearLayouts[1].addView(linearLayouts[4]);

        linearLayouts[4].addView(linearLayouts[5]);
        linearLayouts[4].addView(linearLayouts[6]);

        setContentView(linearLayouts[0]);

    }
}
