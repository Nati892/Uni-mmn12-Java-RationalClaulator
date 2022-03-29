package com.company;

import java.util.Scanner;

public class RationalCalculator {

    private static Scanner scanner;

    /**
     * entry point for program.
     * the function calls for inputLoop to start the calculator
     *
     * @param args
     */
    public static void main(String[] args) {
        scanner = new Scanner(System.in);//init scanner
        inputLoop();//main loop
        System.out.println("Goodbye");
    }

    /**
     * This is the main loop of the program.
     * gets two Rational numbers and shows in the end all the operations on them.
     */
    public static void inputLoop() {


        System.out.println("Lets start!");
        Rational first_rational_num, second_rational_num;


        System.out.println("please enter the first rational number ");
        first_rational_num = getRationalNumber();//get first rational number
        while (first_rational_num == null) {//if the input was bad then null is returned and the user should renter the first
            System.out.println("please re-enter the first rational number");
            first_rational_num = getRationalNumber();
        }

        System.out.println("please enter the second rational number ");
        second_rational_num = getRationalNumber();//get first rational number
        while (second_rational_num == null) {//if the input was bad then null is returned and the user should renter the second
            System.out.println("please re-enter the second rational number");
            second_rational_num = getRationalNumber();
        }

        showOperations(first_rational_num, second_rational_num);//shows the result of each operation defined in the Rational class
    }


    /**
     * This function gets a Rational number from the user
     *
     * @return the Rational number that was entered from the user
     */
    public static Rational getRationalNumber() {
        boolean good_rational_number = false;//used for the try-catch loop
        Rational returned_rational = null;//the returned Rational number

        int numerator;
        int denominator;
        while (!good_rational_number) {//try-catch loop trying to get two integers from the user
            System.out.println("please enter a numerator and a denominator with a space between them");
            numerator = scanner.nextInt();
            denominator = scanner.nextInt();

            try {
                returned_rational = new Rational(numerator, denominator);
                good_rational_number = true;//allow to exit the try catch loop
            } catch (Exception e) {
                System.out.println("please re-enter the rational number");
            }
        }
        return returned_rational;
    }

    /**
     * this function gets the two rational numbers and prints the results of all the operations
     *
     * @param first  the first operand in all the operations
     * @param second the second operand in all the operations
     */
    private static void showOperations(Rational first, Rational second) {


        System.out.println(first.toString() + " > " + second.toString() + " is a " + first.greaterThan(second) + " statement ");
        System.out.println(first.toString() + " = " + second.toString() + " is a " + first.equals(second) + " statement");
        System.out.println(first.toString() + " + " + second.toString() + "=" + first.plus(second).reduce().toString());
        System.out.println(first.toString() + " - " + second.toString() + "=" + first.minus(second).reduce().toString());
        System.out.println(first.toString() + " * " + second.toString() + "=" + first.multiply(second).reduce().toString());
        try {//division might throw an exception if the second number is a 0/x
            Rational division_result = first.divide(second);
            System.out.println(first.toString() + " / " + second.toString() + "=" + division_result.reduce().toString());
        } catch (Exception e) {
            System.out.println("divisor is zero! cant divide ");
        }
    }

}