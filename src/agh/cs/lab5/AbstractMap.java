package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMap implements IWorldMap {
    protected final Map<Vector2d, AbstractMapElement> map;
    protected final List<Animal> animals;
    protected final MapVisualizer mapVisualizer;
    protected Vector2d topRight, bottomLeft;

    public AbstractMap() {
        this.map = new HashMap<>();
        this.animals = new ArrayList<>();
        this.mapVisualizer = new MapVisualizer(this);
        topRight = new Vector2d(5, 5);
        bottomLeft = new Vector2d(0, 0);
    }

    private void updateBounds(Vector2d pos) {
        topRight = topRight.lowerRight(pos);
        bottomLeft = bottomLeft.upperLeft(pos);
    }

    @Override
    public boolean place(AbstractMapElement element) {
        var pos = element.getPosition();
        if (element instanceof Animal) {
            if (canMoveTo(pos)) {
                animals.add((Animal) element);
                map.put(pos, element);
                updateBounds(pos);
                return true;
            } else throw new IllegalArgumentException("trying to place object at: " + pos + ". Position already occupied.");
        }
        if (isOccupied(pos))
            throw new IllegalArgumentException("trying to place object at: " + pos + ". Position already occupied.");
        map.put(pos, element);
        updateBounds(pos);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        for (int size = animals.size(), i = 0; i < directions.length; i++) {
            var animal = animals.get(i % size);
            var prevPos = animal.getPosition();
            animal.move(directions[i]);

            var currentPos = animal.getPosition();
            if (!prevPos.equals(currentPos)) {
                map.remove(prevPos);
                map.put(currentPos, animal);
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) { return map.containsKey(position); }

    @Override
    public AbstractMapElement objectAt(Vector2d position) { return map.get(position); }

    @Override
    public boolean canMoveTo(Vector2d position) { return !isOccupied(position) || (objectAt(position) instanceof Grass); }

    @Override
    public String toString() {
        return mapVisualizer.draw(bottomLeft, topRight);
    }
}
