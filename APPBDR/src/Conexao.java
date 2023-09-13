import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String USUARIO = "root";
    private static final String SENHA = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/sysbank";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";



    // Conecta ao banco e retorna a conexÃ£o
    public static Connection abrir() throws Exception {
        // Registra o driver
        Class.forName(DRIVER);
        // Abre a conexÃ£o


        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}