package controladores;

import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import org.springframework.stereotype.Component;

import static com.example.hospital_pia.HospitalPiaApplication.llenarCombo;

@Component
public class control_inicio_usuario {
    public ComboBox cbRol;
    public Label usuariotxt;
    public Label contrasenatxt;
    public TextField rellenar_ususario;
    public Button aceptarBoton;
    public Button cancelarbotton;
    public PasswordField rellenar_contra;
    public Label tipo_ususariotxt;

    String usuario, password;

    ObservableList<String> roles = FXCollections.observableArrayList("Administrador", "Enfermero", "Medico");

    public void listarRoles(Event event) {
        llenarCombo(cbRol, roles );
    }

    public void clicEntrar(ActionEvent actionEvent) {
        usuario = rellenar_ususario.getText();
        password = rellenar_contra.getText();
        if (usuario == "Jose" && password == "entrar") {
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Iniciando cesisión");
            mensaje.setHeaderText(null);
            mensaje.setContentText("Iniciando cuenta de adminsitrador");
        }
        else if (usuario == "Maria" && password == "salir") {
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Iniciando cesisión");
            mensaje.setHeaderText(null);
            mensaje.setContentText("Iniciando cuenta de doctor");
        }
        else if (usuario == "Jesus" && password == "entrar") {
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Iniciando cesisión");
            mensaje.setHeaderText(null);
            mensaje.setContentText("Iniciando cuenta de enfermero");
        }
    }
}
