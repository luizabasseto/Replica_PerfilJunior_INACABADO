package Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaFinalController {

    @FXML
    private Button btMenuPrincipal;

    @FXML
    private Button btNovaPartida;

    @FXML
    private Button btSair;

    @FXML
    void SairTudo(ActionEvent event) {

    }

    @FXML
    void VoltarMenuPrincipal(ActionEvent event) throws IOException {
        Parent climaParent = FXMLLoader.load(getClass().getResource("/Views/telaP.fxml"));
        Scene scene = new Scene(climaParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        System.out.println("PRint");
    }

    @FXML
    void VoltarPartida(ActionEvent event) throws IOException {
        Parent climaParent = FXMLLoader.load(getClass().getResource("/Views/telaInicio.fxml"));
        Scene scene = new Scene(climaParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        System.out.println("PRint");
    }

}

