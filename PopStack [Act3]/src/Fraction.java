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

 
    
    /**
     * Returns this fraction's numerator.
     * @return the value of this fraction's numerator.
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Returns this fraction's denominator.
     * @return the value of this fraction's denominator.
     */
    public int getDenominator() {
        return denominator;
    }


    /**
     * Sets an entered numerator to this fraction's numerator.
     * @param numerator the new numerator value.
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * Sets an entered denominator to this fraction's denominator.
     * @param denominator the new denominator value.
     */
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
     /**
     * Returns the string form of this fraction following the format numerator/denominator.
     * @return the string format of this fraction.
     **/
    public String toString() {
        if (numerator > denominator){
            MixedFraction mixedFraction = new MixedFraction(this);
            return (numerator + "/" + denominator + " or " +  mixedFraction);
        }
        return (numerator + "/" + denominator);
    }

    /**
     * Returns the equivalent decimal value of this fraction in double format.
     * @return the decimal format of this fraction.
     */
    public double toDouble() {
        return (double) numerator / denominator;
    }

    /**
     * Reduces this fraction to its simplest form.
     */
    public void reduce() {
        int gcd = computeGCD(numerator, denominator);
        int newNumerator = numerator / gcd;
        int newDenominator = denominator / gcd;
        setNumerator(newNumerator);
        setDenominator(newDenominator);
    }
    /**
     * Returns the sum of this fraction and another fraction.
     * @param other the other fraction to add with (addend).
     * @return the sum of this fraction and the other fraction.
     */
    public Fraction add(Fraction other) {
        Fraction sum = new Fraction();
        int den = denominator * other.getDenominator();
        int num = den / denominator * numerator + den / other.getDenominator() * other.getNumerator();
        sum.setNumerator(num);
        sum.setDenominator(den);
        sum.reduce();
        return sum;
    }

    /**
     * Returns the difference of this fraction and another fraction.
     * @param other the other fraction to subtract by (minuend).
     * @return the difference of this fraction and the other fraction.
     */
    public Fraction subtract(Fraction other) {
        Fraction diff = new Fraction();
        int den = denominator * other.getDenominator();
        int num = den / denominator * numerator - den / other.getDenominator() * other.getNumerator();
        diff.setNumerator(num);
        diff.setDenominator(den);
        diff.reduce();
        return diff;
    }

    /**
     * Returns the product of this fraction and another fraction.
     * @param other the other fraction to multiply with (multiplier).
     * @return the product of this fraction and the other fraction.
     */
    public Fraction multiplyBy(Fraction other) {
        Fraction prod = new Fraction();
        int den = denominator * other.getDenominator();
        int num = numerator * other.getNumerator();
        prod.setNumerator(num);
        prod.setDenominator(den);
        prod.reduce();
        return prod;
    }


    
