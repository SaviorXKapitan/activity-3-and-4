

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
