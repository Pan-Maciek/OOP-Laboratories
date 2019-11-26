package agh.cs.map.entities.abstractions;

import agh.cs.map.World;
import agh.cs.math.Vector2d;

import java.awt.*;

public abstract class StaticObject extends World.WorldObject {
    protected StaticObject(Vector2d initialPosition) {
        super(initialPosition);
    }

    @Override
    protected void render(Graphics g) {
        g.fillRect(0,0, cellSize, cellSize);
    }
}
