package zona_fit.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConnection() {

        Connection conn = null;
        var db = "zona_fit_db";
        var url = "jdbc:mysql://localhost:3306/" + db;
        var user = "root";
        var pass = "$SutFRVvpjlsLrop*5Q3i$ncO$#8zpz8S&!x53Cjny@TWWlOj4";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos " + e.getMessage());
        }
        return conn;
    }

    public static void main() {
        var conn = Conexion.getConnection();
        if (conn != null) {
            System.out.println("Conexion establecida con la base de datos" + conn);
        }else  {
            System.out.println("Error al conectar con la base de datos");
        }
    }
}
