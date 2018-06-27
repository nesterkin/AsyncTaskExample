package com.example.nesterkin.asynctaskexample;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Nesterkin Alexander on 27.06.2018
 */
public class MyLoader2 extends AsyncTaskLoader<List<Integer>> {

    MyLoader2(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public List<Integer> loadInBackground() {
        List<Integer> colorList = new ArrayList<>();
        int color;
        Random random = new Random();

        while (colorList.size() != 1_000_000) {
            color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
            colorList.add(color);
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return colorList;
    }
}