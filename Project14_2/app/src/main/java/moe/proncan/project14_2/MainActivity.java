package moe.proncan.project14_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etNum1, etNum2;
    Button btAdd, btSub, btMul, btDiv, btMin;
    TextView tvResult;

    Double num1, num2;
    String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.editText);
        etNum2 = findViewById(R.id.editText2);
        btAdd = findViewById(R.id.button);
        btSub = findViewById(R.id.button2);
        btMul = findViewById(R.id.button3);
        btDiv = findViewById(R.id.button4);
        btMin = findViewById(R.id.button5);
        tvResult = findViewById(R.id.textView);

        btAdd.setOnClickListener(mListener);
        btSub.setOnClickListener(mListener);
        btMul.setOnClickListener(mListener);
        btDiv.setOnClickListener(mListener);
        btMin.setOnClickListener(mListener);
    }

    Button.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(etNum1.getText().toString().trim().length() <= 0 || etNum2.getText().toString().trim().length() <= 0) {
                Toast.makeText(getApplicationContext(), "값을 입력하세요", Toast.LENGTH_SHORT).show();
            } else {
                num1 = Double.parseDouble(etNum1.getText().toString().trim());
                num2 = Double.parseDouble(etNum2.getText().toString().trim());
                switch (v.getId()) {
                    case R.id.button:
                        res = Double.toString(num1 + num2);
                        tvResult.setText(res);
                        break;
                    case R.id.button2:
                        res = Double.toString(num1 - num2);
                        tvResult.setText(res);
                        break;
                    case R.id.button3:
                        res = Double.toString(num1 * num2);
                        tvResult.setText(res);
                        break;
                    case R.id.button4:
                        if (num2 == 0) {
                            Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_LONG).show();
                            break;
                        }
                        res = Double.toString(num1 / num2);
                        tvResult.setText(res);
                        break;
                    case R.id.button5 :
                        res = Double.toString(num1 % num2);
                        tvResult.setText(res);
                        break;
                }
            }
        }
    };
}
