package moe.proncan.project14_44;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Switch aSwitch;
    RadioGroup radioGroup;
    RadioButton rbArray[] = new RadioButton[3];
    ImageView imageView;
    Button btOut, btReturn;
    LinearLayout hiddenLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch = findViewById(R.id.startSwitch);
        radioGroup = findViewById(R.id.radioGroup);
        rbArray[0] = findViewById(R.id.nougatRadio);
        rbArray[1] = findViewById(R.id.lolRadio);
        rbArray[2] = findViewById(R.id.mashRadio);
        imageView = findViewById(R.id.imageView);
        btOut = findViewById(R.id.endButton);
        btReturn = findViewById(R.id.backButton);
        hiddenLinear = findViewById(R.id.hiddenLinear);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (aSwitch.isChecked() == true) {
                    hiddenLinear.setVisibility(View.VISIBLE);
                } else {
                    hiddenLinear.setVisibility(View.INVISIBLE);
                }
            }
        });

        final int draw[] = {R.drawable.api50, R.drawable.api60, R.drawable.api70};
        for(int i=0; i<rbArray.length; i++) {
            final int index = i;
            rbArray[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageView.setImageResource(draw[index]);
                }
            });
        }

        btOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hiddenLinear.setVisibility(View.INVISIBLE);
                radioGroup.clearCheck();
                aSwitch.setChecked(false);
            }
        });

    }
}
