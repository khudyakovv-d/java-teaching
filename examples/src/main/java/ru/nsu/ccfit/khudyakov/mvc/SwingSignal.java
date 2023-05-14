package ru.nsu.ccfit.khudyakov.mvc;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class SwingSignal extends JPanel implements AbstractSignal {

    private final int size;
    private final Color initColor;
    private Color curColor;

    public SwingSignal(int size, Color initColor) {
        this.size = size;
        this.initColor = initColor;
        this.curColor = Color.BLACK;
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(curColor);
        graphics.fillOval(0, 0, size, size);
        graphics.setColor(Color.BLACK);
        graphics.drawOval(0, 0, size, size);
    }

    @Override
    public void off() {
        curColor = Color.BLACK;
        repaint();
    }

    @Override
    public void on() {
        curColor = initColor;
        repaint();
    }

}
