package agh.cs.map.entities.abstractions;

import agh.cs.map.MapDirection;
import agh.cs.math.Vector2d;
import agh.cs.map.World;

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
}
