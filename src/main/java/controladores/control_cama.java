package controladores;

import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


@Component
public class control_cama {
    @FXML
    private Label lbl_area;

    private String area;

    public void setArea(String area) {
        this.area = area;

        if (lbl_area != null) {
            lbl_area.setText("Área: " + area);
        }

    }

    @FXML
    public void initialize() {

        if (area != null && lbl_area != null) {
            lbl_area.setText("Área: " + area);
        }
    }
}
