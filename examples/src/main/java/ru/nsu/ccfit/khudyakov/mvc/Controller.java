package ru.nsu.ccfit.khudyakov.mvc;

public class Controller {

    private final SwingTrafficLight trafficLight;
    private final Model model;

    public Controller() {
        this.model = new Model();
        this.trafficLight = new SwingTrafficLight(this);
        this.model.addObserver(trafficLight);
    }

    public void update() {
        model.update();
    }

}
