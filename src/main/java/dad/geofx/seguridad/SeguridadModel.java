package dad.geofx.seguridad;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SeguridadModel {

	private BooleanProperty proxy = new SimpleBooleanProperty();
	private BooleanProperty tor = new SimpleBooleanProperty();
	private BooleanProperty crawler = new SimpleBooleanProperty();
	private StringProperty shield = new SimpleStringProperty();
	private StringProperty threat = new SimpleStringProperty();
	private StringProperty potential = new SimpleStringProperty();

	public final BooleanProperty proxyProperty() {
		return this.proxy;
	}

	public final boolean isProxy() {
		return this.proxyProperty().get();
	}

	public final void setProxy(final boolean proxy) {
		this.proxyProperty().set(proxy);
	}

	public final BooleanProperty torProperty() {
		return this.tor;
	}

	public final boolean isTor() {
		return this.torProperty().get();
	}

	public final void setTor(final boolean tor) {
		this.torProperty().set(tor);
	}

	public final BooleanProperty crawlerProperty() {
		return this.crawler;
	}

	public final boolean isCrawler() {
		return this.crawlerProperty().get();
	}

	public final void setCrawler(final boolean crawler) {
		this.crawlerProperty().set(crawler);
	}

	public final StringProperty shieldProperty() {
		return this.shield;
	}

	public final String getShield() {
		return this.shieldProperty().get();
	}

	public final void setShield(final String shield) {
		this.shieldProperty().set(shield);
	}

	public final StringProperty threatProperty() {
		return this.threat;
	}

	public final String getThreat() {
		return this.threatProperty().get();
	}

	public final void setThreat(final String threat) {
		this.threatProperty().set(threat);
	}

	public final StringProperty potentialProperty() {
		return this.potential;
	}

	public final String getPotential() {
		return this.potentialProperty().get();
	}

	public final void setPotential(final String potential) {
		this.potentialProperty().set(potential);
	}

}
