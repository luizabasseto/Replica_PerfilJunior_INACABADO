package DAOs;


  import DAOs.Conexao;
import Entidades.Dicas_padrao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAODicas_padrao {
    // Método para inserir uma nova dicas_padrao no banco de dados
    public boolean inserir(Dicas_padrao dicas_padrao) {
        try {
            Connection connection = Conexao.getConnection();
            String sqlInsert = "INSERT INTO `perfil_junior`.`dicas_padrao` (`id_dicas_padrao`, `nome_dicas_padrao`) VALUES (?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setInt(1, dicas_padrao.getIdDicas_padrao());
            preparedStatement.setString(2, dicas_padrao.getNomeDicas_padrao());

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

    // Método para atualizar uma dicas_padrao no banco de dados
    public boolean atualizar(Dicas_padrao dicas_padrao) {
        try {
            Connection connection = Conexao.getConnection();
            String sqlUpdate = "UPDATE `perfil_junior`.`dicas_padrao` SET `nome_dicas_padrao` = ? WHERE `id_dicas_padrao` = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, dicas_padrao.getNomeDicas_padrao());
            preparedStatement.setInt(2, dicas_padrao.getIdDicas_padrao());

            int rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para buscar dicas_padraos com base em algum critério (exemplo: dicas_padrao_id_dicas_padrao)
    public List<Dicas_padrao> buscarPorId(int dicas_padraoId) {
        List<Dicas_padrao> dicas_padraos = new ArrayList<>();
        try {
            Connection connection = Conexao.getConnection();
            String sqlSelect = "SELECT * FROM `perfil_junior`.`dicas_padrao` WHERE `id_dicas_padrao` = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            preparedStatement.setInt(1, dicas_padraoId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Dicas_padrao dicas_padrao = new Dicas_padrao();
                dicas_padrao.setIdDicas_padrao(resultSet.getInt("id_dicas_padrao"));
                dicas_padrao.setNomeDicas_padrao(resultSet.getString("nome_dicas_padrao"));
                dicas_padraos.add(dicas_padrao);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dicas_padraos;
    }

    // Método para excluir uma dicas_padrao do banco de dados
    public boolean excluir(int dicas_padraoId) {
        try {
            Connection connection = Conexao.getConnection();
            String sqlDelete = "DELETE FROM `perfil_junior`.`dicas_padrao` WHERE `id_dicas_padrao` = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, dicas_padraoId);

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
  
