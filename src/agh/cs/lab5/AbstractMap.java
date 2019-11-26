package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;
import agh.cs.lab7.IPositionChange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMap implements IWorldMap, IPositionChange.Observer {
    protected final Map<Vector2d, AbstractMapElement> map;
    private final List<Animal> animals;
    protected final MapVisualizer mapVisualizer;

    public AbstractMap() {
        this.map = new HashMap<>();
        this.animals = new ArrayList<>();
        this.mapVisualizer = new MapVisualizer(this);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        var obj = this.objectAt(oldPosition);
        map.remove(oldPosition);
        map.put(newPosition, obj);
    }

    @Override
    public void initialPosition(Vector2d position) { }

    public void place(Animal animal) throws IllegalArgumentException {
        var pos = animal.getPosition();
        if (canMoveTo(pos)) {
            animals.add(animal);
            map.put(pos, animal);
            animal.subscribe(this);
        } else throw new IllegalArgumentException("trying to place object at: " + pos + ". Position already occupied.");
    }

    @Override
    public void place(AbstractMapElement element) throws IllegalArgumentException {
        var pos = element.getPosition();
        if (isOccupied(pos)) throw new IllegalArgumentException("trying to place object at: " + pos + ". Position already occupied.");
        map.put(pos, element);
    }

    @Override
    public void run(MoveDirection[] directions) {
        for (int size = animals.size(), i = 0; i < directions.length; i++) {
            var animal = animals.get(i % size);
            animal.move(directions[i]);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) { return map.containsKey(position); }

    @Override
    public AbstractMapElement objectAt(Vector2d position) { return map.get(position); }

    @Override
    public boolean canMoveTo(Vector2d position) { return !isOccupied(position) || (objectAt(position) instanceof Grass); }
}
