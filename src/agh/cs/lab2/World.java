package agh.cs.lab2;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        var pos1 = new Vector2d(1,2);
        out.println(pos1);
        var pos2 = new Vector2d(-2,1);
        out.println(pos1.add(pos2));
    }
}
