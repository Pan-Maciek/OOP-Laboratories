import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import agh.cs.lab2.MapDirection;

public class MapDirectionTest {
    @Test
    void next() {
        final MapDirection northTest = MapDirection.NORTH;
        assertEquals(MapDirection.EAST, northTest.next());

        final MapDirection eastTest = MapDirection.EAST;
        assertEquals(MapDirection.SOUTH, eastTest.next());

        final MapDirection southTest = MapDirection.SOUTH;
        assertEquals(MapDirection.WEST, southTest.next());

        final MapDirection westTest = MapDirection.WEST;
        assertEquals(MapDirection.NORTH, westTest.next());
    }


    @Test
    void previous() {
        final MapDirection northTest = MapDirection.NORTH;
        assertEquals(MapDirection.WEST, northTest.previous());

        final MapDirection eastTest = MapDirection.EAST;
        assertEquals(MapDirection.NORTH, eastTest.previous());

        final MapDirection southTest = MapDirection.SOUTH;
        assertEquals(MapDirection.EAST, southTest.previous());

        final MapDirection westTest = MapDirection.WEST;
        assertEquals(MapDirection.SOUTH, westTest.previous());
    }
}
