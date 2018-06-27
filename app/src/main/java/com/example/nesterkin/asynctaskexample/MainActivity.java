package com.example.nesterkin.asynctaskexample;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.first_frame_layout, FirstFragment.newInstance())
                .add(R.id.second_frame_layout, SecondFragment.newInstance())
                .add(R.id.third_frame_layout, ThirdFragment.newInstance())
                .commit();
    }
}