package dad.geofx.ubicacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.geofx.map.CheckIP;
import dad.geofx.map.Language;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class UbicacionController implements Initializable {

	private static UbicacionModel ubicacionModel = new UbicacionModel();

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
		
		latitudeLabel.textProperty().bind(ubicacionModel.latitudeProperty());
		longitudeLabel.textProperty().bind(ubicacionModel.longitudeProperty());
		callingcodeLabel.textProperty().bind(ubicacionModel.callingcodeProperty());
		zipcodeLabel.textProperty().bind(ubicacionModel.zipcodeProperty());
		timezoneLabel.textProperty().bind(ubicacionModel.timezoneProperty());
		languageLabel.textProperty().bind(ubicacionModel.languageProperty());
		currencyLabel.textProperty().bind(ubicacionModel.currencyProperty());
		iplocationLabel.textProperty().bind(ubicacionModel.iplocationProperty());
		citystateLabel.textProperty().bind(ubicacionModel.citystateProperty());
		flagImageView.imageProperty().bind(ubicacionModel.flagImageProperty());

	}
	
	public static void cambiarUbicacion(CheckIP checkip) {
		try {
			ubicacionModel.setCallingcode("+" + checkip.getLocation().getCallingCode());
			ubicacionModel.setCitystate(checkip.getCity() + ", " + checkip.getRegionName());
			ubicacionModel.setCurrency(checkip.getCurrency().getName() + "(" + checkip.getCurrency().getSymbol() + ")");
			ubicacionModel.setFlag(new Image(new FileInputStream("src/main/resources/images/flag-icons/64x42/" + checkip.getCountryCode() + ".png")));
			ubicacionModel.setIplocation(checkip.getCountryName() + "(" + checkip.getCountryCode() + ")");
			Language language = checkip.getLocation().getLanguages().get(0);
			ubicacionModel.setLanguage(language.getName() + " (" + language.getCode() + ")");
			ubicacionModel.setLatitude(checkip.getLatitude() + "");
			ubicacionModel.setTimezone(checkip.getTimeZone().getCode());
			ubicacionModel.setZipcode(checkip.getZip());
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		
	}
	
	public GridPane getUbicacion() {
		return ubicacion;
	}
	
	public UbicacionModel getUbicacionModel() {
		return ubicacionModel;
	}

}
