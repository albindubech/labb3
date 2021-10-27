module se.iths.labb3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;


    opens se.iths.labb3 to javafx.fxml;
    exports se.iths.labb3;
    exports se.iths.labb3.shapes;
    opens se.iths.labb3.shapes to javafx.fxml;
}