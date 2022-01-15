package dad.geofx.conexion;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ConexionModel {
	
	private StringProperty asn = new SimpleStringProperty();
	private StringProperty hostname = new SimpleStringProperty();
	private StringProperty ipaddress = new SimpleStringProperty();
	private StringProperty isp = new SimpleStringProperty();
	private StringProperty type = new SimpleStringProperty();
	
	public final StringProperty hostnameProperty() {
		return this.hostname;
	}
	
	public final String getHostname() {
		return this.hostnameProperty().get();
	}
	
	public final void setHostname(final String hostname) {
		this.hostnameProperty().set(hostname);
	}
	
	public final StringProperty ipaddressProperty() {
		return this.ipaddress;
	}
	
	public final String getIpaddress() {
		return this.ipaddressProperty().get();
	}
	
	public final void setIpaddress(final String ipaddress) {
		this.ipaddressProperty().set(ipaddress);
	}
	
	public final StringProperty ispProperty() {
		return this.isp;
	}
	
	public final String getIsp() {
		return this.ispProperty().get();
	}
	
	public final void setIsp(final String isp) {
		this.ispProperty().set(isp);
	}
	
	public final StringProperty typeProperty() {
		return this.type;
	}
	
	public final String getType() {
		return this.typeProperty().get();
	}
	
	public final void setType(final String type) {
		this.typeProperty().set(type);
	}

	public final StringProperty asnProperty() {
		return this.asn;
	}

	public final String getAsn() {
		return this.asnProperty().get();
	}

	public final void setAsn(final String asn) {
		this.asnProperty().set(asn);
	}
	
}
