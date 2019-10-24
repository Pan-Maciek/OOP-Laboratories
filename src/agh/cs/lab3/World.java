package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.RectangularMap;

import java.util.concurrent.RecursiveAction;

import static agh.cs.lab2.MoveDirection.*;

import static java.lang.System.out;

public class World {
    static RectangularMap map = new RectangularMap(10, 5);
    public static void main(String[] args) {
        Animal dogo = new Animal(map);
        Animal gato = new Animal(map, new Vector2d(3, 4));
        map.place(dogo);
        map.place(gato);
        MoveDirection[] moves = OptionsParser.parse(args);
        map.run(moves);
    }
}
