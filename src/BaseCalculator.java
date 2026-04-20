import java.math.BigInteger;

public class BaseCalculator implements ICalculatorinterface{
    @Override
    public String add(String a, String b, int base) {
        BigInteger num1 = new BigInteger(a, base);
        BigInteger num2 = new BigInteger(b, base);
        return num1.add(num2).toString(base).toUpperCase();
    }

    @Override
    public String subtract(String a, String b, int base) {
        BigInteger num1 = new BigInteger(a, base);
        BigInteger num2 = new BigInteger(b, base);
        return num1.subtract(num2).toString(base).toUpperCase();
    }

    @Override
    public String multiply(String a, String b, int base) {
        BigInteger num1 = new BigInteger(a, base);
        BigInteger num2 = new BigInteger(b, base);
        return num1.multiply(num2).toString(base).toUpperCase();
    }

    @Override
    public String divide(String a, String b, int base) {
        BigInteger num1 = new BigInteger(a, base);
        BigInteger num2 = new BigInteger(b, base);
        if (num2.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Деленить на ноль нельзя");
        }
        return num1.divide(num2).toString(base).toUpperCase();
    }

    @Override
    public String remainder(String a, String b, int base) {
        BigInteger num1 = new BigInteger(a, base);
        BigInteger num2 = new BigInteger(b, base);
        if (num2.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Остаток от деления на ноль невозможен!");
        }
        return num1.remainder(num2).toString(base).toUpperCase();
    }
}
