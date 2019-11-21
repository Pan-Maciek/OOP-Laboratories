package agh.cs.map.entities;

import agh.cs.map.MapDirection;
import agh.cs.math.Vector2d;
import agh.cs.map.entities.abstractions.DynamicObject;

public class Animal extends DynamicObject {
    public Animal(Vector2d initialPosition, MapDirection initialDirection) {
        super(initialPosition, initialDirection);
    }

}
