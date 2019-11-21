package agh.cs;

import agh.cs.map.World;
import agh.cs.map.WorldRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Application {
    static World world;
    static WorldRenderer renderer;
    private static JFrame mainFrame = new JFrame("Animal") {
        @Override
        public void paint(Graphics g) {
            renderer.render(g);
        }
    };
    public static void main(String[] args){
        renderer = new WorldRenderer(world);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        mainFrame.setVisible(true);
    }
}
