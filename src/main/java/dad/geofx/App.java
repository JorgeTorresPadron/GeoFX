package dad.geofx;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	private Controller controller;
	
	@Override
	public void init() throws IOException {
		controller = new Controller();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Scene scene = new Scene(controller.getVista());
		
		primaryStage.setTitle("GeoFX");
		primaryStage.setScene(scene);
		primaryStage.show();	

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
