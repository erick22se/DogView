package com.upc.dogview.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.upc.dogview.Fragments.FavoritesFragment;
import com.upc.dogview.Fragments.HomeFragment;
import com.upc.dogview.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
           return navigateTo(item);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigateTo(navigation.getMenu().findItem(R.id.navigation_home));
    }

    private Fragment getFragmentFor(MenuItem item){
        switch (item.getItemId()) {
            case R.id.navigation_home:return new HomeFragment();
            case R.id.navigation_favorites:return new FavoritesFragment();
            default: return new HomeFragment();
        }
    }

    private boolean navigateTo(MenuItem item){
        item.setChecked(true);
        return getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content,getFragmentFor(item))
                .commit() > 0;
    }
}
