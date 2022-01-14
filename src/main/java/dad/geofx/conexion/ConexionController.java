package dad.geofx.conexion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ConexionController implements Initializable {

	private ConexionModel conexionModel = new ConexionModel();

	@FXML
	private Label asnLabel;

	@FXML
	private GridPane conexion;

	@FXML
	private Label hostnameLabel;

	@FXML
	private Label ipaddressLabel;

	@FXML
	private Label ispLabel;

	@FXML
	private Label typeLabel;

	public ConexionController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Conexion.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		asnLabel.textProperty().bind(conexionModel.asnProperty().asString());
		hostnameLabel.textProperty().bind(conexionModel.hostnameProperty());
		ipaddressLabel.textProperty().bind(conexionModel.ipaddressProperty());
		ispLabel.textProperty().bind(conexionModel.ispProperty());
		typeLabel.textProperty().bind(conexionModel.typeProperty());

	}

	public GridPane getConexion() {
		return conexion;
	}

	public ConexionModel getConexionModel() {
		return conexionModel;
	}

}
