package agh.cs.lab1;

import java.util.Optional;

public enum Direction {
    FORWARD, BACKWARD, RIGHT, LEFT;

    public static Optional<Direction> parse(String direction){
        return switch (direction) {
            case "l" -> Optional.of(LEFT);
            case "r" -> Optional.of(RIGHT);
            case "f" -> Optional.of(FORWARD);
            case "b" -> Optional.of(BACKWARD);
            default -> Optional.empty();
        };
    }
}

