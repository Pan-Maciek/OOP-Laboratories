package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private static Vector2d upperBoundary = new Vector2d(0,0 );
    private static Vector2d lowerBoundary = new Vector2d(4,4 );

    @Override
    public String toString() {
        return position.toString() + " " + direction.toString();
    }

    public void move(MoveDirection dir) {
        switch (dir) {
            case LEFT: direction = direction.previous(); break;
            case RIGHT: direction = direction.next(); break;
            default:
                Vector2d tmp = dir == MoveDirection.FORWARD ? position.add(direction.unitVector) : position.subtract(direction.unitVector);
                if (tmp.follows(upperBoundary) && tmp.precedes(lowerBoundary))
                    position = tmp;
                break;
        }
    }
}
