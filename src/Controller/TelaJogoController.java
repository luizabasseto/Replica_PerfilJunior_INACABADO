package Controller;

import java.util.Random;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

public class TelaJogoController {

    @FXML
    private Button btConferir;

    @FXML
    private Button btDica1;

    @FXML
    private Button btDica10;

    @FXML
    private Button btDica11;

    @FXML
    private Button btDica12;

    @FXML
    private Button btDica13;

    @FXML
    private Button btDica14;

    @FXML
    private Button btDica15;

    @FXML
    private Button btDica16;

    @FXML
    private Button btDica17;

    @FXML
    private Button btDica18;

    @FXML
    private Button btDica19;

    @FXML
    private Button btDica2;

    @FXML
    private Button btDica20;

    @FXML
    private Button btDica3;

    @FXML
    private Button btDica4;

    @FXML
    private Button btDica5;

    @FXML
    private Button btDica6;

    @FXML
    private Button btDica7;

    @FXML
    private Button btDica8;

    @FXML
    private Button btDica9;

    @FXML
    private Button btSortear;

    @FXML
    private ImageView imgAnimal;

    @FXML
    private ImageView imgCoisa;

    @FXML
    private ImageView imgJogador1;

    @FXML
    private ImageView imgJogador2;

    @FXML
    private ImageView imgLugar;

    @FXML
    private ImageView imgPessoa;

    @FXML
    private Label lbAnimal;

    @FXML
    private Label lbCoisa;

    @FXML
    private Label lbDicaEscolhida;

    @FXML
    private Label lbDicas;

    @FXML
    private Label lbLugar;

    @FXML
    private Label lbPessoa;

    @FXML
    private Label lbResposta;

    @FXML
    private Label lbRespostaResultado;

    @FXML
    private Label lbTema;

    @FXML
    private Label lbVezJogador;

    @FXML
    private TextField tfDicaEscolhida;

    @FXML
    private TextField tfResposta;

    @FXML
    void acao_dica1(ActionEvent event) {
        tfDicaEscolhida.setText("PERCA A SUA VEZ");
    }

    @FXML
    void acao_dica10(ActionEvent event) {

    }

    @FXML
    void acao_dica11(ActionEvent event) {

    }

    @FXML
    void acao_dica12(ActionEvent event) {

    }

    @FXML
    void acao_dica13(ActionEvent event) {

    }

    @FXML
    void acao_dica14(ActionEvent event) {

    }

    @FXML
    void acao_dica15(ActionEvent event) {

    }

    @FXML
    void acao_dica16(ActionEvent event) {

    }

    @FXML
    void acao_dica17(ActionEvent event) {

    }

    @FXML
    void acao_dica18(ActionEvent event) {

    }

    @FXML
    void acao_dica19(ActionEvent event) {

    }

    @FXML
    void acao_dica2(ActionEvent event) {

    }

    @FXML
    void acao_dica20(ActionEvent event) {

    }

    @FXML
    void acao_dica3(ActionEvent event) {

    }

    @FXML
    void acao_dica4(ActionEvent event) {

    }

    @FXML
    void acao_dica5(ActionEvent event) {

    }

    @FXML
    void acao_dica6(ActionEvent event) {

    }

    @FXML
    void acao_dica7(ActionEvent event) {
        tfDicaEscolhida.setText("WWWWWWWWWWWWWWWWWWWWWW");

    }

    @FXML
    void acao_dica8(ActionEvent event) {
        tfDicaEscolhida.setText("SSSSSSSSSSSSSSSSSSSSSS");

    }

    @FXML
    void acao_dica9(ActionEvent event) {
        tfDicaEscolhida.setText("AAAAAAAAAAAAAAA");

    }

    @FXML
    void conferirResposta(ActionEvent event) {
        lbRespostaResultado.setText("Resposta: CORRETA!");
    }

    @FXML
    void sortearCarta(ActionEvent event) {
        String[] opcoes = {"Animal", "Pessoa/Personagem", "Lugar", "Coisa"};
        Random random = new Random();
        int numeroAleatorio = random.nextInt(4);
        String opcaoEscolhida = opcoes[numeroAleatorio];
        lbTema.setText("Tema: " + opcaoEscolhida);
//        String jogador1 = "Alice";
//        String jogador2 = "Bob";
//        String jogadorAtual = jogador1; // Começa com o jogador1
//
//        Scanner scanner = new Scanner(System.in);
//
//
//        if (jogadorAtual.equals(jogador1)) {
//            jogadorAtual = jogador2;
//        } else {
//            jogadorAtual = jogador1;
//
//        }
//        lbVezJogador.setText("Vez de: " + jogadorAtual);

    }

}
