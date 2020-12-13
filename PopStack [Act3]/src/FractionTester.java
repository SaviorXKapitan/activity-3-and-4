

import java.util.InputMismatchException;
import java.util.Scanner;

public class FractionTester {
    public static Fraction operand1;
    public static Fraction operand2;


    public static void main(String[] args){
        enterFraction1();
        enterFraction2();
        menu();
    }

    public static void enterFraction1(){
        String operand = "fraction 1";
        String fraction1Type = decideMixedOrRegular(operand);
        operand1= enterFraction(operand, fraction1Type);
    }

    public static void enterFraction2(){
        String operand = "fraction 2";
        String fraction2Type = decideMixedOrRegular(operand);
        operand2= enterFraction(operand, fraction2Type);
    }

    public static void menu() {
        int choice;
        do{
            System.out.println("\n- MAIN MENU -\nWhat do you want to do?");
            System.out.println("1.Enter value of fraction 1" +
                    "\n2.Enter value of Fraction 2" +
                    "\n3.Add fractions" +
                    "\n4.Subtract fractions " +
                    "\n5.Multiply fractions" +
                    "\n6.Divide fractions" +
                    "\n7 Reduce a fraction" +
                    "\n8.Quit");
            System.out.print("Enter your choice: ");
            Scanner key = new Scanner(System.in);
            choice = key.nextInt();
            System.out.println();
            choices(choice);
        } while (choice != 8);
    }

    public static void choices(int choice){
        try{
            switch(choice){
                case 1:
                    enterFraction1();
                    pressEnter();
                    break;
                case 2:
                    enterFraction2();
                    pressEnter();
                    break;
                case 3:
                    combination("add");
                    pressEnter();
                    break;
                case 4:
                    combination("subtract");
                    pressEnter();
                    break;
                case 5:
                    combination("multiply");
                    pressEnter();
                    break;
                case 6:
                    combination("divide");
                    pressEnter();
                    break;
                case 7:
                    reduce();
                    pressEnter();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.print("Please make sure you entered a number among the choices.");
                    pressEnter();
            }
        } catch (InputMismatchException e){
            System.out.println("Please make sure you enter an integer.");
            pressEnter();
        } catch (Exception e){
            System.out.println("Please make sure you entered a valid number");
            pressEnter();
        }
    }
    
    public static void combination(String operation){
        if(!(operand1 instanceof MixedFraction) && !(operand2 instanceof MixedFraction)) printRegAndRegResults(operation);
        if((operand1 instanceof MixedFraction) && (operand2 instanceof MixedFraction)) printMixandMixResults(operation);
        if(!(operand1 instanceof MixedFraction) && (operand2 instanceof MixedFraction)) printRegAndMixResults(operation);
        if((operand1 instanceof MixedFraction) && !(operand2 instanceof MixedFraction)) printMixandRegResults(operation);
    }

    private static String decideMixedOrRegular(String operand) {
        System.out.println("Do you want " + operand + " to be a mixed fraction or a proper/improper fraction?" + "\n" +
                "\t1. Mixed fraction" + "\n" +
                "\t2. Proper/Improper fraction");
        String type = null;
        boolean loop;
        do {
            try {
                int input;
                loop = false;
                Scanner keyboard = new Scanner(System.in);
                System.out.print("Enter 1 or 2: ");
                input = keyboard.nextInt();
                if (input < 1 || input > 2 ){
                    System.out.println("Please input 1 or 2");
                    loop = true;
                }
                else {
                    switch (input) {
                        case 1:
                            type = "mixed";
                            break;
                        case 2:
                            type = "regular";
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Please input a number" + "\n");
                loop = true;
            }
        } while(loop);
        return type;
    }
    
     private static Fraction enterFraction(String operand, String type) {
        Fraction fraction = null;
        int numerator , denominator, whole=0;
        try {
            if (type.equals("mixed")) whole = enterFractionData("whole",operand);
            numerator = enterFractionData("numerator", operand);
            denominator = enterFractionData("denominator", operand);

            if (type.equals("mixed")) fraction= new MixedFraction(whole,numerator, denominator);
            else fraction= new Fraction(numerator,denominator);
        }catch (NoNumeratorException noNumerator) {
            System.out.println("Please enter a valid numerator." + "\n");
            enterFraction(operand, type);
        }
        catch (NoDenominatorException noDenominator) {
            System.out.println("Please enter a valid denominator." + "\n");
            enterFraction(operand, type);
        }
        catch (NoWholeNumberException noWholeNumber){
            System.out.println("Please enter a valid whole number." + "\n");
            enterFraction(operand, type);
        }
        finally {
            return fraction;
        }
    }

 private static int enterFractionData(String part, String fractionInfo) {
        Scanner keyboard = new Scanner(System.in);
        int input;
        try {
            System.out.print("Enter " + part + " of " + fractionInfo + ": ");
            input = Integer.parseInt(keyboard.nextLine());
            if (part.equalsIgnoreCase("denominator") && input == 0) {
                input = enterFractionData(part, fractionInfo);
            }
            return input;
        } catch (Exception exc) {
            if (part.equalsIgnoreCase("numerator")) {
                throw new NoNumeratorException();
            } else if (part.equalsIgnoreCase("denominator")) {
                throw new NoDenominatorException();
            } else {
                throw new NoWholeNumberException();
            }
        }
    }

    private static void printRegAndRegResults(String operation){
        switch (operation){
            case "add":
                System.out.print("Sum (fraction): " + operand1.add(operand2).toString() +"\nSum (decimal): ");
                System.out.printf("%.2f", (operand1.add(operand2)).toDouble());
                break;
            case "subtract":
                System.out.print("Difference (fraction): " + operand1.subtract(operand2).toString() +"\nDifference (decimal):");
                System.out.printf("%.2f", + (operand1.subtract(operand2)).toDouble());
                break;
            case "multiply":
                System.out.print("Product (fraction): " + operand1.multiplyBy(operand2).toString() +"\nProduct (decimal):");
                System.out.printf("%.2f", (operand1.multiplyBy(operand2)).toDouble());
                break;
            case "divide":
                System.out.print("Quotient (fraction): " + operand1.divideBy(operand2).toString() +"\nQuotient (decimal):");
                System.out.printf("%.2f", (operand1.divideBy(operand2)).toDouble());
                break;
        }
    }

    private static void printMixandMixResults(String operation){
        MixedFraction operand1Mix = (MixedFraction) operand1;
        MixedFraction operand2Mix = (MixedFraction) operand2;
        switch (operation){
            case "add":
                System.out.print("Sum (fraction):" + operand1Mix.add(operand2Mix).toString() +"\nSum (decimal): ");
                System.out.printf("%.2f",(operand1Mix.add(operand2Mix)).toDouble());
                break;
            case "subtract":
                System.out.print("Difference (fraction): " + operand1Mix.subtract(operand2Mix).toString() +"\nDifference (decimal): ");
                System.out.printf("%.2f",(operand1Mix.subtract(operand2Mix)).toDouble());
                break;
            case "multiply":
                System.out.print("Product (fraction): " + operand1Mix.multiplyBy(operand2Mix).toString() +"\nProduct (decimal): ");
                System.out.printf("%.2f",(operand1Mix.multiplyBy(operand2Mix)).toDouble());
                break;
            case "divide":
                System.out.print("Quotient (fraction): " + operand1Mix.divideBy(operand2Mix).toString() +"\nQuotient (decimal): ");
                System.out.printf("%.2f", (operand1Mix.divideBy(operand2Mix)).toDouble());
                break;
        }
    }
     private static void printRegAndMixResults(String operation){
        MixedFraction operand2Mix = (MixedFraction) operand2;
        switch (operation){
            case "add":
                System.out.print("Sum (fraction): " + operand1.add(operand2Mix).toString() +"\nSum (decimal): ");
                System.out.printf("%.2f",(operand1.add(operand2Mix)).toDouble());
                break;
            case "subtract":
                System.out.print("Difference (fraction):  " + operand1.subtract(operand2Mix).toString() +"\nDifference (decimal): ");
                System.out.printf("%.2f",(operand1.subtract(operand2Mix)).toDouble());
                break;
            case "multiply":
                System.out.print("Product (fraction): " + operand1.multiplyBy(operand2Mix).toString() +"\nProduct (decimal): ");
                System.out.printf("%.2f", (operand1.multiplyBy(operand2Mix)).toDouble());
                break;
            case "divide":
                System.out.print("Quotient (fraction): " + operand1.divideBy(operand2Mix).toString() +"\nQuotient (decimal): ");
                System.out.printf("%.2f",(operand1.divideBy(operand2Mix)).toDouble());
                break;
        }

    }

    private static void printMixandRegResults(String operation){
        MixedFraction operand1Mix = (MixedFraction) operand1;
        switch (operation){
            case "add":
                System.out.print("Sum (fraction): " + operand1Mix.add(operand2) +"\nSum (decimal): ");
                System.out.printf("%.2f",(operand1Mix.add(operand2)).toDouble());
                break;
            case "subtract":
                System.out.print("Difference (fraction): " + operand1Mix.subtract(operand2) +"\nDifference (decimal): ");
                System.out.printf("%.2f",(operand1Mix.subtract(operand2)).toDouble());
                break;
            case "multiply":
                System.out.print("Product (fraction): " + operand1Mix.multiplyBy(operand2) +"\nProduct (decimal): ");
                System.out.printf("%.2f",(operand1Mix.multiplyBy(operand2)).toDouble());
                break;
            case "divide":
                System.out.print("Quotient (fraction): " + operand1Mix.divideBy(operand2) +"\nQuotient (decimal): ");
                System.out.printf("%.2f",(operand1Mix.divideBy(operand2)).toDouble());
                break;
        }
    }


