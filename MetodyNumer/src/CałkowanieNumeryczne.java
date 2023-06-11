import java.util.Scanner;

public class CałkowanieNumeryczne {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a, b, value, ksi, error, h, temp;
        int n;
        var func = new MyFunction();

        System.out.print("Podaj poczatek przedzialu calkowania: ");
        a = input.nextDouble();
        System.out.print("Podaj koniec przedzialu calkowania: ");
        b = input.nextDouble();

        //Metoda trapezow
        value = ((b-a)/2)*(func.evaluate(a)+func.evaluate(b));

        if (func.evaluate(a)>=func.evaluate(b)) ksi = a;
        else ksi = b;

        error = (-1.0/12.0)*(Math.pow(b-a,3))*func.deriverative(ksi, 2);

        System.out.println("\nMetoda trapezów:");
        System.out.println(value + " + " + error + " = " + (value+error) + "\n");

        //Metoda Simpsona (parabol)
        value = ((b-a)/6)*(func.evaluate(a) + func.evaluate(b) + 4*func.evaluate((a+b)/2));

        if (func.evaluate(a)>=func.evaluate(b)) ksi = a;
        else ksi = b;

        error = (-1.0/90.0)*Math.pow(b-a, 5)* func.deriverative(ksi, 4);

        System.out.println("Metoda Simpsona(parabol):");
        System.out.println(value + " + " + error + " = " + (value+error) + "\n");

        //Metoda złożonych trapezów
        System.out.print("Podaj ilosc przedzialow pomocniczych: ");
        n = input.nextInt();

        h = (b-a)/(n*1.0);
        temp = (func.evaluate(a) + func.evaluate(b))/2;

        for (double i=(a+h);i<=(b-h);i+=h) {
            temp += func.evaluate(i);
        }

        value = h * temp;

        if (func.evaluate(a)>=func.evaluate(b)) ksi = a;
        else ksi = b;

        error = (-1.0/12.0)*Math.pow(h,3)*func.deriverative(ksi, 2);

        System.out.println("Złożony wzór trapezów:");
        System.out.println(value + " + " + error + " = " + (value+error) + "\n");

        //Metoda złożonych parabol
        if (n%2==1) {
            System.out.println("Ta metoda tu nie dziala, bo N nieparzyste");
        } else {
            h = (b - a) / (n * 1.0);
            temp = func.evaluate(a) + func.evaluate(b);

            for (double i = (a + h); i <= (b - h); i += h) {
                temp += 2 * func.evaluate(i) + 4 * func.evaluate(i + h);
            }

            value = (h / 6.0) * temp;

            if (func.evaluate(a) >= func.evaluate(b)) ksi = a;
            else ksi = b;

            error = (-n / 90.0) * Math.pow(h / 2.0, 5) * func.deriverative(ksi, 4);

            System.out.println("Złożony wzór parabol:");
            System.out.println(value + " + " + error + " = " + (value + error) + "\n");
        }

    }
}
