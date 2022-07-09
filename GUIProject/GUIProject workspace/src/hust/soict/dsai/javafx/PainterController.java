package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton penRadioButton;
    @FXML
    private RadioButton eraserRadioButton;
    @FXML
    private ToggleGroup penEraserGroup;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle;
    	if ((RadioButton)(penEraserGroup.getSelectedToggle()) == penRadioButton) {
			newCircle = new Circle(
	    			event.getX(), event.getY(), 4, Color.BLACK);
		} else {
			newCircle = new Circle(
	    			event.getX(), event.getY(), 4, Color.WHITE);
		}
    	drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

}
