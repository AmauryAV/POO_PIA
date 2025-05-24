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

import java.util.*;

/*
public class HospitalPiaApplication {

	private static final Map<String, String> usuarios = new HashMap<>();
	private static final Map<String, String> roles = new HashMap<>();

	static {
		usuarios.put("enfermero1", "1234");
		usuarios.put("doctor1", "1234");
		usuarios.put("admin1", "1234");

		roles.put("enfermero1", "enfermero");
		roles.put("doctor1", "doctor");
		roles.put("admin1", "administrador");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===== Sistema de Hospital - Login =====");
		System.out.print("Usuario: ");
		String usuario = scanner.nextLine();
		System.out.print("Contraseña: ");
		String password = scanner.nextLine();

		if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(password)) {
			String rol = roles.get(usuario);
			System.out.println("Login exitoso como " + rol);
			mostrarMenuPorRol(rol, scanner);
		} else {
			System.out.println("Usuario o contraseña incorrectos.");
		}
	}

	private static void mostrarMenuPorRol(String rol, Scanner scanner) {
		switch (rol) {
			case "enfermero":
				menuEnfermero(scanner);
				break;
			case "doctor":
				menuDoctor(scanner);
				break;
			case "administrador":
				menuAdministrador(scanner);
				break;
		}
	}

	private static void menuEnfermero(Scanner scanner) {
		while(true) {
			System.out.println("Menú del Enfermero");
			System.out.println("1. Registrar paciente");
			System.out.println("2. Salir");
			System.out.print("Opcion: ");
			int opcion = scanner.nextInt();
			scanner.nextLine();
			if (opcion == 1) {
				System.out.println("Registro de paciente");

			}
			else if (opcion == 2) {
				System.out.println("Cerrando programa");
				break;
			}
			else {
				System.out.println("Opcion no valida.");
			}
		}
	}

	private static void menuDoctor(Scanner scanner) {
		System.out.println("Menú del Doctor");
		System.out.println("1. Consultar historial");
		System.out.println("2. Salir");
		int opcion = scanner.nextInt();
		scanner.nextLine();
		if (opcion == 1) {
		}
	}

	private static void menuAdministrador(Scanner scanner) {
		System.out.println("Menú del Administrador");
		System.out.println("1. Gestionar personal");
		System.out.println("2. Consultar defunciones");
		System.out.println("5. Salir");
		int opcion = scanner.nextInt();
		scanner.nextLine();
		if (opcion == 1) {
		}
	}


	public static void llenarCombo(ComboBox<String> llenarcombo, ObservableList<String> infocombo) {
		llenarcombo.setItems(infocombo);
	}
}

*/


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