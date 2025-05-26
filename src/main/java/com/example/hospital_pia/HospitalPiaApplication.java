package com.example.hospital_pia;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;


@SpringBootApplication(scanBasePackages = {"com.example.hospital_pia", "controladores"})
public class HospitalPiaApplication extends Application {
	public static ConfigurableApplicationContext context;
	public static void main(String[] args) {
		launch();
		//SpringApplication.run(HospitalPiaApplication.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		context  = SpringApplication.run(HospitalPiaApplication.class);
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("/Inicio_usuario.fxml"));
		fxml.setControllerFactory(context::getBean);

		Scene scene = new Scene(fxml.load());
		stage.setTitle("Hospital Pia");
		stage.setScene(scene);
		stage.show();
	}
}


/*
@SpringBootApplication
public class HospitalPiaApplication extends Application {

	public static void main(String[] args) {
		System.out.println("Spring Book iniciado del Hospital Pia");
		//SpringApplication.run(HospitalPiaApplication.class, args);
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		var context = SpringApplication.run(HospitalPiaApplication.class);
		//var fxml = new FXMLLoader(getClass().getResource("/Main.fxml"));
		var fxml = new FXMLLoader(getClass().getResource("/Inicio_usuario.fxml"));
		var scene = new Scene(fxml.load());
		stage.setTitle("Hospital PIA SA de CV");
		stage.setScene(scene);
		stage.show();

	}

	public static void llenarCombo(ComboBox<String> llenarcombo, ObservableList<String> infocombo) {
		llenarcombo.setItems(infocombo);
	}
}

*/
/*
public class Main extends Application{

	public static void main(String[] args) {
		lounch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/Inicio_usuario.fxml"));
		primaryStage.setScene(new Scene(root));
	}
}
*/