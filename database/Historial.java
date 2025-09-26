package database;

import java.util.ArrayList;
import java.util.List;

public class Historial {
    private static ArrayList<String> historial = new ArrayList<>();

    //  operación
    public static void agregar(String operacion, double resultado) {
        historial.add(operacion + " = " + resultado);
    }

    
    public static List<String> getHistorial() {
        return historial;
    }

     
    public static void limpiar() {
        historial.clear();
    }
}
