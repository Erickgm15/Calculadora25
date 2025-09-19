package operaciones;

public class Temperatura {

    public double celsiusAFahrenheit(double c) {
        return (c * 9/5) + 32;
    }

    public double fahrenheitACelsius(double f) {
        return (f - 32) * 5/9;
    }

    public double celsiusAKelvin(double c) {
        return c + 273.15;
    }

    public double kelvinACelsius(double k) {
        return k - 273.15;
    }
}
