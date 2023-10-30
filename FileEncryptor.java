package asuHelloWorldJavaFX;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
 
public class FileEncryptor extends Application {
	
	 public static void main(String[] args) {
	        launch(args);
	    }

	    @Override
	    public void start(Stage primaryStage) {
	        primaryStage.setTitle("File Encryptor");

	        FileChooser fileChooser = new FileChooser();

	        Button openButton = new Button("Open File");
	        TextArea textArea = new TextArea();
	        Button encryptButton = new Button("Encrypt");

	        openButton.setOnAction(e -> {
	            File file = fileChooser.showOpenDialog(primaryStage);
	            if (file != null) {
	                try {
	                    BufferedReader reader = new BufferedReader(new FileReader(file));
	                    String line;
	                    StringBuilder content = new StringBuilder();
	                    while ((line = reader.readLine()) != null) {
	                        content.append(line).append("\n");
	                    }
	                    textArea.setText(content.toString());
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        });

	        encryptButton.setOnAction(e -> {
	            File file = fileChooser.showSaveDialog(primaryStage);
	            if (file != null) {
	                try {
	                    // Use a 128-bit key
	                    Key secretKey = new SecretKeySpec("YourSecretKey123".getBytes(), "AES");
	                    Cipher cipher = Cipher.getInstance("AES");
	                    cipher.init(Cipher.ENCRYPT_MODE, secretKey);

	                    try (OutputStream outputStream = new FileOutputStream(file);
	                         CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher)) {
	                        cipherOutputStream.write(textArea.getText().getBytes());
	                    }

	                    textArea.clear();
	                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
	                    alert.setContentText("File encrypted and saved.");
	                    alert.showAndWait();
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	        });

	        VBox vbox = new VBox(10);
	        vbox.getChildren().addAll(openButton, textArea, encryptButton);

	        primaryStage.setScene(new Scene(vbox, 400, 300));
	        primaryStage.show();
	    }

}
