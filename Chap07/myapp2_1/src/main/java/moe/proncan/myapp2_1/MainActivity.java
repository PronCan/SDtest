package moe.proncan.myapp2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText etRotate;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etRotate = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRotate:
                String rotation = etRotate.getText().toString();
                imageView.setRotation(Integer.parseInt(rotation));
                return true;
            case R.id.itemHan:
                imageView.setImageResource(R.drawable.jeju02);
                return true;
            case R.id.itemChu:
                imageView.setImageResource(R.drawable.jeju6);
                return true;
            case R.id.itemBeom:
                imageView.setImageResource(R.drawable.jeju14);
                return true;
            default:
                return true;
        }
    }
}
