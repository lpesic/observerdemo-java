package com.mobiledevelopment.observerdemo.Interfaces;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyAllObservers();
}
