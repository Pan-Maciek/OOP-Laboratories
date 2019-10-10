package agh.cs.lab2;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        Vector2d pos1 = new Vector2d(1,2);
        out.println(pos1);
        Vector2d pos2 = new Vector2d(-2,1);
        out.println(pos1.add(pos2));
    }
}
