package com.example.daykm.jokesactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {

    public static final String KEY = "INTENT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        ((TextView) findViewById(R.id.joke)).setText(getIntent().getExtras().getString(KEY));
    }
}
