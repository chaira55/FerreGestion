package ferregestion.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    //configuracion de la base de datos railway
    private static final String url = "jdbc:mysql://hopper.proxy.rlwy.net:23625/railway";
    private static final String user = "root";
    private static final String password = "CFeyVJvedVqTAVCSCyRMpGIyIweExxlU";

    //metodo para obtener una conexion
    public static Connection getConexionBD() {
        Connection conexion = null;
        try {
            //conexion a la bd
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return conexion;
    }

    //metodo de prueba de conexion
    public static void main(String[] args) {
        Connection conexion = getConexionBD();
        if (conexion != null) {
            System.out.println("La conexión está activa: " + conexion);
            try {
                conexion.close(); // cerramos después de usar
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }
}