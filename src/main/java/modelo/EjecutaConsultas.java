package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EjecutaConsultas {

    private ConexionBD conexionBD;
    private ResultSet rs;
    private PreparedStatement enviaConsultaSeccion;
    private PreparedStatement enviaConsultaPais;
    private PreparedStatement enviaConsultaTodos;

    private final String consultaSeccion="SELECT NOMBRE, PRECIO, SECCION, " +
            "ORIGEN FROM PRODUCTOS WHERE SECCION =?";
    private final String consultaPais="SELECT NOMBRE, PRECIO, SECCION, " +
            "ORIGEN FROM PRODUCTOS WHERE ORIGEN=?";
    private final String consultaTodos="SELECT NOMBRE, PRECIO, SECCION, " +
            "ORIGEN FROM PRODUCTOS WHERE SECCION =? AND ORIGEN=?";



    public EjecutaConsultas() {
        conexionBD=new ConexionBD();
    }

    public ResultSet filtrarBBDD(String seccion, String pais){
       Connection connection = conexionBD.dameConexion();
        rs=null;
        try {
            if (!seccion.equalsIgnoreCase("Todos") && pais.equalsIgnoreCase("Todos")) {

                enviaConsultaSeccion=connection.prepareStatement(consultaSeccion);
                enviaConsultaSeccion.setString(1, seccion);
                rs=enviaConsultaSeccion.executeQuery();



            } else if (seccion.equalsIgnoreCase("Todos") && !pais.equalsIgnoreCase("Todos")) {
                enviaConsultaPais=connection.prepareStatement(consultaPais);
                enviaConsultaPais.setString(1, pais);
                rs=enviaConsultaPais.executeQuery();


            } else {

                enviaConsultaTodos=connection.prepareStatement(consultaTodos);
                enviaConsultaTodos.setString(1, seccion);
                enviaConsultaTodos.setString(2, pais);
                rs=enviaConsultaTodos.executeQuery();

            }

        }catch (Exception exception){

        }
        return rs;


    }

}
