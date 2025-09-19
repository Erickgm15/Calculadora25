package module;

import javax.swing.*;
import java.awt.*;
import view.PanelDisplay;
import operaciones.ConversionUnidades;

public class ConversionUnidadesView extends JPanel {

    private JComboBox<String> cbTipo;
    private JTextField txtValor;
    private JButton btnConvert;
    private PanelDisplay display;
    private ConversionUnidades operaciones; // instancia de tu clase

    public ConversionUnidadesView() {
        operaciones = new ConversionUnidades();

        setLayout(new BorderLayout(6,6));

        // Panel superior con combo y campo
        JPanel top = new JPanel(new FlowLayout());
        cbTipo = new JComboBox<>(new String[] {"m → km", "km → m", "g → kg", "kg → g"});
        txtValor = new JTextField(8);
        btnConvert = new JButton("Convertir");
        top.add(cbTipo); top.add(txtValor); top.add(btnConvert);
        add(top, BorderLayout.NORTH);

        // Panel display
        display = new PanelDisplay();
        add(display, BorderLayout.CENTER);

        // Botón con acción
        btnConvert.addActionListener(e -> convertir());
    }

    private void convertir() {
        if (!esNumero(txtValor.getText())) {
            JOptionPane.showMessageDialog(this, "Ingrese un valor válido");
            return;
        }

        double valor = Double.parseDouble(txtValor.getText());
        double resultado = 0;

        switch(cbTipo.getSelectedItem().toString()) {
            case "m → km": resultado = operaciones.metrosAKilometros(valor); break;
            case "km → m": resultado = operaciones.kilometrosAMetros(valor); break;
            case "g → kg": resultado = operaciones.gramosAKilogramos(valor); break;
            case "kg → g": resultado = operaciones.kilogramosAGramos(valor); break;
        }

        display.setValor(resultado);
    }

    private boolean esNumero(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
