package moe.proncan.myapp04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRead;
        final EditText etRaw;

        btnRead = findViewById(R.id.button);
        etRaw = findViewById(R.id.editText);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream inputStream = getResources().openRawResource(R.raw.rw_text);
                    byte[] text = new byte[inputStream.available()];
                    etRaw.setText(new String(text));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
