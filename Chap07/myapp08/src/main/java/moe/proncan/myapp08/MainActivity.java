package moe.proncan.myapp08;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn1 = findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] versionArr = new String[]{"마시멜로", "누가", "오레오"};
                final boolean[] checkArr = new boolean[]{true, false, false};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("좋아하는 버전");
                builder.setIcon(R.mipmap.ic_launcher);
//                builder.setItems(versionArr, new DialogInterface.OnClickListener() {
                builder.setMultiChoiceItems(versionArr, checkArr, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        btn1.setText(versionArr[which]);
                    }
                });
                builder.setPositiveButton("닫기", null);
                builder.show();
            }
        });
    }
}
