package agh.cs.lab1;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

import static java.lang.System.out;

public class World {

    public static void main(String[] args) {
        out.println("Start");
        Direction[] directions = Arrays.stream(args)
                .map(Direction::parse)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toArray(Direction[]::new);
        run(directions);
        out.println("Stop");
    }

    public static void run(Direction[] moves) {
        for (Direction direction : moves) {
            switch (direction) {
                case LEFT: out.println("Zwierzak skręca w lewo"); break;
                case RIGHT: out.println("Zwierzak skręca w prawo"); break;
                case FORWARD: out.println("Zwierzak idzie do przodu"); break;
                case BACKWARD: out.println("Zwierzak idzie do tył"); break;
            }
        }
    }

}
