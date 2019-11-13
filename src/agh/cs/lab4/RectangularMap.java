package agh.cs.lab4;

import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab5.AbstractMap;
import agh.cs.lab5.AbstractMapElement;
import agh.cs.lab5.Grass;

public class RectangularMap<List> extends AbstractMap {
    private final Vector2d upperBoundary, lowerBoundary;

    public RectangularMap(int width, int height) {
        super();
        this.lowerBoundary = new Vector2d(0,0);
        this.upperBoundary = new Vector2d(width, height);
    }

    @Override
    public boolean place(AbstractMapElement element) {
        var pos = element.getPosition();
        if (element instanceof Animal && canMoveTo(pos)) return super.place(element);
        if (!checkBounds(pos) || isOccupied(pos)) return false;
        return super.place(element);
    }

    private boolean checkBounds(Vector2d position) {
        return position.follows(lowerBoundary) && position.precedes(upperBoundary);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return checkBounds(position) && (!isOccupied(position) || (objectAt(position) instanceof Grass));
    }

    @Override
    public String toString() { return super.mapVisualizer.draw(lowerBoundary, upperBoundary); }
}
