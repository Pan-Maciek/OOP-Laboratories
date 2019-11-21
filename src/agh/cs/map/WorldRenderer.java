package agh.cs.map;

import java.awt.*;

public class WorldRenderer {
    int width, height;
    private final World world;
    public WorldRenderer(World world) {
        this.world = world;
    }

    public void render(Graphics g) {
        for (var val : world.map.values()) {
            render(g, val);
        }
    }

    public void render(Graphics g, World.WorldObject object) {
        g.translate(object.position.x, object.position.y);
        object.render(g);
    }
}
