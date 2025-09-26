package view;

import javax.swing.*;
import java.awt.*;

import module.AreaView;
import module.CalculadoraBasicaView;
import module.ConversionUnidadesView;
import module.HistorialView;
import module.TemperaturaView;
import view.PanelNavegacion;

public class Dashboard extends JFrame {

    private CardLayout cardLayout;
    private JPanel panelCentral;

    public Dashboard() {
        
        setTitle("Calculadora  ");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

          PanelNavegacion panelNavegacion = new PanelNavegacion();
        add(panelNavegacion, BorderLayout.NORTH);

        //  Panel central  
        cardLayout = new CardLayout();
        panelCentral = new JPanel(cardLayout);

        //  vistas  
        panelCentral.add(new CalculadoraBasicaView(), "BASICA");
        panelCentral.add(new AreaView(), "AREA");
        panelCentral.add(new ConversionUnidadesView(), "CONVERSION");
        panelCentral.add(new TemperaturaView(), "TEMPERATURA");
        panelCentral.add(new HistorialView(), "HISTORIAL");

        add(panelCentral, BorderLayout.CENTER);

        //   botones de navegación  
          panelNavegacion.btnBasica.addActionListener(e -> cardLayout.show(panelCentral, "BASICA"));
        panelNavegacion.btnArea.addActionListener(e -> cardLayout.show(panelCentral, "AREA"));
        panelNavegacion.btnConversion.addActionListener(e -> cardLayout.show(panelCentral, "CONVERSION"));
        panelNavegacion.btnTemperatura.addActionListener(e -> cardLayout.show(panelCentral, "TEMPERATURA"));
        panelNavegacion.btnHistorial.addActionListener(e -> cardLayout.show(panelCentral, "HISTORIAL"));

         
        setLocationRelativeTo(null);  
        setVisible(true);
    }

     
    public static void main(String[] args) {
        new Dashboard();
    }
}
