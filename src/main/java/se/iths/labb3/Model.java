package se.iths.labb3;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import se.iths.labb3.shapes.Shape;

import java.util.ArrayDeque;
import java.util.Deque;


public class Model {

    private final ObjectProperty<Color> color;
    ObjectProperty<Integer> size;

    ObservableList<Shape> shapes;
    Deque<ObservableList<Shape>> undoDeque;
    Deque<ObservableList<Shape>> redoDeque;

    public Model() {
        this.shapes = FXCollections.observableArrayList();
        this.undoDeque = new ArrayDeque<>();
        this.redoDeque = new ArrayDeque<>();

        this.color = new SimpleObjectProperty<>(Color.BLACK);
        this.size = new SimpleObjectProperty<>(18);
    }

    public Integer getSize() {
        return size.get();
    }

    public Color getColor() {
        return color.get();
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public ObservableList<Shape> getTempList() {
        ObservableList<Shape> tempList = FXCollections.observableArrayList();

        for (Shape shape : shapes) {
            tempList.add(shape.copyOf());
        }
        return tempList;
    }

    public void redo() {
        if (redoDeque.isEmpty())
            return;
        ObservableList<Shape> temp = getTempList();
        undoDeque.addLast(temp);
        shapes = redoDeque.removeLast();
    }

    public void undo() {
        if (undoDeque.isEmpty())
            return;
        ObservableList<Shape> temp = getTempList();
        redoDeque.addLast(temp);
        shapes = undoDeque.removeLast();
    }
}
