package agh.cs.lab2;
import static java.lang.Math.*;

public class Vector2d {
    public final int x, y;
    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean precedes(Vector2d other) { return x <= other.x && y <= other.y; }
    public boolean follows(Vector2d other) { return x >= other.x && y >= other.y; }
    public Vector2d upperRight(Vector2d other) { return new Vector2d(max(x, other.x), max(y, other.y)); }
    public Vector2d lowerLeft(Vector2d other) { return new Vector2d(min(x, other.x), min(y, other.y)); }
    public Vector2d add(Vector2d other)  { return new Vector2d(x + other.x, y + other.y); }
    public Vector2d subtract(Vector2d other) { return new Vector2d(x - other.x, y - other.y); }
    public Vector2d opposite() { return new Vector2d(-x, -y); }

    @Override
    public String toString() { return String.format("(%s, %s)", x, y); }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector2d)) return false;
        if (obj == this) return true;
        var other = (Vector2d) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() { return x * y; }
}
