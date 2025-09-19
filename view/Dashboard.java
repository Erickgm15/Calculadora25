package view;

import javax.swing.*;

import module.AreaView;
import module.CalculadoraBasicaView;
import module.ConversionUnidadesView;
import module.TemperaturaView;

import java.awt.*;

public class Dashboard extends JFrame {

    private CardLayout cardLayout;
    private JPanel panelCentral;

    public Dashboard() {
        setTitle("Calculadora - Dashboard");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // -- Panel superior de navegación --
        JPanel panelNavegacion = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton btnBasica = new JButton("Básica");
        JButton btnArea = new JButton("Área");
        JButton btnConversion = new JButton("Conversión");
        JButton btnTemperatura = new JButton("Temperatura");
        JButton btnHistorial = new JButton("Historial");

        panelNavegacion.add(btnBasica);
        panelNavegacion.add(btnArea);
        panelNavegacion.add(btnConversion);
        panelNavegacion.add(btnTemperatura);
        panelNavegacion.add(btnHistorial);

        add(panelNavegacion, BorderLayout.NORTH);

        // ----- Panel central con CardLayout -----
        cardLayout = new CardLayout();
        panelCentral = new JPanel(cardLayout);

        panelCentral.add(new CalculadoraBasicaView(), "BASICA");
        panelCentral.add(new AreaView(), "AREA");
        panelCentral.add(new ConversionUnidadesView(), "CONVERSION");
        panelCentral.add(new TemperaturaView(), "TEMPERATURA");


        add(panelCentral, BorderLayout.CENTER);

        // ----- Eventos para cambiar de vista -----
        btnBasica.addActionListener(e -> cardLayout.show(panelCentral, "BASICA"));
        btnArea.addActionListener(e -> cardLayout.show(panelCentral, "AREA"));
        btnConversion.addActionListener(e -> cardLayout.show(panelCentral, "CONVERSION"));
        btnTemperatura.addActionListener(e -> cardLayout.show(panelCentral, "TEMPERATURA"));
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
