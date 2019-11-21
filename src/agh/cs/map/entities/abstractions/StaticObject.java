package agh.cs.map.entities.abstractions;

import agh.cs.math.Vector2d;
import agh.cs.map.World;

public abstract class StaticObject extends World.WorldObject {
    protected StaticObject(Vector2d initialPosition) {
        super(initialPosition);
    }
}
