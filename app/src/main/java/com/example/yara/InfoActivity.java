package com.example.yara;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.parceler.Parcels;

public class InfoActivity extends AppCompatActivity {

    TextView mFirstNameTextView;
    TextView mLastNameTextView;
    TextView mEmailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        mFirstNameTextView = findViewById(R.id.first_name_textView);
        mLastNameTextView = findViewById(R.id.last_name_textView);
        mEmailTextView = findViewById(R.id.email_textView);

        User user = Parcels.unwrap(getIntent().getParcelableExtra("user"));
        mFirstNameTextView.setText(user.getFirstName());
        mLastNameTextView.setText(user.getLastName());
        mEmailTextView.setText(user.getEmail());
    }
}
