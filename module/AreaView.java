package module;

import javax.swing.*;
import java.awt.*;
import view.PanelDisplay;
import control.Area;

public class AreaView extends JPanel {

    private JTextField txtLado, txtBase, txtAltura, txtRadio;
    private JButton btnCuad, btnRect, btnTri, btnCirc;
    private PanelDisplay display;
    private Area operaciones;

    public AreaView() {
        operaciones = new Area();
        setLayout(new BorderLayout(6,6));

        // Inputs
        JPanel inputs = new JPanel(new GridLayout(4,2,5,5));
        txtLado = agregarInput(inputs, "Lado (cuadrado):");
        txtBase = agregarInput(inputs, "Base:");
        txtAltura = agregarInput(inputs, "Altura:");
        txtRadio = agregarInput(inputs, "Radio:");
        add(inputs, BorderLayout.NORTH);

        // Display
        display = new PanelDisplay();
        add(display, BorderLayout.CENTER);

        // Botones
        JPanel botones = new JPanel(new FlowLayout());
        btnCuad = agregarBoton(botones, "Cuadrado", () -> calcular("cuadrado"));
        btnRect = agregarBoton(botones, "Rectángulo", () -> calcular("rectangulo"));
        btnTri  = agregarBoton(botones, "Triángulo", () -> calcular("triangulo"));
        btnCirc = agregarBoton(botones, "Círculo", () -> calcular("circulo"));
        add(botones, BorderLayout.SOUTH);
    }

    // Método
    private void calcular(String tipo) {
        double resultado = 0;

        switch(tipo) {
            case "cuadrado":
                if (!esNumero(txtLado.getText())) { mostrarError("lado"); return; }
                resultado = operaciones.areaCuadrado(Double.parseDouble(txtLado.getText()));
                break;
            case "rectangulo":
                if (!esNumero(txtBase.getText()) || !esNumero(txtAltura.getText())) { mostrarError("base y altura"); return; }
                resultado = operaciones.areaRectangulo(Double.parseDouble(txtBase.getText()), Double.parseDouble(txtAltura.getText()));
                break;
            case "triangulo":
                if (!esNumero(txtBase.getText()) || !esNumero(txtAltura.getText())) { mostrarError("base y altura"); return; }
                resultado = operaciones.areaTriangulo(Double.parseDouble(txtBase.getText()), Double.parseDouble(txtAltura.getText()));
                break;
            case "circulo":
                if (!esNumero(txtRadio.getText())) { mostrarError("radio"); return; }
                resultado = operaciones.areaCirculo(Double.parseDouble(txtRadio.getText()));
                break;
        }
        display.setValor(resultado);
    }

    // Métodos auxiliares
    private JTextField agregarInput(JPanel panel, String label) {
        panel.add(new JLabel(label));
        JTextField campo = new JTextField();
        panel.add(campo);
        return campo;
    }

    private JButton agregarBoton(JPanel panel, String texto, Runnable action) {
        JButton boton = new JButton(texto);
        boton.addActionListener(e -> action.run());
        panel.add(boton);
        return boton;
    }

    private boolean esNumero(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private void mostrarError(String campo) {
        JOptionPane.showMessageDialog(this, "Ingrese un valor válido para " + campo);
    }
}
