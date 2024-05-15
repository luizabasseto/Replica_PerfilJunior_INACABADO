package DAOs;


  import DAOs.Conexao;
import Entidades.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCategoria {
    // Método para inserir uma nova categoria no banco de dados
    public boolean inserir(Categoria categoria) {
        try {
            Connection connection = Conexao.getConnection();
            String sqlInsert = "INSERT INTO `perfil_junior`.`categoria` (`id_categoria`, `nome_categoria`) VALUES (?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setInt(1, categoria.getIdCategoria());
            preparedStatement.setString(2, categoria.getNomeCategoria());

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

    // Método para atualizar uma categoria no banco de dados
    public boolean atualizar(Categoria categoria) {
        try {
            Connection connection = Conexao.getConnection();
            String sqlUpdate = "UPDATE `perfil_junior`.`categoria` SET `nome_categoria` = ? WHERE `id_categoria` = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, categoria.getNomeCategoria());
            preparedStatement.setInt(2, categoria.getIdCategoria());

            int rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para buscar categorias com base em algum critério (exemplo: categoria_id_categoria)
    public List<Categoria> buscarPorId(int categoriaId) {
        List<Categoria> categorias = new ArrayList<>();
        try {
            Connection connection = Conexao.getConnection();
            String sqlSelect = "SELECT * FROM `perfil_junior`.`categoria` WHERE `id_categoria` = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            preparedStatement.setInt(1, categoriaId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(resultSet.getInt("id_categoria"));
                categoria.setNomeCategoria(resultSet.getString("nome_categoria"));
                categorias.add(categoria);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categorias;
    }

    // Método para excluir uma categoria do banco de dados
    public boolean excluir(int categoriaId) {
        try {
            Connection connection = Conexao.getConnection();
            String sqlDelete = "DELETE FROM `perfil_junior`.`categoria` WHERE `id_categoria` = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, categoriaId);

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
  
