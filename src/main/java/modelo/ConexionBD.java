package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private Connection miConexion = null;

    public Connection dameConexion(){
        try {
            miConexion= DriverManager.getConnection("jdbc:mysql://localhost/pruebas", "root","root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return miConexion;
    }

}
