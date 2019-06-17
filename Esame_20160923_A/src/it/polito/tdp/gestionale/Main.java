package it.polito.tdp.gestionale;

import it.polito.tdp.gestionale.model.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Model model=new Model();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("DidatticaGestionale.fxml"));
			BorderPane root = (BorderPane) loader.load();

			DidatticaGestionaleController controller = loader.getController();
			controller.setModel(model);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
