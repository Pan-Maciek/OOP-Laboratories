package agh.cs.lab1;

import java.util.Optional;

public enum Direction {
    FORWARD, BACKWARD, RIGHT, LEFT;

    public static Optional<Direction> parse(String direction){
        switch (direction) {
            case "l": return Optional.of(LEFT);
            case "r": return Optional.of(RIGHT);
            case "f": return Optional.of(FORWARD);
            case "b": return Optional.of(BACKWARD);
            default: return Optional.empty();
        }
    }
}

