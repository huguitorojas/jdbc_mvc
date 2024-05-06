package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CargaMenu {
    ConexionBD miConexion;
    ResultSet rs;
    ResultSet rs2;

    public CargaMenu() {
        miConexion = new ConexionBD();
    }

    public String ejecutaConsultas() {
        Productos miProducto = null;
        Connection accesoBBDD = miConexion.dameConexion();
        try {
            Statement secciones = accesoBBDD.createStatement();
            Statement paises = accesoBBDD.createStatement();
            rs = secciones.executeQuery("SELECT DISTINCTROW SECCION FROM PRODUCTOS");
            rs2 = paises.executeQuery("SELECT DISTINCTROW ORIGEN FROM PRODUCTOS");

            miProducto = new Productos();
            miProducto.setSeccion(rs.getString(1));
            miProducto.setOrigen(rs2.getString(1));

            rs.close();
            rs2.close();
            accesoBBDD.close();

        } catch (Exception e) {
        }

            return miProducto.getSeccion();

    }

    public ResultSet getRs() {
        return rs;
    }

    public ResultSet getRs2() {
        return rs2;
    }
}
