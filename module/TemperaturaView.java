package module;

import javax.swing.*;
import java.awt.*;
import view.PanelDisplay;
import control.Temperatura; // tu clase de lógica

public class TemperaturaView extends JPanel {
    public JComboBox<String> cbFromTo;
    public JTextField txtTemp;
    public JButton btnConvert;
    public PanelDisplay display;
    private Temperatura tempOp;

    public TemperaturaView() {
        setLayout(new BorderLayout(6,6));
        tempOp = new Temperatura();

        // Panel superior
        JPanel top = new JPanel();
        cbFromTo = new JComboBox<>(new String[] {"C → F", "F → C", "C → K", "K → C"});
        txtTemp = new JTextField(6);
        btnConvert = new JButton("Convertir");
        top.add(cbFromTo);
        top.add(txtTemp);
        top.add(btnConvert);
        add(top, BorderLayout.NORTH);

        // Display central
        display = new PanelDisplay();
        add(display, BorderLayout.CENTER);

        // Acción del botón
        btnConvert.addActionListener(e -> convertir());
    }

    private void convertir() {
        try {
            double valor = Double.parseDouble(txtTemp.getText());
            double res = switch ((String) cbFromTo.getSelectedItem()) {
                case "C → F" -> tempOp.celsiusAFahrenheit(valor);
                case "F → C" -> tempOp.fahrenheitACelsius(valor);
                case "C → K" -> tempOp.celsiusAKelvin(valor);
                case "K → C" -> tempOp.kelvinACelsius(valor);
                default -> 0;
            };

            display.setValor(res);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "F EN EL CHAT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
