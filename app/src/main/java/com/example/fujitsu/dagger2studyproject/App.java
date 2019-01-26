package com.example.fujitsu.dagger2studyproject;

import android.app.Application;

import com.example.fujitsu.dagger2studyproject.di.AppComponent;
import com.example.fujitsu.dagger2studyproject.di.DaggerAppComponent;

public class App extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.create();
    }

    public static AppComponent getComponent() {
        return component;
    }
}
