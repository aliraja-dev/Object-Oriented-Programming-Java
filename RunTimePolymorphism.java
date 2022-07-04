public class RunTimePolymorphism {
    private final double real; // real number
    private final double imag; // imaginary number's coefficient

    public RunTimePolymorphism(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RunTimePolymorphism)) {
            return false;
        }
        RunTimePolymorphism c = (RunTimePolymorphism) o;

        return Double.compare(real, c.real) == 0 &&
                Double.compare(imag, c.imag) == 0;
    }

    @Override
    public String toString() {
        String sign = imag < 0 ? " - " : " + ";
        return "(" + real + sign + Math.abs(imag) + "i)";
    }

    public static void main(String[] args) {
        RunTimePolymorphism a = new RunTimePolymorphism(1, 0);
        RunTimePolymorphism b = new RunTimePolymorphism(1, 0);

        if (a.equals(b)) {
            System.out.println("'a' equals 'b'.");
        } else {
            System.out.println("'a' and 'b' are not equal.");
        }
        System.out.println("'a' = " + a);
        System.out.println("'b' = " + b);
    }
}