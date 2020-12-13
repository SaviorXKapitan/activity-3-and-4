/**
 * This class contains various methods that can be used to perform arithmetic operations on fractions.
 */

public class Fraction {
    /**
     * Holds the value of this fraction's numerator.
     */
    private int numerator;
    /**
     * Holds the value of this fraction's denominator.
     */
    private int denominator;

    /**
     * Constructs a new Fraction with numerator = 0 and denominator = 1, a fraction with a value equivalent to 0.
     **/
    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

  
    /**
     * Constructs a new Fraction using the specified numerator and denominator values.
     * @param numerator the numerator value of the fraction.
     * @param denominator the denominator value of the fraction.
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
