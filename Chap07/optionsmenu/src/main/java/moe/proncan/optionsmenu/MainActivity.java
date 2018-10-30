package moe.proncan.optionsmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "강아지");
        menu.add(0, 2, 0, "고양이");
        menu.add(0, 3, 0, "토끼");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                imageView.setImageResource(R.drawable.dog);
                return true;
            case 2:
                imageView.setImageResource(R.drawable.cat);
                return true;
            case 3:
                imageView.setImageResource(R.drawable.rabbit);
                return true;
            default:
                return false;
        }
    }
}
