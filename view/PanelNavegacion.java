package view;

import javax.swing.*;
import java.awt.*;

public class PanelNavegacion extends JPanel {
    public JButton btnBasica;
    public JButton btnArea;
    public JButton btnConversion;
    public JButton btnTemperatura;
    public JButton btnHistorial;

    public PanelNavegacion() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        btnBasica = new JButton("Básica");
        btnArea = new JButton("Área");
        btnConversion = new JButton("Conversión");
        btnTemperatura = new JButton("Temperatura");
        btnHistorial = new JButton("Historial");

        add(btnBasica);
        add(btnArea);
        add(btnConversion);
        add(btnTemperatura);
        add(btnHistorial);
    }
}
