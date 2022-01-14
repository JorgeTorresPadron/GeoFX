package dad.geofx.ubicacion;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class UbicacionModel {
	
	// private ObjectProperty<PapiMessage> ref = new SimpleObjectProperty<PapiMessage>();
	
	private DoubleProperty latitude = new SimpleDoubleProperty();
	private DoubleProperty longitude = new SimpleDoubleProperty();
	private StringProperty iplocation = new SimpleStringProperty();
	private StringProperty flag = new SimpleStringProperty();
	private StringProperty citystate = new SimpleStringProperty();
	private StringProperty zipcode = new SimpleStringProperty();
	private StringProperty language = new SimpleStringProperty();
	private StringProperty timezone = new SimpleStringProperty();
	private StringProperty callingcode = new SimpleStringProperty();
	private StringProperty currency = new SimpleStringProperty();
	
	private ObjectProperty<Image> flagImage = new SimpleObjectProperty<Image>();

	public final DoubleProperty latitudeProperty() {
		return this.latitude;
	}
	

	public final double getLatitude() {
		return this.latitudeProperty().get();
	}
	

	public final void setLatitude(final double latitude) {
		this.latitudeProperty().set(latitude);
	}
	

	public final DoubleProperty longitudeProperty() {
		return this.longitude;
	}
	

	public final double getLongitude() {
		return this.longitudeProperty().get();
	}
	

	public final void setLongitude(final double longitude) {
		this.longitudeProperty().set(longitude);
	}
	

	public final StringProperty iplocationProperty() {
		return this.iplocation;
	}
	

	public final String getIplocation() {
		return this.iplocationProperty().get();
	}
	

	public final void setIplocation(final String iplocation) {
		this.iplocationProperty().set(iplocation);
	}
	

	public final StringProperty flagProperty() {
		return this.flag;
	}
	

	public final String getFlag() {
		return this.flagProperty().get();
	}
	

	public final void setFlag(final String flag) {
		this.flagProperty().set(flag);
	}
	

	public final StringProperty citystateProperty() {
		return this.citystate;
	}
	

	public final String getCitystate() {
		return this.citystateProperty().get();
	}
	

	public final void setCitystate(final String citystate) {
		this.citystateProperty().set(citystate);
	}
	

	public final StringProperty zipcodeProperty() {
		return this.zipcode;
	}
	

	public final String getZipcode() {
		return this.zipcodeProperty().get();
	}
	

	public final void setZipcode(final String zipcode) {
		this.zipcodeProperty().set(zipcode);
	}
	

	public final StringProperty languageProperty() {
		return this.language;
	}
	

	public final String getLanguage() {
		return this.languageProperty().get();
	}
	

	public final void setLanguage(final String language) {
		this.languageProperty().set(language);
	}
	

	public final StringProperty timezoneProperty() {
		return this.timezone;
	}
	

	public final String getTimezone() {
		return this.timezoneProperty().get();
	}
	

	public final void setTimezone(final String timezone) {
		this.timezoneProperty().set(timezone);
	}
	

	public final StringProperty callingcodeProperty() {
		return this.callingcode;
	}
	

	public final String getCallingcode() {
		return this.callingcodeProperty().get();
	}
	

	public final void setCallingcode(final String callingcode) {
		this.callingcodeProperty().set(callingcode);
	}
	

	public final StringProperty currencyProperty() {
		return this.currency;
	}
	

	public final String getCurrency() {
		return this.currencyProperty().get();
	}
	

	public final void setCurrency(final String currency) {
		this.currencyProperty().set(currency);
	}
	

	public final ObjectProperty<Image> flagImageProperty() {
		return this.flagImage;
	}
	

	public final Image getFlagImage() {
		return this.flagImageProperty().get();
	}
	

	public final void setFlagImage(final Image flagImage) {
		this.flagImageProperty().set(flagImage);
	}

}
