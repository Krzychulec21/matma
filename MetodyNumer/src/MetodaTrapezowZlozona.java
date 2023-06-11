import java.util.function.DoubleFunction;

public class MetodaTrapezowZlozona {

    public static double oblicz(DoubleFunction<Double> funkcja, double a, double b, int n) {
        double width = (b - a) / n; // szerokość trapezu
        double suma = 0.5 * (funkcja.apply(a) + funkcja.apply(b)); // suma pierwszego i ostatniego trapezu

        for (int i = 1; i < n; i++) {
            double x = a + i * width; // punkt x w trapezie
            suma += funkcja.apply(x); // dodajemy wartość funkcji w punkcie x
        }

        return suma * width; // mnożymy przez szerokość trapezu
    }

    public static void main(String[] args) {
        DoubleFunction<Double> funkcja = x -> x * x - x + 1; // funkcja do całkowania
        double a = 1; // początek przedziału
        double b = 4; // koniec przedziału
        int n = 8; // liczba trapezów/przedziałów
        double wynik = oblicz(funkcja, a, b, n);
        System.out.println("Wynik: " + wynik);
    }
}
