package controladores;

import com.example.hospital_pia.*;
import enums.Triaje;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

@Component
public class control_enfermero implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargar_cola("Cola de pacientes", panel_cola_pacientes);
    }

    @Autowired
    private Repository_registro_paciente rep_reg_paciente;

    @Autowired
    private Repository_enfermero rep_enfermero;

    @Autowired
    private Repository_pasiente rep_pasiente;

    @Autowired
    private hospital hospitalGlobal;

    @FXML
    TabPane enfermero_menu;

    @FXML
    Tab pestana_cola;

    @FXML
    public TextField ingre_nombre;

    @FXML
    public TextField ingre_ape_pate;

    @FXML
    public TextField ingre_ape_mate;

    @FXML
    public TextField ingre_direcc;

    @FXML
    public TextField ingre_tele;

    @FXML
    public TextField ingre_correo;

    @FXML
    public TextField ingre_edad;

    @FXML
    public TextField ingre_peso;

    @FXML
    public TextField ingre_altura;

    @FXML
    public Label txt_sexo;

    @FXML
    public Label txt_triaje;

    @FXML
    public AnchorPane panel_cola_pacientes;

    @FXML
    public TextField ingre_alergia;

    @FXML
    public TextField ingre_sintomas;

    @FXML
    public TextField ingre_signos_vita;

    @FXML
    public ComboBox opcio_sexo;

    @FXML
    public ComboBox opcio_sangre;

    @FXML
    public ComboBox opcio_triaje;

    @FXML
    public Button boton_guardar_registro;

    ObservableList<String> sexos = FXCollections.observableArrayList("Hombre", "Mujer");

    ObservableList<String> tipos_sangre = FXCollections.observableArrayList("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");

    ObservableList<String> op_triaje = FXCollections.observableArrayList("Rojo", "Naranja", "Amarillo", "Verde", "Azul");

    public void listar_sexos(Event event) {
        llenar_combo(opcio_sexo, sexos);
    }

    public void listar_tipo_sangre(Event event) {
        llenar_combo(opcio_sangre, tipos_sangre);
    }

    public void listar_opcio_triaje(Event event) {
        llenar_combo(opcio_triaje, op_triaje);
    }

    public static void llenar_combo(ComboBox<String> combo, ObservableList<String> infocombo) {
        combo.setItems(infocombo);
    }

    public void crear_registro(ActionEvent event) throws IOException {
        personal usuarioActibo = usuarioActivo.getPersona();
        Integer id = usuarioActibo.getUsuario().getId();
        String nombre = ingre_nombre.getText();
        String ape_pate = ingre_ape_pate.getText();
        String ape_mate = ingre_ape_mate.getText();
        String direcc = ingre_direcc.getText();
        String tele = ingre_tele.getText();
        String correo = ingre_correo.getText();
        String edad = ingre_edad.getText();
        int edad_valida = Integer.parseInt(edad);
        String peso = ingre_peso.getText();
        float peso_valido = Float.parseFloat(peso);
        String altura = ingre_altura.getText();
        float altura_valida = Float.parseFloat(altura);
        String alergia = ingre_alergia.getText();
        String sexo = opcio_sexo.getSelectionModel().getSelectedItem().toString();
        String sangre = opcio_sangre.getSelectionModel().getSelectedItem().toString();
        String triaje = opcio_triaje.getSelectionModel().getSelectedItem().toString();
        String sintomas = ingre_sintomas.getText();
        String signo_vita = ingre_signos_vita.getText();
        Triaje triaje_valido = Triaje.valueOf(triaje);
        registro_paciente nuevo_regis = new registro_paciente(nombre, ape_pate, ape_mate,
                direcc, tele, correo, edad_valida, sexo, sangre, alergia, sintomas, signo_vita, triaje_valido
                , id,peso_valido, altura_valida);
        Optional<registro_paciente> verificacion = rep_reg_paciente.findByNombrepacienteAndApellidopaternopacienteAndApellidomaternopaciente(nombre, ape_pate, ape_mate);
        if (!verificacion.isPresent()) {
            paciente nuevo_paciente = new paciente(nuevo_regis);
            rep_pasiente.save(nuevo_paciente);
        }
        rep_reg_paciente.save(nuevo_regis);

        //hospital hpt = usuarioActivo.getHospital();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Cola.fxml"));
        Parent root = loader.load();
        control_cola controlCola = loader.getController();
        controlCola.agregar_paciente(nuevo_regis, hospitalGlobal);
    }

    public void cargar_cola(String area, AnchorPane pesta){
        try{
            FXMLLoader carga = new FXMLLoader(getClass().getResource("/Cola.fxml"));
            Parent root = carga.load();
            control_cola cc = carga.getController();
            cc.setArea(area);
            pesta.getChildren().setAll(root);
            AnchorPane.setTopAnchor(root, 0.0);
            AnchorPane.setLeftAnchor(root, 0.0);
            AnchorPane.setRightAnchor(root, 0.0);
            AnchorPane.setBottomAnchor(root, 0.0);

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
