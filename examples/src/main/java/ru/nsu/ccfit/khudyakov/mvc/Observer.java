package ru.nsu.ccfit.khudyakov.mvc;

public interface Observer<C> {

    void update(C context);

}
