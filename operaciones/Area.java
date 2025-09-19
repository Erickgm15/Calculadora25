package operaciones;

public class Area {

    public double areaCuadrado(double lado) {
        return lado * lado;
    }

    public double areaRectangulo(double base, double altura) {
        return base * altura;
    }

    public double areaCirculo(double radio) {
        return Math.PI * radio * radio;
    }

    public double areaTriangulo(double base, double altura) {
        return (base * altura) / 2;
    }
}
