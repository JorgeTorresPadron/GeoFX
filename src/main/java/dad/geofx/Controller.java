package dad.geofx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.geofx.conexion.ConexionController;
import dad.geofx.seguridad.SeguridadController;
import dad.geofx.ubicacion.UbicacionController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class Controller implements Initializable {

	private Model model = new Model();

	@FXML
    private Button checkipButton;

    @FXML
    private BorderPane connectionPane;

    @FXML
    private Tab connectionTab;

    @FXML
    private TextField ipText;

    @FXML
    private BorderPane locationPane;

    @FXML
    private Tab locationTab;

    @FXML
    private BorderPane securityPane;

    @FXML
    private Tab securityTab;

    @FXML
    private BorderPane vista;

    @FXML
    private TabPane vistaTabPane;
    
    private UbicacionController ubicacionController = new UbicacionController();
    private ConexionController conexionController = new ConexionController();
    private SeguridadController seguridadController = new SeguridadController();

	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Vista.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model.ipProperty().bind(ipText.textProperty());
		locationPane.setTop(ubicacionController.getUbicacion());
		connectionPane.setTop(conexionController.getConexion());
		securityPane.setTop(seguridadController.getSeguridad());

	}

	public Model getModel() {
		return model;
	}

	public BorderPane getVista() {
		return vista;
	}

}
