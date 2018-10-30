package moe.proncan.project4_5_exer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    CheckBox cbEnable, cbClickable, cbRotation;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbEnable = findViewById(R.id.checkBox);
        cbClickable = findViewById(R.id.checkBox2);
        cbRotation = findViewById(R.id.checkBox3);
        btn = findViewById(R.id.button);

        cbEnable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                System.out.println("************************" + buttonView.getId());
                if(isChecked) {
                    btn.setEnabled(true);
                } else {
                    btn.setEnabled(false);
                }
            }
        });

        cbClickable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                System.out.println("************************" + buttonView);

                if(isChecked) {
                    btn.setClickable(true);
                } else {
                    btn.setClickable(false);
                }
            }
        });

        cbRotation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                System.out.println("************************" + buttonView);
                if(isChecked) {
                    btn.setRotation(45);
                } else {
                    btn.setRotation(0);
                }
            }
        });
    }
}
