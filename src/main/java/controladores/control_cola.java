package controladores;

import com.example.hospital_pia.cola_prioridad;
import com.example.hospital_pia.hospital;
import com.example.hospital_pia.registro_paciente;
import enums.Triaje;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

@Component
public class control_cola implements Initializable {

    @FXML
    public Pane panel_cola;

    @FXML
    public TableView<registro_paciente> tabla_cola;

    @FXML
    public TableColumn<registro_paciente, Triaje> columna_triaje;

    @FXML
    public TableColumn<registro_paciente, String> columna_sintomas;

    @FXML
    public TableColumn<registro_paciente, String> columna_signos;

    @FXML
    public TableColumn<registro_paciente, LocalDateTime> columna_hora;

    @FXML
    private Label lbl_area;

    private cola_prioridad cola = new cola_prioridad();
    private ObservableList<registro_paciente> registros = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columna_triaje.setCellValueFactory(new PropertyValueFactory<>("triaje"));
        columna_sintomas.setCellValueFactory(new PropertyValueFactory<>("sintomas"));
        columna_signos.setCellValueFactory(new PropertyValueFactory<>("signos"));
        columna_hora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        tabla_cola.setItems(registros);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                actualizarTabla();
            }
        }, 0, 1000);
    }

    public void actualizarTabla() {
        List<registro_paciente> listaOrdenada;
        synchronized (cola.turnos){
            listaOrdenada = cola.turnos.stream().sorted().collect(Collectors.toList());
        }
        javafx.application.Platform.runLater(()->{registros.setAll(listaOrdenada);});
    }

    public void agregar_paciente(registro_paciente pac, hospital hosp) {
        cola.agregarRegistro(pac, hosp);
        actualizarTabla();
    }

    public void sacar_paciente() {
        cola.desencolarRegistro();
        actualizarTabla();
    }

    private String area;

    public void setArea(String area) {
        this.area = area;

        if (lbl_area != null) {
            lbl_area.setText("area: " + area);
        }

    }

}
