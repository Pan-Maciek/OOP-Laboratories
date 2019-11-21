package agh.cs.map;

import agh.cs.math.Vector2d;
import agh.cs.map.entities.abstractions.ICollide;

import java.awt.*;
import java.util.SortedMap;

public abstract class World {

    public static abstract class WorldObject implements ICollide {
        protected Vector2d position;

        public WorldObject(Vector2d initialPosition) { position = initialPosition; }

        public void place(World world) {
            world.map.put(this.position, this);
        }

        public Vector2d getPosition() { return position; }

        void render(Graphics g) {
            g.fillRect(0,0,10,10);
        }
    }

    protected SortedMap<Vector2d, WorldObject> map;
    void place(WorldObject object) {
        object.place(this);
    }

}
