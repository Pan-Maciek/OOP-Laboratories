package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap map;

    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }

    @Override
    public String toString() {
        return position.toString() + " " + direction.arrow;
    }

    public void move(MoveDirection dir) {
        switch (dir) {
            case LEFT: direction = direction.previous(); break;
            case RIGHT: direction = direction.next(); break;
            case FORWARD:
            case BACKWARD:
                Vector2d tmp = dir == MoveDirection.FORWARD ? position.add(direction.unitVector) : position.subtract(direction.unitVector);
                if (map.canMoveTo(tmp))
                    position = tmp;
                break;
            default: throw new IllegalArgumentException("weź sie człowieku zastanów");
        }
    }

    public MapDirection getDirection() { return direction; }
    public Vector2d getPosition() { return position; }
}
