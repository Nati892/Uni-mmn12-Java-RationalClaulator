package com.company;

import sun.awt.X11.XSystemTrayPeer;

import java.util.Scanner;

public class RationalCalculator {

    private static Scanner scanner;

    /**
     * entry point for program.
     * the functions calls for inputLoop to start the calculator
     *
     * @param args
     */
    public static void main(String[] args) {
        scanner = new Scanner(System.in);//init scanner
        inputLoop();//main loop
        System.out.println("Goodbye, thanks for using my calculator.");

    }

    /**
     * This is the main loop of the program.
     * gets two Rational numbers and shows in the end all the operations on them.
     */
    public static void inputLoop() {

        while (true) {/*main loop for program, will exit when user enters exit*/
            System.out.println("Lets start!,Enter \"exit\" at any time to exit");
            System.out.println("please enter first rational number ");
            Rational first_num, second_num;


            first_num = getRationalNumber();//get first rational number
            while (first_num == null) {//if the input was bad then null is returned and the user should renter the first
                System.out.println("please re-enter the first rational number");
                first_num = getRationalNumber();
            }

            second_num = getRationalNumber();//get first rational number
            while (second_num == null) {//if the input was bad then null is returned and the user should renter the second
                System.out.println("please re-enter the second rational number");
                second_num = getRationalNumber();
            }

            showOperations(first_num, second_num);//shows the result of each operation defined in the Rational class
        }


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
            System.out.println("please enter a numerator");
            numerator = getUserInt();
            System.out.println("please enter a denominator");
            denominator = getUserInt();

            try {
                returned_rational = new Rational(numerator, denominator);
                good_rational_number = true;//allow to exit the try catch loop
            } catch (Exception e) {
                System.out.println("please re-enter a rational number");
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
        try {//division might throw an exception if the second number is a 0/x for some x!=0
            Rational division_result = first.divide(second);
            System.out.println(first.toString() + " / " + second.toString() + "=" + division_result.reduce().toString());
        } catch (ArithmeticException e) {
            System.out.println("Cant divide by zero");
        }
    }

    /**
     * This function gets the user's input and handles an 'exit' statement and a blank line input
     * blank line- ignore
     * exit-exit the program
     *
     * @return a String containing the user's input String
     */
    public static String GetUserInput() {
        String user_input = scanner.nextLine().trim();// get the line and trim it from white chars

        if (user_input.equals("exit")) {//handles exit statement

            System.out.println("bye bye");
            System.exit(0);
        }

        if (user_input.equals(""))//handle white chars line
            return GetUserInput();

        return user_input;

    }

    /**
     * This function uses @GetUserInput and handles converting it to an int and returning it
     *
     * @return the int gotten from the user
     */
    public static int getUserInt() {
        int returned_value = 0;
        boolean isGoodInput = false;
        String user_input;//determines if to exit the try-catch loop

        while (!isGoodInput) {//get input - im not immediately getting an int because I want the user to be able to peacefully exit the program at all times with "exit"
            try {// handle a bad int conversion
                user_input = GetUserInput();
                returned_value = Integer.parseInt(user_input);
                isGoodInput = true;//good number and exit the try-catch loop
            } catch (Exception e) {
                System.out.println("bad input. please re-enter number.");
            }
        }
        return returned_value;
    }
}
