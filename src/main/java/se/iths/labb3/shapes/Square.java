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

//        if (getX() >= rx &&         // right of the left edge AND
//                px <= rx + rw &&    // left of the right edge AND
//                py >= ry &&         // below the top AND
//                py <= ry + rh) {    // above the bottom
//            return true;
//        }
//        return false;

        return true;
    }
}
