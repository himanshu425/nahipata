package com.tcs.androidproject;

import android.app.Application;

/**
 * Created by 1012711 on 6/27/2016.
 */
public class TravleAppContext extends Application {

    public static TravleAppContext context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static TravleAppContext getContext() {
        return context;
    }
}
