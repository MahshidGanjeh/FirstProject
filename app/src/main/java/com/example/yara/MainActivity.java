package com.example.yara;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private NavigationView mDrawerNavigationView;
    private DrawerLayout drawer;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting the alignment to right
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        mDrawerNavigationView = findViewById(R.id.drawer_navigation_view);
        drawer = findViewById(R.id.main_container);

        //initialize the activity
        CategoryFragment home = new CategoryFragment();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, home).commit();

        mDrawerNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_contactus:
                        ContactFragment contact = new ContactFragment();
                        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.fragment_container, contact).commit();
                        drawer.closeDrawers();
                        return true;
                    case R.id.drawer_aboutous:
                        AboutFragment about = new AboutFragment();
                        android.support.v4.app.FragmentManager fragmentManager1 = getSupportFragmentManager();
                        fragmentManager1.beginTransaction().replace(R.id.fragment_container, about).commit();
                        drawer.closeDrawers();
                        return true;
                }
                return false;
            }
        });
    }
}
