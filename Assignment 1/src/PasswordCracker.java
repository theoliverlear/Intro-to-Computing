// Name: Oliver Sigwarth
// Description: Assignment 1 - Calculates the time it takes to "crack" a
// password.
// Created: 2/12/2023
// Last Modified: 2/24/2023
//----------------------------------------------------------------------------
    /* Objective: To get a hands-on experience with Java programming and
    * demonstrate your proficiency with data types, type conversion,
    * and simple output, by calculating the time it takes to crack a
    * password using a brute force method.
    * A brute force attack is a method for breaking into secure systems
    * by guessing a password character-by-character.
    * This can take quite a while. But exactly how long?
    * To figure that out we need to know a few things.
    * First, we need to know the length of the password.
    * Second, we need to know how many possible characters there are to guess
    * (there are 26 letters in the English alphabet, for example -- If you
    * allow for capital letters that's 52... and so on).
    * We also need to know how fast we can make guesses; that is, how many
    * attempts per second are allowed.
    * With this, we can compute the time it takes to crack the password with
    * the following formula:
    * timeToCrack = (passwordLength^characterSetSize) / attemptsPerSecond */
//----------------------------------------------------------------------------
import java.util.InputMismatchException;
import java.util.Scanner;
public class PasswordCracker {
    public static void crackPasswordInput() throws InputMismatchException {
        //--------------------------------------------------------------------
        // 1. Declare four variables with the following names and data types:
        int passwordLength;
        int characterSetSize;
        double attemptsPerSecond;
        double timeToCrack;
        //--------------------------------------------------------------------
        // 2. Ask the user for the length of a password they want to crack
        // and assign it to the variable passwordLength.
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                // Asks for the length of the password and if the method
                // throws a NumberFormatException, it will alert the user
                // that they need to enter a number, and it will loop back
                // to the beginning allowing them to make a correct input.
                // Otherwise, if they input a number, passwordLength will
                // be assigned that value and the loop will break which will
                // allow the program to continue.
                System.out.print("Please enter the length of the password " +
                                 "you want to \"crack\": ");
                passwordLength = Integer.parseUnsignedInt(input.next());
                break;
            } catch (NumberFormatException e) {
                System.err.println(e + ": Please input an integer.");
            }
        }
        //--------------------------------------------------------------------
        // 3. Ask the user for the number of characters in the character set
        // used for the password and assign it to the variable
        // characterSetSize.
        while (true) {
            try {
                // Asks for the size of the characterSetSize and if the
                // method throws a NumberFormatException, it will alert the
                // user that they need to enter a number, and it will loop
                // back to the beginning allowing them to make a correct
                // input. Otherwise, if they input a number, characterSetSize
                // will be assigned that value and the loop will break which
                // will allow the program to continue.
                System.out.print("Please enter the range of available " +
                                 "characters in the password: ");
                characterSetSize = Integer.parseUnsignedInt(input.next());
                break;
            } catch (NumberFormatException e) {
                System.err.println(e + ": Please input an integer.");
            }
        }
        //--------------------------------------------------------------------
        // 4. Ask the user for a reasonable number of attempts per second and
        // assign it to the variable attemptsPerSecond.
        while (true) {
            try {
                // Asks for the amount of attemptsPerSecond and if the
                // method throws a NumberFormatException, it will alert the
                // user that they need to enter a number, and it will loop
                // back to the beginning allowing them to make a correct
                // input. Otherwise, if they input a number,
                // attemptsPerSecond will be assigned that value and the
                // loop will proceed to the next if statement condition.
                System.out.print("Please input a reasonable (1 - 100,000)" +
                                " amount of attempts per second: ");
                attemptsPerSecond = Double.parseDouble(input.next());
                // Tests for a reasonable range for attemptsPerSecond.
                // If it is not within that range, the program will alert
                // the user and loop back to the beginning, allowing the
                // user to input a reasonable number.
                if (attemptsPerSecond < 1 || attemptsPerSecond > 100000) {
                    System.out.println(attemptsPerSecond +
                                    " is not reasonable.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println(e + ": Please input a number.");
            }
        }
        //--------------------------------------------------------------------
        // 5. Calculate the time it takes to crack the password using a brute
        // force method using the following formula:
        //timeToCrack = (passwordLength^characterSetSize) / attemptsPerSecond
        //--------------------------------------------------------------------
        // Uses the provided formula to calculate how long the password will
        // take to crack.
        timeToCrack = (Math.pow(characterSetSize, passwordLength) /
                attemptsPerSecond);

        // 6. Convert the time to crack from double to int.
        // Immaterial content
        //--------------------------------------------------------------------
        // 7. Display the result on the console using the following statement:
        // It will take approximately <timeToCrack> seconds to crack a
        // password of length <passwordLength> with a character set of size
        // <characterSetSize> at a rate of <attemptsPerSecond>

        // Prints to the user the result of their inputs and the value of
        // the formula calculating the time it will take to crack the
        // password. It checks to see if attemptsPerSecond equals one, and
        // if so, it will print "attempt" instead of "attempts" to be
        // grammatically correct.
        if (attemptsPerSecond == 1) {
            System.out.print("It will take approximately " + timeToCrack +
                    " seconds to crack a password of length " +
                    passwordLength + " with a character set of size " +
                    characterSetSize + " at a rate of " +
                    attemptsPerSecond + " attempt per second.");

        } else {
            System.out.print("It will take approximately " + timeToCrack +
                    " seconds to crack a password of length " +
                    passwordLength + " with a character set of size " +
                    characterSetSize + " at a rate of " +
                    attemptsPerSecond + " attempts per second.");
        }
    }
    public static void main(String[] args) {
        // This method will run the entirety of the program.
        crackPasswordInput();
        // Read README.txt to run program.
    }
}
