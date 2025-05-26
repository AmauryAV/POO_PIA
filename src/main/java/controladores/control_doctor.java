package controladores;

import javafx.scene.control.TabPane;
import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


@Component
public class control_doctor {

    @FXML
    private TabPane doc_men_inter;

    @FXML
    private AnchorPane panel_UCI;

    @FXML
    private AnchorPane panel_Pedia;

    @FXML
    private AnchorPane panel_Obste;

    @FXML
    private AnchorPane panel_Trauma;

    @FXML
    private AnchorPane panel_Onco;

    public void initialize() {
        doc_men_inter.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                switch (newValue.getText()){
                    case "Pediatria": cargar_camas("Pediatria", panel_Pedia);
                    case "UCI": cargar_camas("UCI", panel_UCI);
                    case "Oncologia": cargar_camas("Oncologia", panel_Onco);
                    case "Traumatologia": cargar_camas("Traumatologia", panel_Trauma);
                    case "Obstetricia": cargar_camas("Obstetricia", panel_Obste);
                }
            }
        });
        cargar_camas("UCI", panel_UCI);
    }


    public void cargar_camas(String area, AnchorPane pesta){
        try {
            FXMLLoader carga = new FXMLLoader(getClass().getResource("/Cama.fxml"));
            Parent root = carga.load();
            control_cama con_cama = carga.getController();
            con_cama.setArea(area);
            pesta.getChildren().setAll(root);
            AnchorPane.setTopAnchor(root, 0.0);
            AnchorPane.setLeftAnchor(root, 0.0);
            AnchorPane.setRightAnchor(root, 0.0);
            AnchorPane.setBottomAnchor(root, 0.0);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
