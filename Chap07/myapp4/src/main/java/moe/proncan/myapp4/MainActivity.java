package moe.proncan.myapp4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("배경색 바꾸기(컨텍스트 메뉴)");
        linearLayout = findViewById(R.id.linearLayout);
        btn1 = findViewById(R.id.button);
        registerForContextMenu(btn1);
        btn2 = findViewById(R.id.button2);
        registerForContextMenu(btn2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();

        if (v == btn1) {
            menu.setHeaderTitle("배경색 변경");
            menuInflater.inflate(R.menu.menu1, menu);
        }
        if (v == btn2) {
            menuInflater.inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRed:
                linearLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                linearLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                linearLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.itemRotate:
                btn2.setRotation(45);
                return true;
            case R.id.itemScale:
                btn2.setScaleX(2);
                return true;
            default:
                return false;
        }
    }
}
