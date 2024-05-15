import DAOs.Conexao;
import Entidades.CartaHasDica;
import Entidades.CartaHasDicaPK;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCartaHasDica {
    public void inserir(CartaHasDica cartaHasDica) throws SQLException {
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO `perfil_junior`.`carta_has_dica` (`carta_id_carta`, `dica_id_dica`, `texto_dica`) VALUES (?, ?, ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cartaHasDica.getCartaHasDicaPK().getCartaIdCarta());
            preparedStatement.setInt(2, cartaHasDica.getCartaHasDicaPK().getDicaIdDica());
            preparedStatement.setString(3, cartaHasDica.getTexto_dica());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public void atualizar(CartaHasDica cartaHasDica) throws SQLException {
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE `perfil_junior`.`carta_has_dica` SET `texto_dica` = ? WHERE `carta_id_carta` = ? AND `dica_id_dica` = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cartaHasDica.getTexto_dica());
            preparedStatement.setInt(2, cartaHasDica.getCartaHasDicaPK().getCartaIdCarta());
            preparedStatement.setInt(3, cartaHasDica.getCartaHasDicaPK().getDicaIdDica());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public CartaHasDica buscarPorChave(CartaHasDicaPK chave) throws SQLException {
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM `perfil_junior`.`carta_has_dica` WHERE `carta_id_carta` = ? AND `dica_id_dica` = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, chave.getCartaIdCarta());
            preparedStatement.setInt(2, chave.getDicaIdDica());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                CartaHasDica cartaHasDica = new CartaHasDica();
                cartaHasDica.setCartaHasDicaPK(chave);
                cartaHasDica.setTexto_dica(resultSet.getString("texto_dica"));
                return cartaHasDica;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

        return null;
    }

    public List<CartaHasDica> buscarPorTexto_dica(String texto_dica) throws SQLException {
        List<CartaHasDica> cartas = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM `perfil_junior`.`carta_has_dica` WHERE `texto_dica` = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, texto_dica);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CartaHasDica cartaHasDica = new CartaHasDica();
                CartaHasDicaPK chave = new CartaHasDicaPK(resultSet.getInt("carta_id_carta"), resultSet.getInt("dica_id_dica"));
                cartaHasDica.setCartaHasDicaPK(chave);
                cartaHasDica.setTexto_dica(resultSet.getString("texto_dica"));
                cartas.add(cartaHasDica);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

        return cartas;
    }

    public void excluir(CartaHasDicaPK chave) throws SQLException {
        Connection connection = Conexao.getConnection();
        String sql = "DELETE FROM `perfil_junior`.`carta_has_dica` WHERE `carta_id_carta` = ? AND `dica_id_dica` = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, chave.getCartaIdCarta());
            preparedStatement.setInt(2, chave.getDicaIdDica());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
