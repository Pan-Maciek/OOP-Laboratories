package agh.cs.map.entities.abstractions;

public interface IMovable extends ICollide {
    void move(MoveDirection direction);
}
