package moe.proncan.myapp8_self;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout, params);

        final EditText editText = new EditText(this);
        editText.setHint("입력");
        baseLayout.addView(editText);

        Button btn = new Button(this);
        btn.setText("버튼");
        btn.setBackgroundColor(Color.MAGENTA);
        baseLayout.addView(btn);

        final TextView textView = new TextView(this);
        textView.setTextColor(Color.MAGENTA);
        textView.setTextSize(24);
        baseLayout.addView(textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                textView.setText(str);
            }
        });
    }
}
