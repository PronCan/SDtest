package moe.proncan.myapp02;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    EditText editText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.button);
        btn.setEnabled(false);
        // 실행했을때 현재 날짜 저장된것 가져오기 

        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                btn.setEnabled(true);
                String fileName = datePicker.getYear() + "_" + (datePicker.getMonth() + 1) + "_" + datePicker.getDayOfMonth() + ".txt";
                try {
                    editText.setText("");
                    StringBuffer data = new StringBuffer();
                    FileInputStream fileInputStream = openFileInput(fileName);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    String str = bufferedReader.readLine();
                    // edittext 내용 없으면 '새로 저장'
                    btn.setText("새로 저장");
                    editText.setHint("일기 없음");
                    while(str != null) {
                        // 내용 있으면 '수정 하기'
                        btn.setText("수정 하기");
                        data.append(str + "\n");
                        str = bufferedReader.readLine();
                    }
                    bufferedReader.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                String fileName = datePicker.getYear() + "_" + (datePicker.getMonth() + 1) + "_" + datePicker.getDayOfMonth() + ".txt";
                try {
                    // 버튼 누르면 toast 년_월_일.txt로 저장됨
                    FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_APPEND);
                    PrintWriter out = new PrintWriter(fileOutputStream);
                    out.println(str);
                    out.close();
                    Toast.makeText(MainActivity.this, fileName + "으로 저장됨", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
