import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTest {

    private IWorldMap map;

    @BeforeEach
    void setup() {
        this.map = new RectangularMap(10, 10);
    }

    @Test
    void testMovingAround() {
        String[] args = { "f", "r", "f", "r","f", "r", "f" };

        var animal = new Animal(map, new Vector2d(0, 0));

        map.place(animal);
        map.run(OptionsParser.parse(args));

        var expected = new Vector2d(0, 0);
        var actual = animal.getPosition();

        assertEquals(expected, actual);
    }

    @Test
    void testMovingOutsideMap() {
        String[] args = { "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f" };

        var animal = new Animal(this.map, new Vector2d(0, 0));

        map.place(animal);
        map.run(OptionsParser.parse(args));

        var expected = new Vector2d(0, 10);
        var actual = animal.getPosition();

        assertEquals(expected, actual);
    }

    @Test
    void testCollidingAnimals() {
        String[] args = { "f", "l", "r", "f", "f" };

        var animalA = new Animal(this.map, new Vector2d(0, 0));
        var animalB = new Animal(this.map, new Vector2d(1, 1));

        map.place(animalA);
        map.place(animalB);
        map.run(OptionsParser.parse(args));

        var expectedPositionA = new Vector2d(0, 1);
        var expectedPositionB = new Vector2d(1, 1);

        var actualA = animalA.getPosition();
        var actualB = animalB.getPosition();

        assertEquals(expectedPositionA, actualA);
        assertEquals(expectedPositionB, actualB);
    }


}
