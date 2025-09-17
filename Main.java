import java.awt.BorderLayout;
import javax.swing.*;
 import view.Dashboard;
public class Main {

    public static void main(String[] args) {
        JFrame miVentana = new JFrame(); 
        miVentana.setTitle(" Calculadora"); 
        miVentana.setSize(1000, 800); 
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miVentana.setLayout(new BorderLayout());
        miVentana.setLocationRelativeTo(null);

        Dashboard dashboard = new Dashboard();
        miVentana.add(dashboard, BorderLayout.CENTER);



        miVentana.setVisible(true);
    }
}
