import java.util.Scanner;

public class Horner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N;
        double x0;

        System.out.print("Podaj stopien wielomianiu: ");
        N = input.nextInt();

        double[][] tab = new double[N+1][3];

        System.out.print("Podaj punkt: ");
        x0 = input.nextDouble();

        for (int i=0; i<tab.length; i++) {
            System.out.print("Podaj wspolczynnik wielomianu przy x^" + (N-i) + ": ");
            tab[i][0] = input.nextDouble();
        }

        //Obliczanie wartości wieomianu

        for (int i=0; i<tab.length;i++) {
            if (i==0) tab[i][2] = tab[i][0];
            else {
                tab[i][1] = tab[i-1][2]*x0;
                tab[i][2] = tab[i][1] + tab[i][0];
            }
        }

        System.out.println("Wartosc wielomianu w punkcie " + x0 + ": " + tab[tab.length-1][2]);

        System.out.println("Dzielenia wielomianu przez dwumian:");
        for (int i=0;i<tab.length;i++) {
            if (i!=tab.length-1) System.out.print("("+ tab[i][2] + ")x^" + (N-1-i) + " + ");
            else System.out.print(tab[i][2] + "/(x-(" + x0 + "))");
        }
    }
}
