package dad.geofx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dad.geofx.conexion.ConexionController;
import dad.geofx.map.CheckIP;
import dad.geofx.map.Ip;
import dad.geofx.seguridad.SeguridadController;
import dad.geofx.ubicacion.UbicacionController;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

	@FXML
	void onCheckIPAction(ActionEvent event) throws Exception {
		Task<CheckIP> getAPIDataTask = new Task<CheckIP>() {

			@Override
			protected CheckIP call() throws Exception {
				OkHttpClient client = new OkHttpClient();

				Request request = new Request.Builder().url("https://ipapi.com/ip_api.php?ip=" + ipText.getText()).get()
						.build();

				Response response = client.newCall(request).execute();

				String json = response.body().string();
				Gson gson = new GsonBuilder().create();

				CheckIP checkip = gson.fromJson(json, CheckIP.class);
				return checkip;
			}
		};

		getAPIDataTask.setOnSucceeded(e -> {
			try {
				UbicacionController.cambiarUbicacion(getAPIDataTask.get());
				ConexionController.cambiarConexion(getAPIDataTask.get());
				SeguridadController.cambiarSeguridad(getAPIDataTask.get());
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			} catch (ExecutionException ee) {
				ee.printStackTrace();
			}
		});

		getAPIDataTask.setOnFailed(e -> {
			getAPIDataTask.getException().printStackTrace();
		});

		new Thread(getAPIDataTask).start();
	}

	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Vista.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Task<Ip> getIp = new Task<Ip>() {

			@Override
			protected Ip call() throws Exception {
				OkHttpClient client = new OkHttpClient();

				Request request = new Request.Builder().url("https://api.ipify.org/?format=json").get().build();

				Response response = client.newCall(request).execute();

				String json = response.body().string();
				Gson gson = new GsonBuilder().create();

				Ip ip = gson.fromJson(json, Ip.class);
				return ip;
			}
		};

		getIp.setOnSucceeded(e -> {
			try {
				ipText.setText(getIp.get().getIp());
			} catch (InterruptedException | ExecutionException iee) {
				iee.printStackTrace();
			}
		});

		getIp.setOnFailed(e -> {
			getIp.getException().printStackTrace();
		});
		new Thread(getIp).start();

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
