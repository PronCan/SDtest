package moe.proncan.exercise2_7;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btn1, btn2;
    RadioGroup radioGroup;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_background);

        setTitle("아아아");

        editText = findViewById(R.id.editText);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        radioGroup = findViewById(R.id.radio_group);
        imageView = findViewById(R.id.imageView);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
            }
        });

        if(!(editText.getText().toString().length() == 0)) {
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String str = editText.getText().toString();
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                    startActivity(intent);
                }
            });
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.nugat) {
                    imageView.setImageResource(R.drawable.nougat);
                } else if(checkedId == R.id.oreo) {
                    imageView.setImageResource(R.drawable.oreo);
                }
            }
        });

    }
}
