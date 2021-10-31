package se.iths.labb3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class Square extends Shape {

    double size;

    public Square(Color color, double x, double y, double size) {
        super(color, x, y);
        this.size = size;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        double halfSize = size * 0.5;
        graphicsContext.setFill(this.getColor());
        graphicsContext.fillRect(getX() - halfSize, getY() - halfSize, size, size);
    }

    @Override
    public boolean isInside(double x, double y) {
        double dx = x - getX();
        double dy = y - getY();

//        double distanceFromCenter = Math.sqrt(dx * dx + dy * dy);
        double distanceFromCenter = dx * dx + dy * dy;

//        return distanceFromCenter < radius;
        return distanceFromCenter < size*size;
    }
}
