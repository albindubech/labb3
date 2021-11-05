package se.iths.labb3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class Square extends Shape {

    private double size;

    public Square(Color color, double x, double y, double size) {
        super(color, x, y, size);
        this.size = size;
    }

    public Square(Square shape) {
        super(shape);
        this.size = shape.size;

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
    public void setSize(double size) {
        this.size = size;
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

    @Override
    public Shape copyOf() {
        return new Square(this);
    }
}
