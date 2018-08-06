package com.example.yara;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yara.Retrofit.RetrofitActivity;

import org.parceler.Parcel;
import org.parceler.Parcels;

public class RegisterFragment extends Fragment {

    final String yaraLogoUrl = "http://yaramobile.com/templates/sj_hexagon/images/styling/blue/logo.png";
    ImageView mYaraLogoImageView;
    TextView mFirstNameTextView;
    TextView mLastNameTextView;
    TextView mEmailTextView;
    Button mEnterBtn;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_register, container, false);
        mYaraLogoImageView = result.findViewById(R.id.yara_logo_imageView);
        mFirstNameTextView = result.findViewById(R.id.name_editText);
        mLastNameTextView = result.findViewById(R.id.lastname_editText);
        mEmailTextView = result.findViewById(R.id.email_editText);
        mEnterBtn = result.findViewById(R.id.enter_btn);

        Glide.with(this).load(yaraLogoUrl)
                .into(mYaraLogoImageView);

        mEnterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(mFirstNameTextView.getText().toString(),
                        mLastNameTextView.getText().toString(),
                        mEmailTextView.getText().toString());
                Intent intent = new Intent(getActivity(), InfoActivity.class);
                intent.putExtra("user", Parcels.wrap(user));
                startActivity(intent);
            }
        });
        return result;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BottomNavigationView mBottomNavigationView = view.findViewById(R.id.bottom_navigation);

        mBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.bottom_navigation_home:
                                RegisterFragment registerFragment = new RegisterFragment();
                                android.support.v4.app.FragmentManager fragmentManager2 = getFragmentManager();
                                fragmentManager2.beginTransaction().replace(R.id.fragment_container, registerFragment).commit();
                                return true;
                            case R.id.bottom_navigation_category:
                                CategoryFragment categoryFragment = new CategoryFragment();
                                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                                fragmentManager.beginTransaction().replace(R.id.fragment_container, categoryFragment).commit();
                                return true;
                            case R.id.bottom_navigation_users:
                                startActivity(new Intent(getContext(), RetrofitActivity.class));
                                return true;
                            default:
                                return false;
                        }
                    }
                });

    }
}
