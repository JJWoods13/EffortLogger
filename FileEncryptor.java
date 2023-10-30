package asuHelloWorldJavaFX;
/*
 * Author: Shreyas Konanki
 * Due Date: 10/29/23
 * Description: File Encryption Prototype
 */
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

	// Entry point of the application
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("File Encryptor");

		// Create a FileChooser for opening and saving files
		FileChooser fileChooser = new FileChooser();

		// Create "Open File" button
		Button openButton = new Button("Open File");

		// TextArea to display file contents
		TextArea textArea = new TextArea();

		// Create "Encrypt" button
		Button encryptButton = new Button("Encrypt");

		// Action when the "Open File" button is clicked
		openButton.setOnAction(e -> {
			// Show a file dialog for opening a file
			File file = fileChooser.showOpenDialog(primaryStage);
			if (file != null) {
				try {
					// Read the contents of the selected file
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

		// Action when the "Encrypt" button is clicked
		encryptButton.setOnAction(e -> {
			// Show a file dialog for saving the encrypted file
			File file = fileChooser.showSaveDialog(primaryStage);
			if (file != null) {
				try {
					// Use a 128-bit key for encryption
					Key secretKey = new SecretKeySpec("YourSecretKey123".getBytes(), "AES");
					Cipher cipher = Cipher.getInstance("AES");
					cipher.init(Cipher.ENCRYPT_MODE, secretKey);

					// Encrypt the content and save it to the selected file
					try (OutputStream outputStream = new FileOutputStream(file);
						 CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher)) {
						cipherOutputStream.write(textArea.getText().getBytes());
					}

					// Clear the text area and show an information dialog
					textArea.clear();
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setContentText("File encrypted and saved.");
					alert.showAndWait();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		// Create a VBox to organize the UI components
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(openButton, textArea, encryptButton);

		// Set up the primary stage with the VBox and display it
		primaryStage.setScene(new Scene(vbox, 400, 300));
		primaryStage.show();
	}
}
