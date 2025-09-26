 package module;

import javax.swing.*;
import java.awt.*;
import view.PanelDisplay;
import control.calculadoraBasica;
import database.Historial;

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

        //  botones
        BotonesCalculadora keypad = new BotonesCalculadora(this::presionar);
        add(keypad, BorderLayout.CENTER);
    }

    private void presionar(String b) {
        if ("+-×÷".contains(b)) {              
            if (!entrada.isEmpty()) {
                num1 = Double.parseDouble(entrada);
                operador = b;
                entrada = "";
            }
        } else if ("=".equals(b)) {           
            if (!entrada.isEmpty()) {
                double num2 = Double.parseDouble(entrada);
                double res = switch (operador) {
                    case "+" -> op.sumar(num1, num2);
                    case "-" -> op.restar(num1, num2);
                    case "×" -> op.multiplicar(num1, num2);
                    case "÷" -> op.dividir(num1, num2);
                    default -> 0;
                };

                display.setValor(res);

                //  historial
                Historial.agregar(num1 + " " + operador + " " + num2, res);

                entrada = "";
                operador = "";
            }
        } else {                              
            entrada += b;
            display.setTexto(entrada);
        }
    }
}
