package moe.proncan.myapp08_1;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;


public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    myPictureView myPictureView;
    int curNum;
    File[] imageFile;
    String imageName;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPrev = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);
        myPictureView = findViewById(R.id.myPictureView);
        textView = findViewById(R.id.textView);

        imageFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures").listFiles();
        imageName = imageFile[0].toString();
        myPictureView.imagePath = imageName;
        textView.setText("1/" + imageFile.length);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curNum <= 0) {
                    curNum = imageFile.length - 1;
                } else {
                    curNum--;
                }
                imageName = imageFile[curNum].toString();
                myPictureView.imagePath = imageName;
                myPictureView.invalidate();
                textView.setText((curNum + 1) + "/" + imageFile.length);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curNum >= imageFile.length - 1) {
                    curNum = 0;
                } else {
                    curNum++;
                }
                imageName = imageFile[curNum].toString();
                myPictureView.imagePath = imageName;
                myPictureView.invalidate();
                textView.setText((curNum + 1) + "/" + imageFile.length);
            }
        });
    }
}
