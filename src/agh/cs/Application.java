package agh.cs;

import agh.cs.map.World;
import agh.cs.map.WorldRenderer;
import agh.cs.map.entities.Animal;
import agh.cs.map.entities.Grass;
import agh.cs.map.entities.abstractions.MoveDirection;
import agh.cs.math.Vector2d;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Application {
    private static JFrame mainFrame = new JFrame("Animal");
    public static void main(String[] args){
        var world = new World() { };
        world.place(new Animal(new Vector2d(0,0)));
        world.place(new Animal(new Vector2d(1,0)));
        world.place(new Animal(new Vector2d(1,1)));
        world.place(new Grass(new Vector2d(2,2)));
        world.place(new Animal(new Vector2d(3,5)) {{ move(MoveDirection.LEFT);}});
        var renderer = new WorldRenderer(world);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        mainFrame.setVisible(true);
        mainFrame.add(renderer, BorderLayout.CENTER);
        mainFrame.addMouseMotionListener(renderer);
        mainFrame.addMouseListener(renderer);
    }
}
