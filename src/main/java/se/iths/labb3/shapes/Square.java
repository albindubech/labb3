package se.iths.labb3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class Square extends Shape {

    double size;

    public Square(Color color, double x, double y, double radius) {
        super(color, x, y, radius);
        this.size = radius;
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

        double distanceFromCenter = dx * dx + dy * dy;

        return distanceFromCenter < size * size;
    }

    @Override
    public void setSize(double radius) {
        this.size = radius;
    }

    @Override
    public String drawSVG() {
        String convertColor = "#" + getColor().toString().substring(2, 10);
        return "<rect x=\"" + getX() + "\" " +
                "y=\"" + getY() + "\" " +
                "width=\"" + size + "\" " +
                "height=\"" + size + "\" " +
                "fill=\"" + convertColor + "\" />";
    }
}
