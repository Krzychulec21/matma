public class LagrangePolynomial {


        static double[] x = {0, 2, 3, 4};
        static double[] y = {1, 3, 2, 5};

        public static double lagrangeInterpolation(double X) {
            double result = 0;
            int n = x.length;

            for (int i = 0; i < n; i++) {
                double term = y[i];
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        term = term * (X - x[j]) / (x[i] - x[j]);
                    }
                }
                result += term;
            }

            return result;
        }

        public static String lagrangePolynomial() {
            StringBuilder result = new StringBuilder();
            int n = x.length;

            for (int i = 0; i < n; i++) {
                if (i != 0) {
                    result.append(" + ");
                }
                result.append(y[i]).append("*(");
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        result.append("(x - ").append(x[j]).append(")");
                    }
                }
                result.append(")/(");
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        result.append("(").append(x[i]).append(" - ").append(x[j]).append(")");
                    }
                }
                result.append(")");
            }

            return result.toString();
        }

        public static void main(String[] args) {
            System.out.println("Wartość wielomianu dla x=3: " + lagrangeInterpolation(3));
            System.out.println("Wielomian interpolujący: " + lagrangePolynomial());
        }
    }
