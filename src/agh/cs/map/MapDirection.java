package agh.cs.map;

import agh.cs.math.Vector2d;

public enum MapDirection {
    NORTH('↑', new Vector2d(0, 1)),
    EAST('→',  new Vector2d(1, 0)),
    SOUTH('↓', new Vector2d(0, -1)),
    WEST('←', new Vector2d(-1, 0));

    public final char arrow;
    public final Vector2d unitVector;

    MapDirection(char arrow, Vector2d unitVector) {
        this.unitVector = unitVector;
        this.arrow = arrow;
    }

    public MapDirection next() { return MapDirection.values() [(ordinal() + 1) % 4]; }
    public MapDirection previous() { return MapDirection.values()[(ordinal() + 3) % 4]; }
}
