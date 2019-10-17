package agh.cs.lab2;

public enum  MoveDirection {
        FORWARD, BACKWARD, RIGHT, LEFT;
        public static MoveDirection parse(String s) {
               switch (s) {
                   case "f": return FORWARD;
                   case "b": return BACKWARD;
                   case "r": return RIGHT;
                   case "l": return LEFT;
                   default: return null;
               }
        }
}
