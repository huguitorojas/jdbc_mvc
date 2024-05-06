package controlador;

import modelo.CargaMenu;
import vista.MarcoAplicacion;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControladorCargaMenu extends WindowAdapter {

    public ControladorCargaMenu(MarcoAplicacion marco) {
        this.marco=marco;
    }

    @Override
    public void windowOpened(WindowEvent e) {

        cargaSecciones.ejecutaConsultas();
        try {
            while (cargaSecciones.getRs().next()) {

                marco.getSecciones().addItem(cargaSecciones.getRs().getString(1));
             }
            while (cargaSecciones.getRs2().next()){
                marco.getPaises().addItem(cargaSecciones.getRs2().getString(1));
            }
        } catch (Exception exception) {

        }
    }
    private MarcoAplicacion marco;
    private CargaMenu cargaSecciones = new CargaMenu();
}
