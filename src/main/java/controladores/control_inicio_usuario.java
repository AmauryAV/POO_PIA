package controladores;


import com.example.hospital_pia.Repository;
import com.example.hospital_pia.usuario;
import enums.Tipo_usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;



@Component
public class control_inicio_usuario implements Initializable {
    @Autowired
    private Repository repo;

    @FXML
    public ComboBox cbRol;

    @FXML
    public Label usuariotxt;

    @FXML
    public Label contrasenatxt;

    @FXML
    public TextField rellenar_ususario;

    @FXML
    public Button aceptarBoton;

    @FXML
    public Button cancelarbotton;

    @FXML
    public PasswordField rellenar_contra;

    @FXML
    public Label tipo_ususariotxt;

/*Metodo con la funcion de impedir el uso de espacios al llenar la contraseña y el usuario, no funciono*/
    @FXML
    private void eventKey(KeyEvent event) {
        Object source = event.getSource();
        String text = event.getCharacter();
        if (" ".equals(text)) {
            if (source.equals(rellenar_ususario) || source.equals(rellenar_contra)) {
                event.consume();
            }
        }

    }

    @FXML
    public void aceptarBoton(ActionEvent event) throws IOException {
        String usuario1 = rellenar_ususario.getText();
        String contra1 = rellenar_contra.getText();
        String tipo1 = cbRol.getSelectionModel().getSelectedItem().toString();
        Tipo_usuario tipo2 = Tipo_usuario.valueOf(tipo1);

        if (!usuario1.isEmpty() && !contra1.isEmpty() && tipo1 != null) {
            Optional<usuario> verificacion = repo.findByNombreAndContraAndTipo(usuario1, contra1, tipo2);
            if (verificacion.isPresent()) {
                usuario ususario_activo = verificacion.get();
                System.out.println("Inicio de sesion verificado");
                Stage menu_actual = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                if (ususario_activo.getTipo() == Tipo_usuario.Administrador){
                    loader.setLocation(getClass().getResource("/Administrador.fxml"));
                }
                else if (ususario_activo.getTipo() == Tipo_usuario.Medico){
                    loader.setLocation(getClass().getResource("/Doctor.fxml"));
                }
                else if (ususario_activo.getTipo() == Tipo_usuario.Enfermero){
                    loader.setLocation(getClass().getResource("/Enfermero.fxml"));
                }
                Parent root = loader.load();
                Scene scene = new Scene(root);
                menu_actual.setScene(scene);
                menu_actual.show();

            }
        }
    }


    //String usuario, password;

    ObservableList<String> roles = FXCollections.observableArrayList("Administrador", "Enfermero", "Medico");

    public void listarRoles(Event event) {
        llenarCombo(cbRol, roles );
    }

    public static void llenarCombo(ComboBox<String> llenarcombo, ObservableList<String> infocombo) {
        llenarcombo.setItems(infocombo);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rellenar_ususario.setTextFormatter(new TextFormatter<String>(change -> {
            return change.getText().contains(" ") ? null : change;
        }));

        rellenar_contra.setTextFormatter(new TextFormatter<String>(change -> {
            return change.getText().contains(" ") ? null : change;
        }));

    }
}


/*
        if (source.equals(rellenar_ususario)) {
            if (event.getCharacter().equals(' ')){
                event.consume();
            }
        }
        else if (source.equals(rellenar_contra)) {
            if(event.getCharacter().equals(' ')){
                event.consume();
            }
        }

         */