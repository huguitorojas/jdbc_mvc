package principal;

import vista.MarcoAplicacion;

import javax.swing.*;

public class AplicacionMvcJdbc {
    public static void main(String[] args) {
        MarcoAplicacion miMarco = new MarcoAplicacion();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}
