package agh.cs.lab5;

import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab7.MapBoundary;

import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractMap {

    private static final Random random = new Random();
    private MapBoundary mapBoundary;

    public GrassField(int n) {
        super();
        mapBoundary = new MapBoundary();
        addGrass(n);
    }

    private void addGrass(int count) {
        int max = (int) sqrt(count * 10);
        for (int i = 0; i < count; i++) {
            var succeeded = false;
            do {
                var position = new Vector2d(random.nextInt(max), random.nextInt(max));
                try {
                    place(new Grass(position));
                    succeeded = true;
                } catch (IllegalArgumentException e) {
                    succeeded = false;
                }
            } while(!succeeded);
        }
    }

    @Override
    public void place(Animal animal) throws IllegalArgumentException {
        animal.subscribe(mapBoundary);
        super.place(animal);
    }

    @Override
    public String toString() {
        return mapVisualizer.draw(mapBoundary.getUpperLeft(), mapBoundary.getLowerRight());
    }
}
