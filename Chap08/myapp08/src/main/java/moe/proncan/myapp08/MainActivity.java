package moe.proncan.myapp08;

import android.Manifest;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button btnPrev, btnNext;
    myPictureView myPictureView;
    int curNum = 0;
    File[] imageFile;
    String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPrev = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);
        myPictureView = findViewById(R.id.myPictureView);

        imageFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures").listFiles();
        imageName = imageFile[0].toString();
        myPictureView.imagePath = imageName;

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curNum <= 0) {
                    Toast.makeText(getApplicationContext(), "첫번째 그림", Toast.LENGTH_SHORT).show();
                } else {
                    curNum--;
                    imageName = imageFile[curNum].toString();
                    myPictureView.imagePath = imageName;
                    myPictureView.invalidate();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curNum >= imageFile.length-1) {
                    Toast.makeText(getApplicationContext(), "마지막 그림", Toast.LENGTH_SHORT).show();
                } else {
                    curNum++;
                    imageName = imageFile[curNum].toString();
                    myPictureView.imagePath = imageName;
                    myPictureView.invalidate();
                }
            }
        });
    }
}
