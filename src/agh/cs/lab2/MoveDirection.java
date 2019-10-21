package agh.cs.lab2;

import java.util.Optional;

public enum  MoveDirection {
    FORWARD, BACKWARD, RIGHT, LEFT;
    public static Optional<MoveDirection> parse(String s) {
        switch (s) {
            case "f": return Optional.of(FORWARD);
            case "b": return Optional.of(BACKWARD);
            case "r": return Optional.of(RIGHT);
            case "l": return Optional.of(LEFT);
            default:  return Optional.empty();
        }
    }
}
