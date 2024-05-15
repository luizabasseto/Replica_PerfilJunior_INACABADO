
import DAOs.Conexao; // Certifique-se de que a classe Conexao está no pacote correto
import DAOs.DAOCategoria;
import Entidades.Categoria;
import java.sql.Connection;
import java.sql.SQLException;

public class MainApp {

    public static void main(String[] args) {
        try {
            Connection connection = Conexao.getConnection();

//            //INSERIR
//            String sqll = "INSERT INTO `perfil_junior`.`carta` (`id_carta`, `nome_carta`, `categoria_id_categoria`) VALUES ('216', 'casa', '2');";
//            PreparedStatement preparedStatement = connection.prepareStatement(sqll);
//
//            int rowsAffected = preparedStatement.executeUpdate();
//
//            if (rowsAffected > 0) {
//                System.out.println("Inserção bem-sucedida.");
//            } else {
//                System.out.println("Nenhuma linha inserida.");
//            }
//
//            //LISTAR
//            String sql = "SELECT * FROM carta";
//            preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                // Processar os resultados aqui
//                int id = resultSet.getInt("id_carta");
//                String nome = resultSet.getString("nome_carta");
//                System.out.println(id + "--> " + nome);
//
//            }
//
//            //UPTADE
//            String sqlUpdate = "UPDATE `perfil_junior`.`carta` SET `nome_carta` = 'novo_nome' WHERE `id_carta` = '216';";
//
//            preparedStatement = connection.prepareStatement(sqlUpdate);
//
//             rowsAffected = preparedStatement.executeUpdate();
//
//            if (rowsAffected > 0) {
//                System.out.println("Atualização bem-sucedida.");
//            } else {
//                System.out.println("Nenhuma linha atualizada. Verifique se o registro com `id_carta` 216 existe.");
//            }
//            
//            //DELETE
//            
//            String sqlDelete = "DELETE FROM `perfil_junior`.`carta` WHERE `id_carta` = '216';";
//
//             preparedStatement = connection.prepareStatement(sqlDelete);
//
//             rowsAffected = preparedStatement.executeUpdate();
//
//            if (rowsAffected > 0) {
//                System.out.println("Exclusão bem-sucedida.");
//            } else {
//                System.out.println("Nenhuma linha excluída. Verifique se o registro com `id_carta` 216 existe.");
//            }
//            
//            // BUSCAR
//            
//            String sqlSelect = "SELECT * FROM `perfil_junior`.`carta` WHERE `categoria_id_categoria` = '2';";
//
//             preparedStatement = connection.prepareStatement(sqlSelect);
//
//             resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id_carta");
//                String nome = resultSet.getString("nome_carta");
//                int categoriaId = resultSet.getInt("categoria_id_categoria");
//
//                System.out.println("ID: " + id);
//                System.out.println("Nome: " + nome);
//                System.out.println("ID da Categoria: " + categoriaId);
//                System.out.println("============================");
//            }


            // Fechar recursos
//            preparedStatement.close();
            Categoria categoria = new Categoria();
            DAOCategoria daoCategoria = new DAOCategoria();
            daoCategoria.excluir(5);
            daoCategoria.buscarPorId(5);
           categoria.setIdCategoria(4);
            categoria.setNomeCategoria("pessoa/personagem");
            daoCategoria.atualizar(categoria);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
