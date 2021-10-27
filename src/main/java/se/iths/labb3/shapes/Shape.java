package se.iths.labb3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

//Göra shape abstract för att respresentera shapes
//Skapa subklass circle
//Skapa subklass rectangle
//immutable
//Definiera en metod som kan rendera objektet med javafx
//Gör specifika implementationer i subklasser (polymorfism)
//Hindra användare att skapa circle obkelt utan att gå via våra factory metoder på klassen shapes

//bonus:
//Hindra arv av shape? sealed types

public abstract sealed class Shape permits Circle, Square {
    private Color color;
    private double x;
    private double y;

    public Shape(Color color, double x, double y) {
        this.color = color;
        this.x = x;
        this.y = y;
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
}
