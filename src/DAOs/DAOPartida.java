import DAOs.Conexao;
import Entidades.Partida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOPartida {
    public void inserir(Partida partida) throws SQLException {
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO `perfil_junior`.`partida` (`id_partida`, `data_partida`) VALUES (?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, partida.getIdPartida());
            preparedStatement.setTimestamp(2, partida.getDataPartida());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public void atualizar(Partida partida) throws SQLException {
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE `perfil_junior`.`partida` SET `data_partida` = ? WHERE `id_partida` = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, partida.getDataPartida());
            preparedStatement.setInt(2, partida.getIdPartida());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public Partida buscarPorId(int idPartida) throws SQLException {
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM `perfil_junior`.`partida` WHERE `id_partida` = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idPartida);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Partida partida = new Partida();
                partida.setIdPartida(resultSet.getInt("id_partida"));
                partida.setDataPartida(resultSet.getTimestamp("data_partida"));
                return partida;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

        return null;
    }

    public List<Partida> buscarTodas() throws SQLException {
        List<Partida> partidas = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM `perfil_junior`.`partida`;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Partida partida = new Partida();
                partida.setIdPartida(resultSet.getInt("id_partida"));
                partida.setDataPartida(resultSet.getTimestamp("data_partida"));
                partidas.add(partida);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

        return partidas;
    }

    public void excluir(int idPartida) throws SQLException {
        Connection connection = Conexao.getConnection();
        String sql = "DELETE FROM `perfil_junior`.`partida` WHERE `id_partida` = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idPartida);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
