package Servicios;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBDRecogidas {

    private static final Dotenv dotenv = Dotenv.load();

    private static final String DATABASE = dotenv.get("POSTGRES_DATABASE");
    private static final String HOST = dotenv.get("POSTGRES_HOST", dotenv.get("POSTGRES_HOST_ALT"));
    private static final String USER = dotenv.get("POSTGRES_USER");
    private static final String PASSWORD = dotenv.get("POSTGRES_PASS");
    private static final String PORT = dotenv.get("PG_PORT");

    private static final String URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


    public static int guiaExiste(Integer numeroGuia) {
        int cantidad = 0;
        String query = "SELECT COUNT(guia) AS total FROM recogidas.levante_uxu WHERE id_recogida = '" + numeroGuia + "'";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                cantidad = rs.getInt("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cantidad;
    }

}
