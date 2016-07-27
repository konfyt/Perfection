package com.konfyt.perfection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home_two_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_two_);
    }

    public void finish(View view) {
        finish();
    }
}
