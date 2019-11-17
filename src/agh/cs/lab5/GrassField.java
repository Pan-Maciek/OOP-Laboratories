package agh.cs.lab5;

import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;

import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractMap {

    private static final Random random = new Random();

    public GrassField(int n) {
        super();
        addGrass(n);
    }

    public void addGrass(int count) {
        int max = (int) sqrt(count * 10);
        for (int i = 0; i < count; i++) {
            var succeeded = false;
            do {
                var position = new Vector2d(random.nextInt(max), random.nextInt(max));
                try {
                    succeeded = place(new Grass(position));
                } catch (IllegalArgumentException e) {
                    succeeded = false;
                }
            } while(!succeeded);
        }
    }
}
