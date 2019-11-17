package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import agh.cs.lab5.GrassField;

import javax.swing.*;
import java.util.concurrent.RecursiveAction;

import static agh.cs.lab2.MoveDirection.*;

import static java.lang.System.out;

public class World {
    static IWorldMap map = new GrassField(5);
    public static void main(String[] args) {
        try {
            var dogo = new Animal(map);
            var gato = new Animal(map, new Vector2d(3, 4));
            map.place(dogo);
            map.place(gato);
            var moves = OptionsParser.parse(args);
            map.run(moves);
            map.place(new Animal(map, new Vector2d(0,0)));
            out.println(map);
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }
    }
}
