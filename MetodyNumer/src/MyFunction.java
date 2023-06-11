import umontreal.ssj.functions.MathFunction;
import umontreal.ssj.functions.MathFunctionUtil;

public class MyFunction implements MathFunction {
    public double evaluate(double v) {
        return v * v - v + 1;
    }

    public double deriverative(double v, int number) {
        return MathFunctionUtil.derivative(this, v, number);
    }
}

//<dependencies>
//<!-- https://mvnrepository.com/artifact/ca.umontreal.iro.simul/ssj -->
//<dependency>
//<groupId>ca.umontreal.iro.simul</groupId>
//<artifactId>ssj</artifactId>
//<version>3.1.0</version>
//</dependency>
//</dependencies>
