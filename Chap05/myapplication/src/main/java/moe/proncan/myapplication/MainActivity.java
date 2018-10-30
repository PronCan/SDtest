package moe.proncan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNum1, etNum2;
    Button[] buttons = new Button[10];
    Integer[] buttonId = {R.id.buttonNum0, R.id.buttonNum1, R.id.buttonNum2, R.id.buttonNum3, R.id.buttonNum4
            , R.id.buttonNum5, R.id.buttonNum6, R.id.buttonNum7, R.id.buttonNum8, R.id.buttonNum9};
    Button add, sub, mul, div;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main2);

        etNum1 = findViewById(R.id.editText);
        etNum2 = findViewById(R.id.editText2);
        for (int i = 0; i < 10; i++) {
            buttons[i] = findViewById(buttonId[i]);
        }
        add = findViewById(R.id.button2);
        sub = findViewById(R.id.button3);
        mul = findViewById(R.id.button4);
        div = findViewById(R.id.button5);
        tvResult = findViewById(R.id.textView);

        for(int i=0; i<10; i++) {
            final int idx = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(etNum1.isFocused()) {
                        etNum1.setText(etNum1.getText().toString() + idx);
                    } else if(etNum2.isFocused()) {
                        etNum2.setText(etNum2.getText().toString() + idx);
                    }
                }
            });
        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = Integer.parseInt(etNum1.getText().toString()) + Integer.parseInt(etNum2.getText().toString());
                tvResult.setText(String.valueOf(res));
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = Integer.parseInt(etNum1.getText().toString()) - Integer.parseInt(etNum2.getText().toString());
                tvResult.setText(String.valueOf(res));
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = Integer.parseInt(etNum1.getText().toString()) * Integer.parseInt(etNum2.getText().toString());
                tvResult.setText(String.valueOf(res));
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = Integer.parseInt(etNum1.getText().toString()) / Integer.parseInt(etNum2.getText().toString());
                tvResult.setText(String.valueOf(res));
            }
        });
    }
}
