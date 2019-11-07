package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RectangularMap<List> implements IWorldMap {
    public final int width, height;
    private final Vector2d upperBoundary, lowerBoundary;
    private Map<Vector2d, Animal> animals = new HashMap<>();

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.upperBoundary = new Vector2d(0,0);
        this.lowerBoundary = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) { return position.follows(upperBoundary) && position.precedes(lowerBoundary) && !isOccupied(position); }

    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.getPosition())) return false;
        Vector2d position = animal.getPosition();
        animals.put(position, animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int len = animals.size(), i = 0;
        Object[] values = animals.values().toArray();
        for (MoveDirection d : directions) {
            var animal = (Animal) values[i++ % len];
            var prevPos = animal.getPosition();
            animal.move(d);
            if (!prevPos.equals(animal.getPosition())) {
                animals.remove(prevPos, animal);
                animals.put(animal.getPosition(), animal);
            }

            System.out.println("#" + i);
            System.out.println(this.toString());
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) { return animals.containsKey(position); }

    @Override
    public Object objectAt(Vector2d position) { return animals.getOrDefault(position, null); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                var position = new Vector2d(x, y);
                sb.append(animals.containsKey(position) ? animals.get(position).getDirection().arrow : '·');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
