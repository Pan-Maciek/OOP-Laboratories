import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab4.RectangularMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    Animal dog;

    @BeforeEach
    void setup() {
        RectangularMap map = new RectangularMap(4,4);
        dog = new Animal(map);
    }

    @Test
    void dogChasesHisTail() {
        final MapDirection initialDirection = dog.getDirection();
        for (int i = 0; i < 4; i++) {
            MapDirection direction = dog.getDirection();
            dog.move(MoveDirection.LEFT);
            assertEquals(direction.previous(), dog.getDirection());
        }
        for (int i = 0; i < 4; i++) {
            MapDirection direction = dog.getDirection();
            dog.move(MoveDirection.RIGHT);
            assertEquals(direction.next(), dog.getDirection());
        }
        assertEquals(initialDirection, dog.getDirection());
    }

    @Test
    void initialPosition() {
        assertEquals(dog.getPosition(), new Vector2d(2,2));
    }

    @Test
    void moveForward() {
        Vector2d initialPosition = dog.getPosition();
        dog.move(MoveDirection.FORWARD);
        Vector2d expected = initialPosition.add(dog.getDirection().unitVector);
        for (int i = 0; i < 3; i++) {
            dog.move(MoveDirection.FORWARD);
            dog.move(MoveDirection.LEFT);
            assertNotEquals(dog.getPosition(), expected);
        }
        dog.move(MoveDirection.FORWARD);
        dog.move(MoveDirection.LEFT);
        assertEquals(expected, dog.getPosition());
    }

    @Test
    void moveBackward() {
        Vector2d initialPosition = dog.getPosition();
        dog.move(MoveDirection.BACKWARD);
        Vector2d expected = initialPosition.subtract(dog.getDirection().unitVector);
        assertEquals(expected, dog.getPosition());
    }

    @Test
    void boundaryCheck() {
        for (int i = 0; i < 4; i++) {
            dog.move(MoveDirection.LEFT);
            for (int j = 0; j < 10; j++)
                dog.move(MoveDirection.FORWARD);
            Vector2d position = dog.getPosition();
            assertTrue(position.x >= 0 && position.x <= 4 && position.y >= 0 && position.y <= 4);
        }
    }

    @Test
    void inputCheck() {
        String[] args = { "l", "r", "f", "b", "x", "d" };
        assertThrows(RuntimeException.class, () -> OptionsParser.parse(args));
    }

    @Test
    void inputCheck2() {
        String[] args = { "l", "r", "f", "b" };
        MoveDirection[] expected = { MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.BACKWARD };
        MoveDirection[] actual = OptionsParser.parse(args);
        assertArrayEquals(actual, expected);
    }
}
