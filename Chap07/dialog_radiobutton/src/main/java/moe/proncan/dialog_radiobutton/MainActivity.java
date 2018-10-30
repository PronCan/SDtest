package moe.proncan.dialog_radiobutton;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    Button btn;
    ImageView imageView;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        btn = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbDog:
                        imageView.setImageResource(R.drawable.dog);
                        str = "개";
                        break;
                    case R.id.rbCat:
                        imageView.setImageResource(R.drawable.cat);
                        str = "고양이";
                        break;
                    case R.id.rbRabbit:
                        imageView.setImageResource(R.drawable.rabbit);
                        str = "토끼";
                        break;
                    case R.id.rbHorse:
                        imageView.setImageResource(R.drawable.icecream);
                        str = "말";
                        break;
                    default:
                        imageView.setImageResource(R.drawable.ic_launcher_foreground);
                        str = "이미지";
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(str);
                builder.setPositiveButton("닫기", null);
                builder.show();
            }
        });
    }
}
