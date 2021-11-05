package se.iths.labb3;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import se.iths.labb3.shapes.Shape;
import se.iths.labb3.shapes.Shapes;

public class PaintController {

    @FXML
    private Spinner<Integer> sizeSpinner;

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

    private Model model;

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
        SvgConverter svgConverter = new SvgConverter();
        svgConverter.saveSVGFile(model);
    }

    public void onExit() {
        Platform.exit();
    }

    public void canvasClicked(MouseEvent event) {
        if (select.isSelected())
            changeColorOrSize(event);
        else
            addShapeOfSquareOrCircle(event);
        draw();
    }

    private void addShapeOfSquareOrCircle(MouseEvent event) {
        ObservableList<Shape> temp = model.getTempList();
        if (circle.isSelected()) {
            model.undoDeque.addLast(temp);
            model.shapes.add(Shapes.circleOf(event.getX(), event.getY(), model.getSize(), model.getColor()));
        } else if (square.isSelected()) {
            model.undoDeque.addLast(temp);
            model.shapes.add(Shapes.squareOf(event.getX(), event.getY(), model.getSize(), model.getColor()));
        }
    }

    private void changeColorOrSize(MouseEvent event) {
        ObservableList<Shape> temp = model.getTempList();
        model.undoDeque.addLast(temp);
        changeColor(event);
        changeSize(event);
    }

    private void changeSize(MouseEvent event) {
        model.shapes.stream()
                .filter(shape -> shape.isInside(event.getX(), event.getY()))
                .reduce((first, second) -> second)
                .ifPresent(shape -> shape.setSize(sizeSpinner.getValue()));
    }

    private void changeColor(MouseEvent event) {
        model.shapes.stream()
                .filter(shape -> shape.isInside(event.getX(), event.getY()))
                .reduce((first, second) -> second)
                .ifPresent(shape -> shape.setColor(model.getColor()));
    }

    public void undoButtonClicked() {
        model.undo();
        draw();
    }

    public void redoButtonClicked() {
        model.redo();
        draw();
    }
}