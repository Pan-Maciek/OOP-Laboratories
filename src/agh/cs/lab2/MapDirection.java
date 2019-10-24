package agh.cs.lab2;

public enum MapDirection {
    NORTH("Północ", '↑', new Vector2d(0, 1)),
    EAST("Wschód", '→',  new Vector2d(1, 0)),
    SOUTH("Południe", '↓', new Vector2d(0, -1)),
    WEST("Zachód", '←', new Vector2d(-1, 0));
    public final String name;
    public final char arrow;
    public final Vector2d unitVector;
    MapDirection(String name, char arrow, Vector2d unitVector) {
        this.name = name;
        this.unitVector = unitVector;
        this.arrow = arrow;
    }

    @Override
    public String toString() { return this.name; }

    public MapDirection next() { return MapDirection.values() [(ordinal() + 1) % 4]; }
    public MapDirection previous() { return MapDirection.values()[(ordinal() + 3) % 4]; }
    public Vector2d toUnitVector() { return this.unitVector; }
}
