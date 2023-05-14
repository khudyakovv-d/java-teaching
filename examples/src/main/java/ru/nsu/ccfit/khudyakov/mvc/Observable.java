package ru.nsu.ccfit.khudyakov.mvc;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable<C> {

    private final List<Observer<C>> observers = new ArrayList<>();

    public void addObserver(Observer<C> observer) {
        observers.add(observer);
    }

    public void notify(C context) {
        observers.forEach(o -> o.update(context));
    }

}
