package com.example.yara;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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


        mEnterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(mFirstNameTextView.getText().toString(),
                        mLastNameTextView.getText().toString(),
                        mEmailTextView.getText().toString());
                Intent intent = new Intent(getActivity(), InfoActivity.class);
                intent.putExtra("F", user.getFirstName());
                intent.putExtra("L", user.getLastName());
                intent.putExtra("E", user.getEmail());

                startActivity(intent);
            }
        });

        Glide.with(this).load(yaraLogoUrl)
                .into(mYaraLogoImageView);

        return result;
    }

}
