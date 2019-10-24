package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;

import java.util.ArrayList;

public class RectangularMap<List> implements IWorldMap {
    public final int width, height;
    private final Vector2d upperBoundary, lowerBoundary;
    private Animal[][] mapData;
    private ArrayList<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.upperBoundary = new Vector2d(0,0);
        this.lowerBoundary = new Vector2d(width, height);
        mapData = new Animal[height+1][width+1];
    }

    @Override
    public boolean canMoveTo(Vector2d position) { return position.follows(upperBoundary) && position.precedes(lowerBoundary) && !isOccupied(position); }

    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.getPosition())) return false;
        Vector2d position = animal.getPosition();
        mapData[position.y][position.x] = animal;
        animals.add(animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int len = animals.size(), i = 0;
        for (MoveDirection d : directions) {
            animals.get(i % len).move(d);
            i++;
            System.out.println("#" + i);
            System.out.println(this.toString());
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) { return mapData[position.y][position.x] != null; }

    @Override
    public Object objectAt(Vector2d position) { return mapData[position.y][position.x]; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++)
                sb.append(mapData[y][x] != null ? mapData[y][x].getDirection().arrow : '·');
            sb.append('\n');
        }
        return sb.toString();
    }
}
