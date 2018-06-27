package com.example.nesterkin.asynctaskexample;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Nesterkin Alexander on 26.06.2018
 */

public class MyLoader extends AsyncTaskLoader<Integer> {

    MyLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public Integer loadInBackground() {
        Random random = new Random();
        int color = 0;
        while (color != Integer.MAX_VALUE) {
            color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            deliverResult(color);
        }

        return color;
    }
}