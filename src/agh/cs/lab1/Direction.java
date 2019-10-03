package agh.cs.lab1;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    FORWARD, BACKWARD, RIGHT, LEFT;

    private  static Map<String, Direction> stringToDirection = new HashMap<String, Direction>(){{
        put("l", LEFT); put("r", RIGHT);
        put("f", FORWARD); put("b", BACKWARD);
    }};

    public static Direction parse(String direction) { return stringToDirection.getOrDefault(direction, null); }
}

