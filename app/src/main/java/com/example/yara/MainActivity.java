package com.example.yara;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView mBottomNavigationView;
    NavigationView mDrawerNavigationView;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        mDrawerNavigationView = findViewById(R.id.drawer_navigation_view);
        drawer = findViewById(R.id.container);


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
                        return true;
                }
                return false;
            }
        });
        mBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.bottom_navigation_home:
                                RegisterFragment registerFragment = new RegisterFragment();
                                android.support.v4.app.FragmentManager fragmentManager2 = getSupportFragmentManager();
                                fragmentManager2.beginTransaction().replace(R.id.fragment_container, registerFragment).commit();
                                return true;
                            case R.id.bottom_navigation_category:
                                CategoryFragment categoryFragment = new CategoryFragment();
                                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                                fragmentManager.beginTransaction().replace(R.id.fragment_container, categoryFragment).commit();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
