package com.mobiledevelopment.observerdemo.Models;

import android.os.Handler;

import com.mobiledevelopment.observerdemo.Interfaces.Observer;
import com.mobiledevelopment.observerdemo.Interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class Repo implements Subject {
    private String firstName, lastName;
    private List<Observer> observers;
    private static Repo instance;

    private Repo() {
        observers = new ArrayList();
        getData();
    }

    public static Repo getInstance() {
        if (instance == null) {
            instance = new Repo();
        }
        return instance;
    }

    private void getData() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                firstName = "Lazar";
                lastName = "Pešić";
                notifyAllObservers();
            }
        }, 3000);
    }

    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.updateData(firstName, lastName);
        }
    }
}
