package controlador;

import modelo.EjecutaConsultas;
import vista.MarcoAplicacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ControladorBotonEjecuta implements ActionListener {

    private MarcoAplicacion marco;
    private EjecutaConsultas  consultas =new EjecutaConsultas();
    private ResultSet resultadoConsulta;

    public ControladorBotonEjecuta(MarcoAplicacion marco) {
        this.marco = marco;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String seleccionSeccion = (String) marco.getSecciones().getSelectedItem();
        String seleccionPais = (String) marco.getPaises().getSelectedItem();

        resultadoConsulta=consultas.filtrarBBDD(seleccionSeccion, seleccionPais);
        try {
            marco.getResultado().setText("");
            while (resultadoConsulta.next()) {
                marco.getResultado().append(resultadoConsulta.getString("nombre"));
                marco.getResultado().append("\t");
                marco.getResultado().append(resultadoConsulta.getString("precio"));
                marco.getResultado().append("\t");
                marco.getResultado().append(resultadoConsulta.getString("seccion"));
                marco.getResultado().append("\t");
                marco.getResultado().append(resultadoConsulta.getString("origen"));
                marco.getResultado().append("\n");


            }
        }catch (Exception exception){

        }



    }
}
