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
