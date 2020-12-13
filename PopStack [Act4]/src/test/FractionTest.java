
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class FractionTest {
    Fraction reg1 = new Fraction(3,4);
    Fraction reg2 = new Fraction(5,9);
    MixedFraction mix1 = new MixedFraction(1,2,6); // 8/6
    MixedFraction mix2 = new MixedFraction(2,3,7); // 17/7

    /*
     * Should be able to reduce a fraction to its simplest form
     */
    @Test
    public void reduce() {
        //mix1 = 1 2/6
        mix1.reduce();
        Fraction reduced = new MixedFraction(1, 1,3);
        assertEquals(reduced.toString(),mix1.toString());
    }

    /*
     * Checking the data of a mixed fraction
     */
    @Test
    public void mixed(){
        Fraction a = new MixedFraction(2,3,4);
        assertEquals("2 3/4",a.toString());
    }

    /*
     * Adds Fractions and Mixed Fractions with four variations:
     * 1.) A Fraction and a Fraction
     * 2.) A Mixed Fraction and a Mixed Fraction
     * 3.) A Fraction and a Mixed Fraction
     * 4.) A Mixed fraction and a Fraction
     */
    @Test
    public void add() {
        MixedFraction f1 = new MixedFraction(3, 16,21);
        MixedFraction f2 = new MixedFraction(3,5,28);
        MixedFraction f3 = new MixedFraction(1,8,9);

        assertEquals("47/36 or 1 11/36", (reg1.add(reg2)).toString()); //
        assertEquals(f1.toString(), (mix1.add(mix2)).toString()); // 16/21 ok
        assertEquals(f2.toString(), (reg1.add(mix2)).toString()); // 3 5/28 ok
        assertEquals(f3.toString(), (mix1.add(reg2)).toString()); // 1 8/9 ok
    }

    /*
     * Subtracts Fractions and Mixed Fractions with four variations:
     * 1.) A Fraction and a Fraction
     * 2.) A Mixed Fraction and a Mixed Fraction
     * 3.) A Fraction and a Mixed Fraction
     * 4.) A Mixed fraction and a Fraction
     */
    @Test
    public void subtract() {
        assertEquals("7/36",(reg1.subtract(reg2)).toString()); // 7/36 ok
        assertEquals("-1 2/21",(mix1.subtract(mix2)).toString()); // -1 2/21 ok
        assertEquals("-1 19/28",(reg1.subtract(mix2)).toString()); // -1 19/28
        assertEquals("7/9",(mix1.subtract(reg2)).toString()); // 7/9 ok
    }
----------------------------------------------------------
    /*
     * Multiplies Fractions and Mixed Fractions with four variations:
     * 1.) A Fraction and a Fraction
     * 2.) A Mixed Fraction and a Mixed Fraction
     * 3.) A Fraction and a Mixed Fraction
     * 4.) A Mixed fraction and a Fraction
     */
    @Test
    public void multiply() {
        assertEquals("5/12",(reg1.multiplyBy(reg2)).toString()); // 5/12 ok
        assertEquals("3 5/21",(mix1.multiplyBy(mix2)).toString()); // 3 5/21 ok
        assertEquals("1 23/28",(reg1.multiplyBy(mix2)).toString()); // 1 23/28
        assertEquals("20/27",(mix1.multiplyBy(reg2)).toString()); // 20/27 ok
    }

    /*
     * Divides Fractions and Mixed Fractions with four variations:
     * 1.) A Fraction and a Fraction
     * 2.) A Mixed Fraction and a Mixed Fraction
     * 3.) A Fraction and a Mixed Fraction
     * 4.) A Mixed fraction and a Fraction
     */
    @Test
    public void divide() {
        assertEquals("27/20 or 1 7/20",(reg1.divideBy(reg2).toString())); // 27/20 ok
        assertEquals("28/51",(mix1.divideBy(mix2).toString())); // 28/51 ok
        assertEquals("21/68",(reg1.divideBy(mix2).toString())); // 21/68 ok
        assertEquals("2 2/5",(mix1.divideBy(reg2).toString())); // 2 2/5 ok
    }

    /*
     * Calculates the Greatest Common Denominator of 2 values
     */
    @Test
    public void computeGCD(){
        Fraction fraction = new Fraction();
        assertEquals(7, fraction.computeGCD(42,49));
    }
}
