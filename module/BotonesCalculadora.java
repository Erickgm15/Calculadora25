package module;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class BotonesCalculadora extends JPanel {

    public BotonesCalculadora(Consumer<String> onClick) {
        setLayout(new GridLayout(4, 4, 5, 5));

        String[] botones = {
            "7","8","9","÷",
            "4","5","6","×",
            "1","2","3","-",
            "0",".","=","+"
        };

        for (String b : botones) {
            JButton btn = new JButton(b);
            btn.addActionListener(e -> onClick.accept(b));
            add(btn);
        }
    }
}
