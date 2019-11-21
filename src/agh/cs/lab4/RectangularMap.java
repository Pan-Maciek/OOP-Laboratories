package agh.cs.lab4;

import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab5.AbstractMap;
import agh.cs.lab5.AbstractMapElement;

public class RectangularMap extends AbstractMap {
    private final Vector2d upperBoundary, lowerBoundary;

    public RectangularMap(int width, int height) {
        super();
        this.lowerBoundary = new Vector2d(0,0);
        this.upperBoundary = new Vector2d(width, height);
    }

    public void place(Animal animal) {
        if (!checkBounds(animal.getPosition())) throw new IllegalArgumentException("Trying to place element outside the boundary");
        super.place(animal);
    }

    @Override
    public void place(AbstractMapElement element) {
        if (!checkBounds(element.getPosition())) throw new IllegalArgumentException("Trying to place element outside the boundary");
        super.place(element);
    }

    private boolean checkBounds(Vector2d position) {
        return position.follows(lowerBoundary) && position.precedes(upperBoundary);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return checkBounds(position) && super.canMoveTo(position);
    }

    @Override
    public String toString() { return super.mapVisualizer.draw(lowerBoundary, upperBoundary); }
}
