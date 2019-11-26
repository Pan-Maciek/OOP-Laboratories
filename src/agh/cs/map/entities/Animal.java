package agh.cs.map.entities;

import agh.cs.map.MapDirection;
import agh.cs.map.entities.abstractions.DynamicObject;
import agh.cs.math.Vector2d;

public class Animal extends DynamicObject {
    public Animal(Vector2d initialPosition, MapDirection initialDirection) {
        super(initialPosition, initialDirection);
    }

    public Animal(Vector2d vector2d) {
        super(vector2d, MapDirection.WEST);
    }
}
