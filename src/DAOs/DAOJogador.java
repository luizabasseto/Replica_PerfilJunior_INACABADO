package DAOs;


  import DAOs.Conexao;
import Entidades.Jogador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOJogador {
    // Método para inserir uma nova jogador no banco de dados
    public boolean inserir(Jogador jogador) {
        try {
            Connection connection = Conexao.getConnection();
            String sqlInsert = "INSERT INTO `perfil_junior`.`jogador` (`id_jogador`, `nome_jogador`) VALUES (?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setInt(1, jogador.getIdJogador());
            preparedStatement.setString(2, jogador.getNomeJogador());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("DEU CERTO");

            preparedStatement.close();
            connection.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para atualizar uma jogador no banco de dados
    public boolean atualizar(Jogador jogador) {
        try {
            Connection connection = Conexao.getConnection();
            String sqlUpdate = "UPDATE `perfil_junior`.`jogador` SET `nome_jogador` = ? WHERE `id_jogador` = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, jogador.getNomeJogador());
            preparedStatement.setInt(2, jogador.getIdJogador());

            int rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para buscar jogadors com base em algum critério (exemplo: jogador_id_jogador)
    public List<Jogador> buscarPorId(int jogadorId) {
        List<Jogador> jogadors = new ArrayList<>();
        try {
            Connection connection = Conexao.getConnection();
            String sqlSelect = "SELECT * FROM `perfil_junior`.`jogador` WHERE `id_jogador` = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            preparedStatement.setInt(1, jogadorId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Jogador jogador = new Jogador();
                jogador.setIdJogador(resultSet.getInt("id_jogador"));
                jogador.setNomeJogador(resultSet.getString("nome_jogador"));
                jogadors.add(jogador);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jogadors;
    }

    // Método para excluir uma jogador do banco de dados
    public boolean excluir(int jogadorId) {
        try {
            Connection connection = Conexao.getConnection();
            String sqlDelete = "DELETE FROM `perfil_junior`.`jogador` WHERE `id_jogador` = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, jogadorId);

            int rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
  
