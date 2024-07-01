//Você precisa criar um programa que conecta ao banco de dados PostgreSQL e busque os dados da tabela `clientes`. Se a conexão com o banco de dados for bem-sucedida, deverá exibir os dados da tabela. Se a conexão falhar, deverá exibir uma mensagem de erro.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DatabaseConnectionException extends Exception {
    public DatabaseConnectionException(String message) {
        super(message);
    }
}

class SQLQueryException extends Exception {
    public SQLQueryException(String message) {
        super(message);
    }
}

public class Caso2 {

    public static void main(String[] args) {
        try {
            buscarDados();
        } catch (DatabaseConnectionException | SQLQueryException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void buscarDados() throws DatabaseConnectionException, SQLQueryException {
        String url = "jdbc:postgresql://localhost:5432/seubanco";
        String usuario = "seuusuario";
        String senha = "suasenha";

        Connection conexao = null;
        Statement stmt = null;

        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida com sucesso!");

            stmt = conexao.createStatement();
            String sql = "SELECT * FROM suatabela";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String nome = rs.getString("nome");
                System.out.println("Nome: " + nome);
            }

            rs.close();
        } catch (SQLException e) {
            if (conexao == null) {
                throw new DatabaseConnectionException("Falha na conexão com o banco de dados: " + e.getMessage());
            } else {
                throw new SQLQueryException("Erro na consulta SQL: " + e.getMessage());
            }
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
}