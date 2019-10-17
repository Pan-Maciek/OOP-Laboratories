import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import agh.cs.lab2.Vector2d;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    private Vector2d vecA, vecB;

    @BeforeEach
    void setup() {
        this.vecA = new Vector2d(1, 2);
        this.vecB = new Vector2d(-2, 1);
    }

    @Test
    void precedes() {
        assertTrue(vecB.precedes(vecA));
        assertFalse(vecA.precedes(vecB));

        assertTrue(vecA.precedes(vecA));
    }

    @Test
    void follows() {
        assertTrue(vecA.follows(vecB));
        assertFalse(vecB.follows(vecA));

        assertTrue(vecA.follows(vecA));
    }

    @Test
    void upperRight() {
        final Vector2d expected  = new Vector2d(1, 2);
        final Vector2d actual = vecA.upperRight(vecB);

        assertEquals(expected, actual);
    }

    @Test
    void lowerLeft() {
        final Vector2d expected  = new Vector2d(-2, 1);
        final Vector2d actual = vecA.lowerLeft(vecB);

        assertEquals(expected, actual);
    }

    @Test
    void add() {
        final Vector2d expected  = new Vector2d(-1, 3);
        final Vector2d actual = vecA.add(vecB);

        assertEquals(expected, actual);
    }

    @Test
    void subtract() {
        final Vector2d expected  = new Vector2d(3, 1);
        final Vector2d actual = vecA.subtract(vecB);

        assertEquals(expected, actual);
    }

    @Test
    void opposite() {
        final Vector2d expected = new Vector2d(-1, -2);
        final Vector2d actual = vecA.opposite();

        assertEquals(expected, actual);
    }

    @Test
    void testToString() {
        final String expected = "(1, 2)";
        final String actual = vecA.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testEquals() {
        final Vector2d asserted = new Vector2d(1, 2);

        assertEquals(asserted, vecA);
    }
}