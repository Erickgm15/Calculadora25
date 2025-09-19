package module;

import javax.swing.*;
import java.awt.*;
import view.PanelDisplay;
import operaciones.calculadoraBasica;

public class CalculadoraBasicaView extends JPanel {
    private PanelDisplay display;
    private String entrada = "";
    private double num1 = 0;
    private String operador = "";
    private calculadoraBasica op = new calculadoraBasica();

    public CalculadoraBasicaView() {
        setLayout(new BorderLayout(5,5));

        display = new PanelDisplay();
        add(display, BorderLayout.NORTH);

        JPanel keypad = new JPanel(new GridLayout(4,4,5,5));
        String[] botones = {"7","8","9","÷",
                            "4","5","6","×",
                            "1","2","3","-",
                            "0",".","=","+"};

        for (String b : botones) {
            JButton btn = new JButton(b);
            btn.addActionListener(e -> presionar(b));
            keypad.add(btn);
        }
        add(keypad, BorderLayout.CENTER);
    }

    private void presionar(String b) {
        if ("+-×÷".contains(b)) {              // operador
            num1 = Double.parseDouble(entrada);
            operador = b;
            entrada = "";
        } else if ("=".equals(b)) {           // calcular
            double num2 = Double.parseDouble(entrada);
            double res = switch (operador) {
                case "+" -> op.sumar(num1, num2);
                case "-" -> op.restar(num1, num2);
                case "×" -> op.multiplicar(num1, num2);
                case "÷" -> op.dividir(num1, num2);
                default -> 0;
            };
            display.setValor(res);
            entrada = "";
            operador = "";
        } else {                              // número o punto
            entrada += b;
            display.setTexto(entrada);
        }
    }
}
