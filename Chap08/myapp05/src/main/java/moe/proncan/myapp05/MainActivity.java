package moe.proncan.myapp05;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        Button btnRead;
        final EditText editText;

        btnRead = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fileInputStream = new FileInputStream("/sdcard/sd_text.txt");
                    byte[] text = new byte[fileInputStream.available()];
//                    fileInputStream.read(text);
                    editText.setText(new String(text));
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
