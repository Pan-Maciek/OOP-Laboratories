package agh.cs.lab7;

import agh.cs.lab2.Vector2d;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChange.Observer {
    private SortedSet<Integer> xPositions = new TreeSet<>();
    private SortedSet<Integer> yPositions = new TreeSet<>();


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        xPositions.remove(oldPosition.x);
        yPositions.remove(oldPosition.y);
        xPositions.add(newPosition.x);
        yPositions.add(newPosition.y);
    }

    @Override
    public void initialPosition(Vector2d position) {
        xPositions.add(position.x);
        yPositions.add(position.y);
    }

    public Vector2d getTopRight() {
        return new Vector2d(xPositions.last(), yPositions.last());
    }

    public Vector2d getBottomLeft() {
        return new Vector2d(xPositions.first(), yPositions.first());
    }

    public Vector2d getUpperLeft() {
        return new Vector2d(xPositions.first(), yPositions.last());
    }

    public Vector2d getLowerRight() {
        return new Vector2d(xPositions.last(), yPositions.first());
    }
}
