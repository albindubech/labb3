package se.iths.labb3;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import se.iths.labb3.shapes.Shape;

import java.util.ArrayList;
import java.util.List;


public class Model {

    public final ObjectProperty<Integer> size;
    private final BooleanProperty inColor;
    private final ObjectProperty<Color> color;

    ObservableList<String> observableList =
            FXCollections.observableArrayList();

    List<Shape> shapes = new ArrayList<>();

    public Model() {
        this.inColor = new SimpleBooleanProperty();
        this.color = new SimpleObjectProperty<>(Color.BLACK);
        this.size = new SimpleObjectProperty<>(1);
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

    public void setColor(Color color) {
        this.color.set(color);
    }

    public boolean isInColor() {
        return inColor.get();
    }

    public BooleanProperty inColorProperty() {
        return inColor;
    }

    public void setInColor(boolean inColor) {
        this.inColor.set(inColor);
    }
}
