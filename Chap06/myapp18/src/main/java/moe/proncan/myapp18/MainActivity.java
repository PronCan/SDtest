package moe.proncan.myapp18;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
//https://blog.naver.com/korea6174/221318439772
    ProcTabFragment tabFragment[] = new ProcTabFragment[4];
    ActionBar.Tab mTab[] = new ActionBar.Tab[4];
    Integer iconId[] = {R.drawable.icon_dog, R.drawable.icon_cat, R.drawable.icon_rabbit, R.drawable.icon_horse};
//    Integer imagesId[] = {R.drawable.dog, R.drawable.cat, R.drawable.rabbit, R.drawable.horse};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for (int i = 0; i < 4; i++) {
            mTab[i] = bar.newTab();
            mTab[i].setIcon(iconId[i]);
            mTab[i].setTabListener((ActionBar.TabListener) this);
            bar.addTab(mTab[i]);
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        ProcTabFragment myTab = null;
        int index = tab.getPosition();

        if (tabFragment[tab.getPosition()] == null) {
            myTab = new ProcTabFragment();
            Bundle data = new Bundle();
            data.putInt("iconId", iconId[index]);
            myTab.setArguments(data);
            tabFragment[index] = myTab;
        } else {
            myTab = tabFragment[index]; //포지션값을 넣음
        }
        ft.replace(android.R.id.content, myTab);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    public static class ProcTabFragment extends Fragment {
        int iconId;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            iconId = data.getInt("iconId");
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View myView = inflater.inflate(R.layout.activity_main, null);
            ImageView imageView = myView.findViewById(R.id.imageView);
            if(iconId == R.drawable.icon_dog) {
                imageView.setImageResource(R.drawable.dog);
            }
            if(iconId == R.drawable.icon_cat) {
                imageView.setImageResource(R.drawable.cat);
            }
            if(iconId == R.drawable.icon_rabbit) {
                imageView.setImageResource(R.drawable.rabbit);
            }
            if(iconId == R.drawable.icon_horse) {
                imageView.setImageResource(R.drawable.horse);
            }
            return myView;
        }
    }
}
