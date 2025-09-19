package view;

import javax.swing.*;
import java.awt.*;

public class PanelDisplay extends JPanel {
    private JTextField display;

    public PanelDisplay() {
        setLayout(new BorderLayout());
        display = new JTextField();
        display.setEditable(false); 
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(SwingConstants.RIGHT); 
        add(display, BorderLayout.CENTER);
    }

    public void setTexto(String texto) {
        display.setText(texto);
    }

    public String getTexto() {
        return display.getText();
    }

    public void limpiar() {
        display.setText("");
    }

    public void setValor(double valor) {
        display.setText(String.format("%.2f", valor));
    }
}
