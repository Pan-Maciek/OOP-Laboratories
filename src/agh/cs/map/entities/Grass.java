package agh.cs.map.entities;

import agh.cs.map.entities.abstractions.StaticObject;
import agh.cs.math.Vector2d;

import java.awt.*;

public class Grass extends StaticObject {
    public Grass(Vector2d initialPosition) {
        super(initialPosition);
    }

    @Override
    protected void render(Graphics g) {
        g.setColor(Color.green);
        super.render(g);
    }
}
