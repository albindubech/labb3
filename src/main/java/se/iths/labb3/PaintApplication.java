package se.iths.labb3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PaintApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")))));
        stage.setTitle("Paint");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
