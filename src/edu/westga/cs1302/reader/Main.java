package edu.westga.cs1302.reader;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane thePane = this.loadGui();
			Scene theScene = new Scene(thePane);
			primaryStage.setScene(theScene);
			primaryStage.setTitle("Reader");
			primaryStage.show();
		} catch (IllegalStateException | IOException anException) {
			anException.printStackTrace();
		}
	}

	private Pane loadGui() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("view/ReaderGUI.fxml"));
		return (Pane) loader.load();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
