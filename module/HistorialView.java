package module;

import javax.swing.*;

import database.Historial;

import java.awt.*;

public class HistorialView extends JPanel {

    private JTextArea areaHistorial;
    private JButton btnActualizar;

    public HistorialView() {
        setLayout(new BorderLayout(10,10));

        JLabel titulo = new JLabel(" Historial de Operaciones", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(titulo, BorderLayout.NORTH);

        //  mostrar el historial
        areaHistorial = new JTextArea();
        areaHistorial.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaHistorial);
        add(scroll, BorderLayout.CENTER);
 
        btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> mostrarHistorial());
        add(btnActualizar, BorderLayout.SOUTH);
 
        mostrarHistorial();
    }

    private void mostrarHistorial() {
        areaHistorial.setText("");  
        for (String item : Historial.getHistorial()) {
            areaHistorial.append(item + "\n");
        }
    }
}
