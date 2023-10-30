package effortLoggerV2;
//Author: James Woods

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.stage.Stage;
 
public class EffortLoggerV2 extends Application {
    private TabPane tabPane;
    private EffortConsole effortConsole;
    private PlanningPoker planningPoker;
    private DefectConsole defectConsole;
    private EffortLog effortLog;
    private DefectLog defectLog;
    private Definitions definitions;
    private LogManager logManager;
	public static final int WIN_SIZE_X = 1000, WIN_SIZE_Y = 600;
	
	public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
        primaryStage.setTitle("EffortLogger V2");
        
		tabPane = new TabPane();
		effortConsole = new EffortConsole();
		planningPoker = new PlanningPoker();
		defectConsole = new DefectConsole();
		effortLog = new EffortLog();
		defectLog = new DefectLog();
		definitions = new Definitions();
		logManager = new LogManager();


		Tab tab1 = new Tab();
		tab1.setText("Effort Console");
		tab1.setContent(effortConsole);

		Tab tab2 = new Tab();
		tab2.setText("Planning Poker");
		tab2.setContent(planningPoker);
		
		Tab tab3 = new Tab();
		tab3.setText("Defect Console");
		tab3.setContent(defectConsole);
		
		Tab tab4 = new Tab();
		tab4.setText("EffortLog");
		tab4.setContent(effortLog);
		
		Tab tab5 = new Tab();
		tab5.setText("DefectLog");
		tab5.setContent(defectLog);
		
		Tab tab6 = new Tab();
		tab6.setText("Definitions");
		tab6.setContent(definitions);
		
		Tab tab7 = new Tab();
		tab7.setText("Log Manager");
		tab7.setContent(logManager);

		tabPane.getSelectionModel().select(0);
		tabPane.getTabs().addAll(tab1, tab2, tab3, tab4, tab5, tab6, tab7);
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        StackPane root = new StackPane();
		root.getChildren().add(tabPane);

		Scene scene = new Scene(root, WIN_SIZE_X, WIN_SIZE_Y);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}