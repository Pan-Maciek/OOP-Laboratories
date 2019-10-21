package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        return Arrays.stream(args)
                .map(MoveDirection::parse)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toArray(MoveDirection[]::new);
    }
}
