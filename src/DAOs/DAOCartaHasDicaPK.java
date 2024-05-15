import DAOs.Conexao;
import Entidades.CartaHasDicaPK;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOCartaHasDicaPK {
    public CartaHasDicaPK buscarPorPK(int cartaIdCarta, int dicaIdDica) throws SQLException {
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM `perfil_junior`.`carta_has_dica` WHERE `carta_id_carta` = ? AND `dica_id_dica` = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cartaIdCarta);
            preparedStatement.setInt(2, dicaIdDica);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                CartaHasDicaPK chave = new CartaHasDicaPK();
                chave.setCartaIdCarta(resultSet.getInt("carta_id_carta"));
                chave.setDicaIdDica(resultSet.getInt("dica_id_dica"));
                return chave;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

        return null;
    }

    // Você pode adicionar métodos para inserção, atualização e exclusão se necessário,
    // mas, geralmente, uma chave primária incorporada não precisa dessas operações.
}
