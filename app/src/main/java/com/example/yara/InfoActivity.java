package com.example.yara;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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

        mFirstNameTextView.setText(getIntent().getExtras().get("F").toString());
        mLastNameTextView.setText(getIntent().getExtras().get("L").toString());
        mEmailTextView.setText(getIntent().getExtras().get("E").toString());
    }
}
