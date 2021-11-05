package se.iths.labb3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class Circle extends Shape {

    private double radius;

    public Circle(Color color, double x, double y, double radius) {
        super(color, x, y, radius);
        this.radius = radius;
    }

    public Circle(Circle shape) {
        super(shape);
        this.radius = shape.radius;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        double twoTimesRadius = 2* radius;
        graphicsContext.setFill(this.getColor());
        graphicsContext.fillOval(getX()- radius,getY()- radius,twoTimesRadius,twoTimesRadius);
    }

    @Override
    public boolean isInside(double x, double y) {
        double dx = x - getX();
        double dy = y - getY();

        double distanceFromCenter = dx * dx + dy * dy;

        return distanceFromCenter < radius * radius;
    }

    @Override
    public void setSize(double radius) {
        this.radius = radius;
    }

    @Override
    public String drawSVG() {
        String convertColor = "#" + getColor().toString().substring(2, 10);
        return "<circle cx=\"" + getX() + "\" " +
                "cy=\"" + getY() + "\" " +
                "r=\"" + radius + "\" " +
                "fill=\"" + convertColor + "\" />";
    }

    @Override
    public Shape copyOf() {
        return new Circle(this);
    }
}
