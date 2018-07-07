package com.mobiledevelopment.observerdemo.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mobiledevelopment.observerdemo.Interfaces.Observer;
import com.mobiledevelopment.observerdemo.R;
import com.mobiledevelopment.observerdemo.Models.Repo;
import com.mobiledevelopment.observerdemo.Interfaces.Subject;
import com.mobiledevelopment.observerdemo.Utils.ApplicationData;

public class MainActivity extends AppCompatActivity implements Observer {
    private Subject subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        subject = Repo.getInstance();
        subject.addObserver(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subject.removeObserver(this);
    }

    @Override
    public void updateData(String firstName, String lastName) {
        Log.d(ApplicationData.TAG, "Name: " + firstName + " " + lastName + "from MainActivity");
    }
}
