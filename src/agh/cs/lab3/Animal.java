package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab7.IPositionChange;

public class Animal extends IPositionChange.EventEmitter {
    private MapDirection direction = MapDirection.NORTH;
    private IWorldMap map;

    public Animal(IWorldMap map) { this(map, new Vector2d(2,2)); }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        super(initialPosition);
        this.map = map;
    }

    @Override
    public String toString() { return Character.toString(direction.arrow); }

    public void move(MoveDirection dir) {
        switch (dir) {
            case LEFT -> direction = direction.previous();
            case RIGHT -> direction = direction.next();
            case FORWARD, BACKWARD -> {
                var newPos = dir == MoveDirection.FORWARD ? position.add(direction.unitVector) : position.subtract(direction.unitVector);
                if (map.canMoveTo(newPos)) setPosition(newPos);
            }
            default -> throw new IllegalArgumentException("Invalid MoveDirection value passed to move().");
        }
    }

    public MapDirection getDirection() { return direction; }
    public Vector2d getPosition() { return position; }
}
