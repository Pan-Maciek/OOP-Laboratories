import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab4.RectangularMap;
import agh.cs.lab5.Grass;
import agh.cs.lab5.GrassField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    private RectangularMap map;

    @BeforeEach
    void setup() {
        this.map = new RectangularMap(10, 10);
    }

    @Test
    void canMoveTo(){
        var animal = new Animal(map, new Vector2d(-4, -5));
        map.place(animal);
        assertFalse(map.canMoveTo(animal.getPosition()));
        assertTrue(map.canMoveTo(new Vector2d(0, 0)));
    }

    @Test
    void place() {
        var grass = new Grass(new Vector2d(0,0));
        var animal1 = new Animal(map, new Vector2d(0, 0));
        var animal2 = new Animal(map, new Vector2d(0, 0));
        var animal3 = new Animal(map, new Vector2d(1, 1));
        assertTrue(map.place(grass));
        assertTrue(map.place(animal1));
        assertFalse(map.place(animal2));
        assertTrue(map.place(animal3));
        var animal4 = new Animal(map, new Vector2d(111, 111));
        assertFalse(map.place(animal4));
    }

    @Test
    void isOccupied() {
        final var position = new Vector2d(0, 0);
        var animal = new Animal(map, position);
        assertFalse(map.isOccupied(position));
        map.place(animal);
        assertFalse(map.isOccupied(new Vector2d(10, 10)));
        map.place(animal);
        assertTrue(map.isOccupied(position));
        var md = OptionsParser.parse(new String[]{"f", "f"});
        map.run(md);
        assertFalse(map.isOccupied(position));
        assertTrue(map.isOccupied(new Vector2d(0, 2)));
    }

    @Test
    void objectAt() {
        final var pos = new Vector2d(0, 0);
        assertNull(map.objectAt(pos));
        var animal = new Animal(map, pos);
        map.place(animal);
        assertEquals(animal, map.objectAt(pos));
    }
}
