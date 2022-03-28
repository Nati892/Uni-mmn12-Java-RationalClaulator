package com.company;

import sun.awt.X11.XSystemTrayPeer;

import java.util.Scanner;

public class RationalCalculator {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        inputLoop();
        System.out.println("Goodbye, thanks for using my calculator.");

    }


    public static void inputLoop() {

        while (true) {/*main loop for program, will exit when user enters exit*/
            System.out.println("Lets start!,Enter \"exit\" at any time to exit");
            System.out.println("please enter first rational number ");
            Rational first, second;


            first = getRationalNumber();//get first rational number
            while (first == null) {//if the input was bad then null is returned and the user should renter the first
                System.out.println("please re-enter the first rational number");
                first = getRationalNumber();
            }

            second = getRationalNumber();//get first rational number
            while (second == null) {//if the input was bad then null is returned and the user should renter the first
                System.out.println("please re-enter the second rational number");
                second = getRationalNumber();
            }

            showOperations(first, second);
        }


    }

    public static Rational getRationalNumber() {
        boolean good_rational_number = false;

        Rational returned_rational = null;

        int numerator;
        int denominator;
        while (!good_rational_number) {
            System.out.println("please enter a numerator");
            numerator = getUserInt();
            System.out.println("please enter a denominator");
            denominator = getUserInt();

            try {
                returned_rational = new Rational(numerator, denominator);
                good_rational_number = true;
            } catch (Exception e) {
                System.out.println("please re-enter a rational number");
            }
        }
        return returned_rational;
    }


    private static void showOperations(Rational first, Rational second) {
        System.out.println(first.toString() + " + " + second.toString() + "=" + first.plus(second).reduce().toString());
        System.out.println(first.toString() + " - " + second.toString() + "=" + first.minus(second).reduce().toString());
        System.out.println(first.toString() + " * " + second.toString() + "=" + first.multiply(second).reduce().toString());
        System.out.println(first.toString() + " > " + second.toString() + "=" + first.greaterThan(second));
        System.out.println(first.toString() + " = " + second.toString() + "=" + first.equals(second));

    }


    public static String GetUserInput() {
        String user_input = scanner.nextLine().trim();

        if (user_input.equals("exit")) {

            System.out.println("bye bye");
            System.exit(0);
        }

        if (user_input.equals(""))
            return GetUserInput();

        return user_input;

    }


    private static int getUserInt() {
        int returned_value = 0;
        boolean isGoodInput = false;
        String user_input;

        while (!isGoodInput) {//get input - im not immediately getting an int because I want the user to be able to peacefully exit the program at all times with "exit"
            try {
                user_input = GetUserInput();
                returned_value = Integer.parseInt(user_input);
                isGoodInput = true;
            } catch (Exception e) {
                System.out.println("bad input. please re-enter number.");
            }
        }

        return returned_value;
    }
}
