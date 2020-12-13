/**
 * This class overrides the Fraction class, and contains various methods that can be used to perform arithmetic operations on mixed fractions.
 */

public class MixedFraction extends Fraction{

    /**
     * Holds the value of this mixed fraction's whole number.
     */
    private int whole;

    /**
     * Constructs a MixedFraction calling the Fraction() method with numerator = 0 , denominator = 1 and whole = 0, a mixed fraction with a value equivalent to 0.
     **/
    public MixedFraction() {
        super();
        this.whole = 0;
    }

    /**
     * Constructs a MixedFraction using the specified whole number and its fraction part.
     * @param whole the whole number part of the mixed fraction.
     * @param fraction the fraction part of the mixed fraction.
     */
    public MixedFraction(int whole, Fraction fraction){
        setWholePart(whole);
        setFractionPart(fraction);
    }

    /**
     * Constructs a MixedFraction using the specified whole number, numerator, and denominator.
     * @param whole the whole number of the mixed fraction.
     * @param numerator the numerator of the mixed fraction.
     * @param denominator the denominator of the mixed fraction.
     */
    public MixedFraction(int whole, int numerator, int denominator){
        super(numerator, denominator);
        this.whole=whole;
    }


    /**
     * Constructs a MixedFraction using the specified fraction by converting it to mixed fraction form.
     * @param fraction the fraction part of the mixed fraction.
     */
    public MixedFraction (Fraction fraction){
        int numerator = fraction.getNumerator();
        int denominator = fraction.getDenominator();
        whole = fraction.getNumerator()/fraction.getDenominator();
        if (whole !=0 && (fraction.getNumerator() < 0 || fraction.getDenominator() < 0)){
            setNumerator(Math.abs(numerator % denominator));
            setDenominator(Math.abs(denominator));

        } else {
            setNumerator(numerator % denominator);
            setDenominator(denominator);
        }
    }

    /**
     * Sets the value of this mixed fraction's whole number.
     * @param whole the whole number of this mixed fraction.
     */
    public void setWholePart(int whole){
        this.whole=whole;
    }

    /**
     * Sets the value of this mixed fraction's fraction part.
     * @param fraction the fraction part of this mixed fraction.
     */
    public void setFractionPart(Fraction fraction){
        setNumerator(fraction.getNumerator());
        setNumerator(fraction.getDenominator());
    }

    /**
     * Returns this mixed fraction's whole number part.
     * @return the value of the whole number of this mixed fraction.
     */
    public int getWhole(){
        return this.whole;
    }

    
    /**
     * Returns the value of this mixed fraction's fraction part.
     * @return the value of the fraction part of this mixed fraction.
     */
    public Fraction getFractionPart(){
        int numerator = getNumerator();
        int denominator = getDenominator();
        Fraction fractionPart = new Fraction(numerator, denominator);
        return fractionPart;
    }

    /**
     * Returns this mixed fraction's equivalent improper fraction
     * @return the converted improper fraction of this fraction
     */
    public Fraction toFraction() {
        int tempNumerator = getNumerator();
        int denominator = getDenominator();
        int numerator = (Math.abs(whole) * denominator) + tempNumerator;
        if (whole < 0 )  numerator = 0-numerator;
        Fraction fraction = new Fraction(numerator, denominator);
        return fraction;
    }

    /**
     * Returns the string form of this mixed fraction following the format wholeNumber numerator/denominator.
     * @return the String format of this mixed fraction
     */
    public String toString() {
        if (whole == 0) {
            if (getDenominator() == 1) {
                int tempFraction = whole + getNumerator();
                return (Integer.toString(tempFraction));
            } else {
                return (getNumerator() + "/" + getDenominator());
            }
        } else if (getDenominator() == 1){
            int tempFraction = whole + getNumerator();
            return (Integer.toString(tempFraction));
        } else {
            return (this.whole + " " + super.toString());
        }
    }
    
     /**
     * Returns the equivalent decimal value of this mixed fraction in double format.
     * @return the decimal format of this mixed fraction.
     */
    public double toDouble() {
        return toFraction().toDouble();
    }

    /**
     * Returns the sum of this mixed fraction and another mixed fraction.
     * @param other the mixed fraction to add with (addend).
     * @return the sum of this mixed fraction and the other mixed fraction.
     */
    public MixedFraction add(MixedFraction other) {
        MixedFraction operand1 = new MixedFraction(whole, getNumerator(), getDenominator());
        Fraction sum = operand1.toFraction().add(other.toFraction());
        MixedFraction sumMixed = new MixedFraction(sum);
        return sumMixed;
    }

    /**
     * Returns the difference of this mixed fraction and another mixed fraction.
     * @param other the other mixed fraction to subtract by (minuend).
     * @return the difference of this mixed fraction and the other mixed fraction.
     */
    public MixedFraction subtract(MixedFraction other) {
        MixedFraction operand1 = new MixedFraction(whole, getNumerator(), getDenominator());
        Fraction diff = operand1.toFraction().subtract(other.toFraction());
        MixedFraction diffMixed = new MixedFraction(diff);
        return diffMixed;
    }

    /**
     * Returns the product of this mixed fraction and another mixed fraction.
     * @param other the other mixed fraction to multiply with (multiplier).
     * @return the product of this mixed fraction and the other mixed fraction.
     */
    public MixedFraction multiplyBy(MixedFraction other) {
        MixedFraction operand1 = new MixedFraction(whole, getNumerator(), getDenominator());
        Fraction prod = operand1.toFraction().multiplyBy(other.toFraction());
        MixedFraction prodMixed = new MixedFraction(prod);
        return prodMixed;
    }

/**
     * Returns the quotient of this mixed fraction and another mixed fraction.
     * @param other the other mixed fraction to divide by (divisor).
     * @return the quotient of this mixed fraction and the other mixed fraction.
     */
    public MixedFraction divideBy(MixedFraction other) {
        MixedFraction operand1 = new MixedFraction(whole, getNumerator(), getDenominator());
        Fraction quo = operand1.toFraction().divideBy(other.toFraction());
        MixedFraction quoMixed = new MixedFraction(quo);
        return quoMixed;
    }


    /**
     * Returns the sum of this mixed fraction and a fraction.
     * @param other the fraction to add with (addend).
     * @return the sum of this mixed fraction and the the fraction.
     */
    public MixedFraction add(Fraction other) {
        MixedFraction operand1 = new MixedFraction(whole, getNumerator(), getDenominator());
        Fraction sum = operand1.toFraction().add(other);
        sum.reduce();
        MixedFraction sumMixed = new MixedFraction(sum);
        return sumMixed;
    }
       /**
     * Returns the difference of this mixed fraction and a fraction.
     * @param other the fraction to subtract by (minuend).
     * @return the difference of this mixed fraction and the the fraction.
     */
    public MixedFraction subtract(Fraction other) {
        MixedFraction operand1 = new MixedFraction(whole, getNumerator(), getDenominator());
        Fraction diff = operand1.toFraction().subtract(other);
        diff.reduce();
        MixedFraction diffMixed = new MixedFraction(diff);
        return diffMixed;
    }

    /**
     * Returns the product of this mixed fraction and a fraction.
     * @param other the fraction to multiply with (multiplier).
     * @return the product of this mixed fraction and the the fraction.
     */
    public MixedFraction multiplyBy(Fraction other) {
        MixedFraction operand1 = new MixedFraction(whole, getNumerator(), getDenominator());
        Fraction prod = operand1.toFraction().multiplyBy(other);
        prod.reduce();
        MixedFraction prodMixed = new MixedFraction(prod);
        return prodMixed;
    }

    /**
     * Returns the quotient of this mixed fraction and a fraction.
     * @param other the fraction to divide by (divisor).
     * @return the quotient of this mixed fraction and the fraction.
     */
    public MixedFraction divideBy(Fraction other) {
        MixedFraction operand1 = new MixedFraction(whole, getNumerator(), getDenominator());
        Fraction quo = operand1.toFraction().divideBy(other);
        quo.reduce();
        MixedFraction quoMixed = new MixedFraction(quo);
        return quoMixed;
    }
}



