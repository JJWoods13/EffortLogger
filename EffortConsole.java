package effortLoggerV2;

import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class EffortConsole extends VBox{
	Label tempLabel;
	GridPane tempGrid;
	
	public EffortConsole(){
		tempGrid = new GridPane();
		tempLabel = new Label("This is the Effort Console");
		tempLabel.setTextFill(Color.BLACK);
		
		tempGrid.add(tempLabel, 0, 0);
	}
}