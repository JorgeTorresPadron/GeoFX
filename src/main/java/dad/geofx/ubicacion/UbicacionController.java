package dad.geofx.ubicacion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class UbicacionController implements Initializable {

	private UbicacionModel ubicacionModel = new UbicacionModel();

	@FXML
	private Label callingcodeLabel;

	@FXML
	private Label citystateLabel;

	@FXML
	private Label currencyLabel;

	@FXML
	private ImageView flagImageView;

	@FXML
	private Label iplocationLabel;

	@FXML
	private Label languageLabel;

	@FXML
	private Label latitudeLabel;

	@FXML
	private Label longitudeLabel;

	@FXML
	private Label timezoneLabel;

	@FXML
	private GridPane ubicacion;

	@FXML
	private Label zipcodeLabel;

	public UbicacionController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Ubicacion.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		latitudeLabel.textProperty().bind(ubicacionModel.latitudeProperty().asString());
		longitudeLabel.textProperty().bind(ubicacionModel.longitudeProperty().asString());
		callingcodeLabel.textProperty().bind(ubicacionModel.callingcodeProperty());
		zipcodeLabel.textProperty().bind(ubicacionModel.zipcodeProperty());
		timezoneLabel.textProperty().bind(ubicacionModel.timezoneProperty());
		languageLabel.textProperty().bind(ubicacionModel.languageProperty());
		currencyLabel.textProperty().bind(ubicacionModel.currencyProperty());
		iplocationLabel.textProperty().bind(ubicacionModel.iplocationProperty());
		citystateLabel.textProperty().bind(ubicacionModel.citystateProperty());
		flagImageView.imageProperty().bind(ubicacionModel.flagImageProperty());

	}
	
	public GridPane getUbicacion() {
		return ubicacion;
	}
	
	public UbicacionModel getUbicacionModel() {
		return ubicacionModel;
	}

}
