package module;

import javax.swing.*;
import java.awt.*;
import view.PanelDisplay;

public class TemperaturaView extends JPanel {
    public JComboBox<String> cbFromTo;
    public JTextField txtTemp;
    public JButton btnConvert;
    public PanelDisplay display;

    public TemperaturaView() {
        setLayout(new BorderLayout(6,6));
        JPanel top = new JPanel();
        cbFromTo = new JComboBox<>(new String[] {"C → F", "F → C", "C → K", "K → C"});
        txtTemp = new JTextField(6);
        btnConvert = new JButton("Convertir");
        top.add(cbFromTo); top.add(txtTemp); top.add(btnConvert);
        add(top, BorderLayout.NORTH);

        display = new PanelDisplay();
        add(display, BorderLayout.CENTER);
    }
}
