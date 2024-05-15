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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author luiza
 */
public class TelaMenuCrudsController {
    
     @FXML
    private Button btCrudCarta;

    @FXML
    private Button btCrudCategoria;

    @FXML
    private Button btCrudDica;

    @FXML
    private Button btCrudJogador;

    @FXML
    private Button btCrud_has_Dica;

    @FXML
    private Button btVoltarMenuPrincipal;

    @FXML
    void AbrirCrudCarta(ActionEvent event) throws IOException {
        Parent climaParent = FXMLLoader.load(getClass().getResource("/Views/telaP.fxml"));
        Scene scene = new Scene(climaParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        System.out.println("PRint");
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
    void abrirCrudCategoria(ActionEvent event) {

    }

    @FXML
    void abrirCrudDica(ActionEvent event) {

    }

    @FXML
    void abrirCrudJogador(ActionEvent event) {

    }

    @FXML
    void abrirCrud_has_Dica(ActionEvent event) {

    }
    
}
