import DAOs.Conexao;
import Entidades.Carta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCarta {
    // Método para inserir uma nova carta no banco de dados
    public boolean inserir(Carta carta) {
        try {
            Connection connection = Conexao.getConnection();
            String sqlInsert = "INSERT INTO `perfil_junior`.`carta` (`id_carta`, `nome_carta`, `categoria_id_categoria`) VALUES (?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setInt(1, carta.getIdCarta());
            preparedStatement.setString(2, carta.getNomeCarta());
            preparedStatement.setInt(3, carta.getCategoriaIdCategoria());

            int rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para atualizar uma carta no banco de dados
    public boolean atualizar(Carta carta) {
        try {
            Connection connection = Conexao.getConnection();
            String sqlUpdate = "UPDATE `perfil_junior`.`carta` SET `nome_carta` = ?, `categoria_id_categoria` = ? WHERE `id_carta` = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, carta.getNomeCarta());
            preparedStatement.setInt(2, carta.getCategoriaIdCategoria());
            preparedStatement.setInt(3, carta.getIdCarta());

            int rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para buscar cartas com base em algum critério (exemplo: categoria_id_categoria)
    public List<Carta> buscarPorCategoria(int categoriaId) {
        List<Carta> cartas = new ArrayList<>();
        try {
            Connection connection = Conexao.getConnection();
            String sqlSelect = "SELECT * FROM `perfil_junior`.`carta` WHERE `categoria_id_categoria` = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            preparedStatement.setInt(1, categoriaId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Carta carta = new Carta();
                carta.setIdCarta(resultSet.getInt("id_carta"));
                carta.setNomeCarta(resultSet.getString("nome_carta"));
                carta.setCategoriaIdCategoria(resultSet.getInt("categoria_id_categoria"));
                cartas.add(carta);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartas;
    }

    // Método para excluir uma carta do banco de dados
    public boolean excluir(int cartaId) {
        try {
            Connection connection = Conexao.getConnection();
            String sqlDelete = "DELETE FROM `perfil_junior`.`carta` WHERE `id_carta` = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, cartaId);

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
