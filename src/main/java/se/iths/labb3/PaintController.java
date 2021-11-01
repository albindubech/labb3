package se.iths.labb3;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import se.iths.labb3.shapes.Shapes;

import javax.imageio.ImageIO;
import java.io.File;

public class PaintController {

    @FXML
    public Spinner<Integer> sizeSpinner;

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private RadioButton square;

    @FXML
    private RadioButton circle;

    @FXML
    private RadioButton select;

    @FXML
    private Button undo;

    Model model;

    public void initialize() {
        model = new Model();
        ToggleGroup group = new ToggleGroup();
        square.setToggleGroup(group);
        circle.setToggleGroup(group);
        select.setToggleGroup(group);

        canvas.widthProperty().addListener(observable -> draw());
        canvas.heightProperty().addListener(observable -> draw());

        colorPicker.valueProperty().bindBidirectional(model.colorProperty());
        model.size.bindBidirectional(sizeSpinner.getValueFactory().valueProperty());
    }

    private void draw() {
        var gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (var shape : model.shapes) {
            shape.draw(gc);
        }
    }

    public void onSave() {
        try {
            Image snapshot = canvas.snapshot(null, null);
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", new File("paint.png"));
        } catch (Exception e) {
            System.out.println("Failed to save image: " + e);
        }
    }

    public void onExit() {
        Platform.exit();
    }

    public void canvasClicked(MouseEvent event) {
        if (select.isSelected()) {
            model.shapes.stream()
                    .filter(shape -> shape.isInside(event.getX(), event.getY()))
                    .reduce((first, second) -> second)
                    .ifPresent(shape -> shape.setColor(model.getColor()));
        }

        if (circle.isSelected()) {
            model.shapes.add(Shapes.circleOf(event.getX(), event.getY(), model.getSize(), model.getColor()));
        } else if (square.isSelected()) {
            model.shapes.add(Shapes.squareOf(event.getX(), event.getY(), model.getSize(), model.getColor()));
        }
        draw();
    }

    public void undoButtonClicked() {
        var last = model.shapes.size();
        if (model.shapes.isEmpty())
            return;
        else
            model.shapes.remove(last - 1);
        draw();
    }
}