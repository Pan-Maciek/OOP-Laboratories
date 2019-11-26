package agh.cs.map.entities.abstractions;

import agh.cs.map.MapDirection;
import agh.cs.map.World;
import agh.cs.math.Vector2d;

import java.awt.*;

public abstract class DynamicObject extends StaticObject implements IMovable {
    private MapDirection direction;

    protected DynamicObject(Vector2d initialPosition, MapDirection initialDirection) {
        super(initialPosition);
        direction = initialDirection;
    }

    @Override
    public void move(MoveDirection move) {
        switch (move) {
            case LEFT -> direction = direction.previous();
            case RIGHT -> direction = direction.next();
            case FORWARD, BACKWARD -> {
                var newPos = move == MoveDirection.FORWARD ? position.add(direction.unitVector) : position.subtract(direction.unitVector);
                setPosition(newPos);
            }
        }
    }
    private void setPosition(Vector2d newPosition) {
        this.position = newPosition;
        // todo notify all
    }
    public MapDirection getDirection() { return direction; }

    @Override
    public void place(World world) {
        super.place(world);
    }

    @Override
    protected void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillOval(0, 0, cellSize , cellSize);
        g.setColor(Color.black);
        var g2d = (Graphics2D) g;
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(g2d.getFont());
        var text = "" + direction.arrow;
        // Determine the X coordinate for the text
        int x = (cellSize - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = ((cellSize - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        // Draw the String
        g2d.drawString(text, x, y);
    }
}
