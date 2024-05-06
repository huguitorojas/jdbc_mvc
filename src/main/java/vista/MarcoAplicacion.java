package vista;

import controlador.ControladorBotonEjecuta;
import controlador.ControladorCargaMenu;

import javax.swing.*;
import java.awt.*;

public class MarcoAplicacion extends JFrame {

    public MarcoAplicacion() {
        setTitle("Consulta BBDD");
        setBounds(500, 300, 400, 400);
        setLayout(new BorderLayout());
        JPanel menus = new JPanel();
        menus.setLayout(new FlowLayout());
        secciones = new JComboBox();
        secciones.setEditable(false);
        secciones.addItem("Todos");

        paises = new JComboBox<>();
        paises.setEditable(false);
        paises.addItem("Todos");

        resultado = new JTextArea(4, 50);
        resultado.setEditable(false);
        add(resultado);

        menus.add(secciones);
        menus.add(paises);

        add(menus, BorderLayout.NORTH);
        add(resultado, BorderLayout.CENTER);

        JButton botonConsulta = new JButton("Consulta");

        add(botonConsulta, BorderLayout.SOUTH);
        botonConsulta.addActionListener(new ControladorBotonEjecuta(this));

        addWindowListener(new ControladorCargaMenu(this));

    }



    private JComboBox secciones;
    private JComboBox paises;
    private JTextArea resultado;

    public JComboBox getSecciones(){
        return this.secciones;
    }

    public JComboBox getPaises() {
        return paises;
    }

    public JTextArea getResultado() {
        return resultado;
    }
}
