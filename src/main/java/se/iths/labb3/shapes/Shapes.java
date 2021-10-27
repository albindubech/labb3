package se.iths.labb3.shapes;

import javafx.scene.paint.Color;

//Skapa olika metoder för att returnera olika typer av shapes

public class Shapes {

    public static Shape circleOf(double x, double y, double radius, Color color){
        return new Circle(color,x,y,radius);
    }

    public static Shape squareOf(double x, double y, double size, Color color){
        return new Square(color,x,y,size);
    }
}
