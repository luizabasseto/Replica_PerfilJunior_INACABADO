/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
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
public class TelaPController {

    private Stage primaryStage;

    @FXML
    private Button btMenuCruds;

    @FXML
    private Button btiniciarJogo;

    @FXML
    void trocarTela2(ActionEvent event) throws IOException {
        Parent climaParent = FXMLLoader.load(getClass().getResource("/Views/telaInicio.fxml"));
        Scene scene = new Scene(climaParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        System.out.println("PRint");
    }

    @FXML
    void trocarTela3(ActionEvent event) throws IOException {
        Parent climaParent = FXMLLoader.load(getClass().getResource("/Views/telaMenuCruds.fxml"));
        Scene scene = new Scene(climaParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        System.out.println("PRint");
    }

}
