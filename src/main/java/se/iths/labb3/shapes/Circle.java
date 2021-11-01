package se.iths.labb3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class Circle extends Shape {

    private double radius;

    public Circle(Color color, double x, double y, double radius) {
        super(color, x, y);
        this.radius = radius;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        double twoTimesRadius = 2*radius;
        graphicsContext.setFill(this.getColor());
        graphicsContext.fillOval(getX()-radius,getY()-radius,twoTimesRadius,twoTimesRadius);
    }

    @Override
    public boolean isInside(double x, double y) {
        double dx = x - getX();
        double dy = y - getY();

        double distanceFromCenter = dx * dx + dy * dy;

        return distanceFromCenter < radius*radius;
    }
}
