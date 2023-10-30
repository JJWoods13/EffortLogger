package effortLoggerV2;
//Author: James Woods

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class DefectLog extends GridPane{
	Label lblProject, lblNumEntries;
	TextField first0, first1, first2, first3, first4, first5, first6, first7;
	TextField second0, second1, second2, second3, second4, second5, second6, second7;
	Button btnFirst, btnSecond;
	boolean firstFlag = false, secondFlag = false;
	final int NUM_COLS = 9;
	final int MIN_ROWS = 3;
	
	
	public DefectLog() {
		getColumnConstraints().add(new ColumnConstraints(50)); 	//Column 0
		getColumnConstraints().add(new ColumnConstraints(100));	//Column 1
		getColumnConstraints().add(new ColumnConstraints(75)); 	//Column 2
		getColumnConstraints().add(new ColumnConstraints(75)); 	//Column 3
		getColumnConstraints().add(new ColumnConstraints(75)); 	//Column 4
		getColumnConstraints().add(new ColumnConstraints(150));	//Column 5
		getColumnConstraints().add(new ColumnConstraints(100));	//Column 6
		getColumnConstraints().add(new ColumnConstraints(50));	//Column 7
		getColumnConstraints().add(new ColumnConstraints(75)); 	//Column 8
		
		lblProject = new Label("Example Project");
		lblNumEntries = new Label("2");
		
		add(new Label("Defect Log for Project 1:"), 0, 0, 2, 1);
		add(lblProject, 2, 0, 3, 1);
		add(new Label("Number of Entries:"), 5, 0, 1, 1);
		add(lblNumEntries, 6, 0, 1, 1);
		add(new Label("Number"), 0, 2, 1, 1);
		add(new Label("Name"), 1, 2, 1, 1);
		add(new Label("Detail"), 2, 2, 1, 1);
		add(new Label("Injected"), 3, 2, 1, 1);
		add(new Label("Removed"), 4, 2, 1, 1);
		add(new Label("Category"), 5, 2, 1, 1);
		add(new Label("Status"), 6, 2, 1, 1);
		add(new Label("Fix"), 7, 2, 1, 1);
		add(new Label("Edit Entries"), 8, 2, 1, 1);
		
		first0 = new TextField("1");
		first1 = new TextField("Example Name");
		first2 = new TextField("Details");
		first3 = new TextField("Example");
		first4 = new TextField("Example");
		first5 = new TextField("Ex Category");
		first6 = new TextField("Ex Status");
		first7 = new TextField("Fix");
		
		first0.setEditable(false);
		first1.setEditable(false);
		first2.setEditable(false);
		first3.setEditable(false);
		first4.setEditable(false);
		first5.setEditable(false);
		first6.setEditable(false);
		first7.setEditable(false);
		
		btnFirst = new Button("Edit");
		btnFirst.setOnAction(new EditButton1Handler());
		
		add(first0, 0, 3, 1, 1);
		add(first1, 1, 3, 1, 1);
		add(first2, 2, 3, 1, 1);
		add(first3, 3, 3, 1, 1);
		add(first4, 4, 3, 1, 1);
		add(first5, 5, 3, 1, 1);
		add(first6, 6, 3, 1, 1);
		add(first7, 7, 3, 1, 1);
		add(btnFirst, 8, 3, 1, 1);
		
		second0 = new TextField("2");
		second1 = new TextField("Example Name");
		second2 = new TextField("Details");
		second3 = new TextField("Example");
		second4 = new TextField("Example");
		second5 = new TextField("Ex Category");
		second6 = new TextField("Ex Status");
		second7 = new TextField("Fix");
		
		second0.setEditable(false);
		second1.setEditable(false);
		second2.setEditable(false);
		second3.setEditable(false);
		second4.setEditable(false);
		second5.setEditable(false);
		second6.setEditable(false);
		second7.setEditable(false);
		
		btnSecond = new Button("Edit");
		btnSecond.setOnAction(new EditButton2Handler());
		
		add(second0, 0, 4, 1, 1);
		add(second1, 1, 4, 1, 1);
		add(second2, 2, 4, 1, 1);
		add(second3, 3, 4, 1, 1);
		add(second4, 4, 4, 1, 1);
		add(second5, 5, 4, 1, 1);
		add(second6, 6, 4, 1, 1);
		add(second7, 7, 4, 1, 1);
		add(btnSecond, 8, 4, 1, 1);
	}
	
	private class EditButton1Handler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {
			if(!firstFlag) {
				first0.setEditable(true);
				first1.setEditable(true);
				first2.setEditable(true);
				first3.setEditable(true);
				first4.setEditable(true);
				first5.setEditable(true);
				first6.setEditable(true);
				first7.setEditable(true);
				
				btnFirst.setText("Save");
			}else {
				first0.setEditable(false);
				first1.setEditable(false);
				first2.setEditable(false);
				first3.setEditable(false);
				first4.setEditable(false);
				first5.setEditable(false);
				first6.setEditable(false);
				first7.setEditable(false);
				
				btnFirst.setText("Edit");
			}
			firstFlag = !firstFlag;
		}
	}
	
	private class EditButton2Handler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {
			if(!secondFlag) {
				second0.setEditable(true);
				second1.setEditable(true);
				second2.setEditable(true);
				second3.setEditable(true);
				second4.setEditable(true);
				second5.setEditable(true);
				second6.setEditable(true);
				second7.setEditable(true);
				
				btnSecond.setText("Save");
			}else {
				second0.setEditable(false);
				second1.setEditable(false);
				second2.setEditable(false);
				second3.setEditable(false);
				second4.setEditable(false);
				second5.setEditable(false);
				second6.setEditable(false);
				second7.setEditable(false);
				
				btnSecond.setText("Edit");
			}
			secondFlag = !secondFlag;
		}
	}
}
