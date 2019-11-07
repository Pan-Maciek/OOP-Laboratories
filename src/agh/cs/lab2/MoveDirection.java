package agh.cs.lab2;

import java.util.Optional;

public enum  MoveDirection {
    FORWARD, BACKWARD, RIGHT, LEFT;
    public static Optional<MoveDirection> parse(String s) {
        return switch (s) {
            case "f" -> Optional.of(FORWARD);
            case "b" -> Optional.of(BACKWARD);
            case "r" -> Optional.of(RIGHT);
            case "l" -> Optional.of(LEFT);
            default -> Optional.empty();
        };
    }
}
