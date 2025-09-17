package view;

import javax.swing.*;

import module.AreaView;
import module.CalculadoraBasicaView;
import module.ConversionUnidadesView;
import module.TemperaturaView;

import java.awt.*;
import view.PanelDisplay;

public class Dashboard extends JFrame {

    // Componentes principales
    public PanelDisplay display;
    public JButton[] botonesNumeros;
    public JButton btnSuma, btnResta, btnMulti, btnDivision, btnResultado;
    public JButton btnBasica, btnArea, btnConversion, btnTemperatura, btnHistorial;

    public Dashboard() {
        setTitle("Calculadora - Dashboard");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // - botones de navegación 
        JPanel panelNavegacion = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnBasica = new JButton("Básica");
        btnArea = new JButton("Área");
        btnConversion = new JButton("Conversión");
        btnTemperatura = new JButton("Temperatura");
        btnHistorial = new JButton("Historial");

        panelNavegacion.add(btnBasica);
        panelNavegacion.add(btnArea);
        panelNavegacion.add(btnConversion);
        panelNavegacion.add(btnTemperatura);
        panelNavegacion.add(btnHistorial);

        add(panelNavegacion, BorderLayout.NORTH);

        // --- Panel central
        display = new PanelDisplay();
        add(display, BorderLayout.CENTER);

        // -botones tipo calculadora --
        JPanel panelTeclado = new JPanel(new GridLayout(4, 4, 5, 5));
        botonesNumeros = new JButton[10];

        // Botones del 1 al 9
        for (int i = 1; i <= 9; i++) {
            botonesNumeros[i] = new JButton(String.valueOf(i));
            panelTeclado.add(botonesNumeros[i]);
        }

        // Botón 0
        botonesNumeros[0] = new JButton("0");
        panelTeclado.add(botonesNumeros[0]);

        // Operaciones básicas
        btnSuma = new JButton("+");
        btnResta = new JButton("-");
        btnMulti = new JButton("×");
        btnDivision = new JButton("÷");
        btnResultado = new JButton("=");

        panelTeclado.add(btnSuma);
        panelTeclado.add(btnResta);
        panelTeclado.add(btnMulti);
        panelTeclado.add(btnDivision);
        panelTeclado.add(btnResultado);

    btnBasica.addActionListener(e -> new CalculadoraBasicaView());
    btnArea.addActionListener(e -> new AreaView());
    btnConversion.addActionListener(e -> new ConversionUnidadesView());
    btnTemperatura.addActionListener(e -> new TemperaturaView());

        add(panelTeclado, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
