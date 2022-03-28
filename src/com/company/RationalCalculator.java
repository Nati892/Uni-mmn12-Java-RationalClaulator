package com.company;

import java.util.Scanner;

public class RationalCalculator {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        inputLoop();
        System.out.println("Goodbye, thanks for playing.");

    }


    public static void inputLoop() {

        while (true) {/*main loop for program, will exit when user enters exit*/
            System.out.println("Lets start!,Enter \"exit\" at any time to exit");
            System.out.println("please enter first rational number ");
            String user_input = GetUserInput();
            Rational first, second;
            char operation;

            first = handleRationalInput(user_input);//get first rational number
            while (first == null) {//if the input was bad then null is returned and the user should renter the first
                System.out.println("please reenter the first rational number");
                user_input = GetUserInput();
                first = handleRationalInput(user_input);

            }


        }


    }

    public static Rational handleRationalInput(String text) {
        Rational returnedVal;
        System.out.println("handleRationalInput:Text: ->" + text + "<-");/*debug*/





    }

    public static String GetUserInput() {
        String user_input = scanner.nextLine().trim();

        if (user_input.equals("exit"))
            System.exit(0);

        if (user_input.equals(""))
            return GetUserInput();

        return user_input;

    }


}
