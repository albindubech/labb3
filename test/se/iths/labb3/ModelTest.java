package se.iths.labb3;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.iths.labb3.shapes.Shapes;

import static org.assertj.core.api.Assertions.assertThat;

class ModelTest {

    Model model;

    @BeforeEach
    void setUp() {
        model = new Model();
    }

    @Test
    void whenTryingToAddNewSquareANewSquareShouldBePutInTheList() {
        model.shapes.add(Shapes.squareOf(1,1,5, Color.BLACK));
        assertThat(model.shapes.size()).isEqualTo(1);
    }

    @Test
    void whenTryingToAddNewCircleANewCircleShouldBePutInTheList() {
        model.shapes.add(Shapes.circleOf(2,2,10, Color.RED));
        assertThat(model.shapes.size()).isEqualTo(1);
    }

//    @Test
//    void getSizeShouldReturnSize() {
//        assertThat(model.getSize()).isEqualTo(model.size);
//    }

//    @Test
//    void getColorShouldReturnColor() {
//
//    }

}