package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;
import static agh.cs.lab2.MoveDirection.*;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        Animal dogo = new Animal();
        MoveDirection[] moves = OptionsParser.parse(args);
        for (MoveDirection move : moves)
            dogo.move(move);
        out.println(dogo);
    }
}
