package agh.cs.lab7;

import agh.cs.lab2.Vector2d;
import agh.cs.lab5.AbstractMapElement;

import java.util.ArrayList;
import java.util.List;

public class IPositionChange {
    public interface Observer {
        void positionChanged(Vector2d oldPosition, Vector2d newPosition);
        void initialPosition(Vector2d position);
    }
    public static abstract class Observable extends AbstractMapElement {
        public Observable(Vector2d initialPosition) {
            super(initialPosition);
        }
        List<Observer> observers = new ArrayList<>();
        public void subscribe(Observer observer) {
            observers.add(observer);
            for (Observer o : observers) o.initialPosition(this.position);
        }
        public void unsubscribe(Observer observer) { observers.remove(observer); }
        public void setPosition(Vector2d newPosition) {
            var oldPosition = this.position;
            this.position = newPosition;
            for (Observer o : observers) o.positionChanged(oldPosition, newPosition);
        }
    }
}
