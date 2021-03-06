package dad.geofx.conexion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.geofx.map.CheckIP;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ConexionController implements Initializable {

	private static ConexionModel conexionModel = new ConexionModel();

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
		asnLabel.textProperty().bind(conexionModel.asnProperty());
		hostnameLabel.textProperty().bind(conexionModel.hostnameProperty());
		ipaddressLabel.textProperty().bind(conexionModel.ipaddressProperty());
		ispLabel.textProperty().bind(conexionModel.ispProperty());
		typeLabel.textProperty().bind(conexionModel.typeProperty());

	}
	
	public static void cambiarConexion(CheckIP checkip) {
		conexionModel.setAsn(checkip.getConnection().getAsn() + "");
		conexionModel.setHostname(checkip.getHostname());
		conexionModel.setIpaddress(checkip.getIp());
		conexionModel.setIsp(checkip.getConnection().getIsp());
		conexionModel.setType(checkip.getType());
	}

	public GridPane getConexion() {
		return conexion;
	}

	public ConexionModel getConexionModel() {
		return conexionModel;
	}

}
