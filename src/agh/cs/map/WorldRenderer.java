package agh.cs.map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class WorldRenderer extends JPanel implements MouseMotionListener, MouseListener {
    int width, height;
    private final World world;
    private static final int cellSize = World.WorldObject.cellSize;
    private int offsetX;
    private int offsetY;

    public WorldRenderer(World world) {
        this.world = world;
    }

    public void render(Graphics g, World.WorldObject object) {
        g.translate(object.position.x * cellSize, object.position.y * cellSize);
        object.render(g);
        g.translate(-object.position.x * cellSize, object.position.y * cellSize);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.translate(offsetX, offsetY);
        for (var val : world.map.values()) {
            render(g, val);
        }
        g.translate(-offsetX, -offsetY);
    }

    private int prevX, prevY;
    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        int dx = mouseEvent.getX() - prevX;
        int dy = mouseEvent.getY() - prevY;
        prevX = mouseEvent.getX();
        prevY = mouseEvent.getY();
        offsetX += dx;
        offsetY += dy;
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        prevX = mouseEvent.getX();
        prevY = mouseEvent.getY();
    }

    public void mouseMoved(MouseEvent mouseEvent) { }
    public void mouseReleased(MouseEvent mouseEvent) { }
    public void mouseEntered(MouseEvent mouseEvent) { }
    public void mouseExited(MouseEvent mouseEvent) { }
    public void mouseClicked(MouseEvent mouseEvent) { }
}
