package dad.geofx.seguridad;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.geofx.map.CheckIP;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class SeguridadController implements Initializable {
	
	private static SeguridadModel seguridadModel = new SeguridadModel();

	@FXML
	private CheckBox crawlerCheck;

	@FXML
	private Label potentialLabel;

	@FXML
	private CheckBox proxyCheck;

	@FXML
	private GridPane seguridad;

	@FXML
	private Label shieldLabel;

	@FXML
	private Label threatLabel;

	@FXML
	private CheckBox torCheck;
	
	public SeguridadController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Seguridad.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		crawlerCheck.selectedProperty().bind(seguridadModel.crawlerProperty());
		proxyCheck.selectedProperty().bind(seguridadModel.proxyProperty());
		torCheck.selectedProperty().bind(seguridadModel.torProperty());
		potentialLabel.textProperty().bind(seguridadModel.potentialProperty());
		shieldLabel.textProperty().bind(seguridadModel.shieldProperty());
		threatLabel.textProperty().bind(seguridadModel.threatProperty());
	}
	
	public static void cambiarSeguridad(CheckIP checkip) {
		seguridadModel.setCrawler(checkip.getSecurity().getIsCrawler());
		seguridadModel.setPotential(checkip.getSecurity().getThreatTypes()+ "");
		seguridadModel.setProxy(checkip.getSecurity().getIsProxy());
		seguridadModel.setTor(checkip.getSecurity().getIsTor());
	}
	
	public GridPane getSeguridad() {
		return seguridad;
	}
	
	public SeguridadModel getSeguridadModel() {
		return seguridadModel;
	}

}
