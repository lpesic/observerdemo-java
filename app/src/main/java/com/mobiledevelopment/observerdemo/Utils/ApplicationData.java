package com.mobiledevelopment.observerdemo.Utils;

import android.app.Application;
import android.util.Log;

import com.mobiledevelopment.observerdemo.Interfaces.Observer;
import com.mobiledevelopment.observerdemo.Models.Repo;
import com.mobiledevelopment.observerdemo.Interfaces.Subject;

public class ApplicationData extends Application implements Observer {
    public static final String TAG = "observer_demo";

    private Subject subject;

    @Override
    public void onCreate() {
        super.onCreate();
        subject = Repo.getInstance();
        subject.addObserver(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        subject.removeObserver(this);
    }

    @Override
    public void updateData(String firstName, String lastName) {
        Log.d(TAG, "Name: " + firstName + " " + lastName + " from ApplicationData");
    }
}
