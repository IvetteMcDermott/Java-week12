package Lab;

import java.util.Scanner;

public class ValidationApp {
    public static void main(String[] args) {

        // ANSI escape codes for colors
        String reset = "\u001B[0m";
        String yellow = "\u001B[33m";

        // vars
        String email;
        String result = "";

        // object
        Validation VAL = new Validation();
        // scanner
        Scanner sc = new Scanner(System.in);
        System.out.println(yellow + "\nEnter your email please:" + reset);
        email = sc.nextLine();

        // getting the extension parameter

        // Using negative indices doesnt work in Java substring() method. It will
        // throw a StringIndexOutOfBoundsException, so length and as many characters
        // instead of start point, end point
        // https://www.w3schools.com/java/ref_string_substring.asp
        String extension = email.substring(email.length() - 3);

        // get and compute
        result = VAL.computeValidate(email, extension);

        // output
        System.out.println(result);

        // scanner close
        sc.close();
    }
}
