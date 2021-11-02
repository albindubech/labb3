package se.iths.labb3.shapes;

import javafx.beans.property.ObjectProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract sealed class Shape permits Circle, Square {
    private Color color;
    private double x;
    private double y;
    private double radius;

    public Shape(Color color, double x, double y, double radius) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public abstract void draw(GraphicsContext graphicsContext);

    public abstract boolean isInside(double x, double y);

    public Color getColor() {
        return color;
    }

    public Shape setColor(Color color) {
        this.color = color;
        return this;
    }

    public double getX() {
        return x;
    }

    public Shape setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    public Shape setY(double y) {
        this.y = y;
        return this;
    }

    public abstract void setSize(double radius);
}
