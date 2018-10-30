package moe.proncan.project4_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    EditText etNum1, etNum2;
    Button btAdd, btSub, btMul, btDiv;
    TextView tvResult;

    String num1, num2;
    int res = 0;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        num1 = etNum1.getText().toString();
        num2 = etNum2.getText().toString();
        switch(v.getId()) {
            case R.id.button :
                res = Integer.parseInt(num1) + Integer.parseInt(num2);
                tvResult.setText("결과 : " + res);
                break;
            case R.id.button2 :
                if(Integer.parseInt(num1) >= Integer.parseInt(num2) ) {
                    res = Integer.parseInt(num1) - Integer.parseInt(num2);
                } else {
                    String temp = num1;
                    num1 = num2;
                    num2 = temp;
                    res = Integer.parseInt(num1) - Integer.parseInt(num2);
                }
                tvResult.setText(res);
                break;
            case R.id.button3 :
                res = Integer.parseInt(num1) * Integer.parseInt(num2);
                tvResult.setText(res);
                break;
            case R.id.button4 :
                if(Integer.parseInt(num2) != 0 ) {
                    res = Integer.parseInt(num1) / Integer.parseInt(num2);
                } else {
                    res = Integer.parseInt(num1);
                }
                tvResult.setText(res);
                break;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.editText);
        etNum2 = findViewById(R.id.editText2);
        btAdd = findViewById(R.id.button);
        btSub = findViewById(R.id.button2);
        btMul= findViewById(R.id.button3);
        btDiv = findViewById(R.id.button4);
        tvResult = findViewById(R.id.textView);

    }
}
