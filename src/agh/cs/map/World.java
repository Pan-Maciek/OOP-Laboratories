package agh.cs.map;

import agh.cs.map.entities.abstractions.ICollide;
import agh.cs.math.Vector2d;

import java.awt.*;
import java.util.SortedMap;
import java.util.TreeMap;

public class World {

    public static abstract class WorldObject implements ICollide {
        protected Vector2d position;
        public static final int cellSize = 40;

        public WorldObject(Vector2d initialPosition) { position = initialPosition; }

        protected abstract void render(Graphics g);

        public void place(World world) {
            world.map.put(this.position, this);
        }

        public Vector2d getPosition() { return position; }
    }

    protected SortedMap<Vector2d, WorldObject> map = new TreeMap<>();
    public void place(WorldObject object) {
        object.place(this);
    }

}
