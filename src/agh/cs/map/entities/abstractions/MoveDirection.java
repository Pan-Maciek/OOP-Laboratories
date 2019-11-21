package agh.cs.map.entities.abstractions;

public enum  MoveDirection {
    FORWARD, BACKWARD, RIGHT, LEFT;
    public static MoveDirection parse(String s) throws IllegalArgumentException {
        return switch (s) {
            case "f" -> FORWARD;
            case "b" -> BACKWARD;
            case "r" -> RIGHT;
            case "l" -> LEFT;
            default -> throw new IllegalArgumentException(s + "is not legal move specification");
        };
    }
}
