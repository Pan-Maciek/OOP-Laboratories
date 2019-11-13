package agh.cs.lab5;

import agh.cs.lab2.Vector2d;

public abstract class AbstractMapElement {
    protected Vector2d position;

    public AbstractMapElement(Vector2d position) {
        this.position = position;
    }

    public Vector2d getPosition() { return position; }
}
