package DAOs;


  import DAOs.Conexao;
import Entidades.Dica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAODica {
    // Método para inserir uma nova dica no banco de dados
    public boolean inserir(Dica dica) {
        try {
            Connection connection = Conexao.getConnection();
            String sqlInsert = "INSERT INTO `perfil_junior`.`dica` (`id_dica`, `max_dica`) VALUES (?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setInt(1, dica.getIdDica());
            preparedStatement.setString(2, dica.getMaxDica());

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

    // Método para atualizar uma dica no banco de dados
    public boolean atualizar(Dica dica) {
        try {
            Connection connection = Conexao.getConnection();
            String sqlUpdate = "UPDATE `perfil_junior`.`dica` SET `max_dica` = ? WHERE `id_dica` = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, dica.getMaxDica());
            preparedStatement.setInt(2, dica.getIdDica());

            int rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para buscar dicas com base em algum critério (exemplo: dica_id_dica)
    public List<Dica> buscarPorId(int dicaId) {
        List<Dica> dicas = new ArrayList<>();
        try {
            Connection connection = Conexao.getConnection();
            String sqlSelect = "SELECT * FROM `perfil_junior`.`dica` WHERE `id_dica` = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            preparedStatement.setInt(1, dicaId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Dica dica = new Dica();
                dica.setIdDica(resultSet.getInt("id_dica"));
                dica.setMaxDica(resultSet.getString("max_dica"));
                dicas.add(dica);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dicas;
    }

    // Método para excluir uma dica do banco de dados
    public boolean excluir(int dicaId) {
        try {
            Connection connection = Conexao.getConnection();
            String sqlDelete = "DELETE FROM `perfil_junior`.`dica` WHERE `id_dica` = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, dicaId);

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
  
