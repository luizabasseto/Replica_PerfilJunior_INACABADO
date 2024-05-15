/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author luiza
 */
public class TelaInicioController {

    
      @FXML
    private Button btIniciarPartida;

    @FXML
    private Button btSalvar;

    @FXML
    private ComboBox<?> comboBoxJogador1;

    @FXML
    private ComboBox<?> comboBoxJogador2;

    @FXML
    void iniciarPartida(ActionEvent event) throws IOException {
        Parent climaParent = FXMLLoader.load(getClass().getResource("/Views/telaJogo.fxml"));
        Scene scene = new Scene(climaParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        System.out.println("PRint");
    }

    @FXML
    void liberarBTIniciar(ActionEvent event) {
        btIniciarPartida.setDisable(false);
    }
    
}
