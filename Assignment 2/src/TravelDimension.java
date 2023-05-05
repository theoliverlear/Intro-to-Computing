// Name: Oliver Sigwarth
// Program: Assignment 2 - TravelDimension.java
// Description: Using control statements, help Rick transport to the desired
// dimension.
// Created: 3/29/2023
// Last Modified: 4/9/2023
//----------------------------------------------------------------------------
    /*
    * Rick needs your help to program his portal gun. His portal gun can
    * transport him to different dimensions by using a set of alpha-numeric
    * codes assigned to each dimension.
    *  ----------------------------------------
      |  * Dimension____________________Code  |
      |  * Cronenberg World------------C-137  |
      |  * Citadel of Ricks-----------C-500A  |
      |  * Froopyland-------------------D-99  |
      |  * Post-Apocalyptic-------------35-C  |
      |  * Purge Planet---------------C-500B  |
    *  ----------------------------------------
    */
//----------------------------------------------------------------------------
import java.util.Scanner;
public class TravelDimension {
    //============================-Global-Variables-==========================
    // Provides variables for the program to share data. The variable
    // dimensionChoice is the current selection by the user of which
    // dimension to teleport to. The variable currentDimension is a
    // StringBuilder to designate the current dimension. It is a StringBuilder
    // object as to change its value when traveling to a new dimension. The
    // variable numAttempts counts each attempt made to teleport. The Scanner
    // input allows for user input.
    static String dimensionChoice = "";
    static StringBuilder currentDimension = new StringBuilder("Earth");
    static int numAttempts = 0;
    static Scanner input = new Scanner(System.in);
    //=============================-Core-Method-==============================
    public static void travelDimension() {
        //--------------------------------------------------------------------
        // 1. The program should ask Rick to enter an alpha-numeric code for |
        // the dimension he wants to travel to.                              |
        //--------------------------------------------------------------------
        // Prints the codes to the dimensions available for travel. Asks for
        // user input for which dimension they would like to travel to.
        outer: while (true) {
            System.out.println("Welcome, Rick. Please enter the " +
                               "alpha-numeric code for the dimension you " +
                               "want to travel to:");
            System.out.println(" * Cronenberg World-----------C-137\n" +
                               " * Citadel of Ricks----------C-500A\n" +
                               " * Froopyland------------------D-99\n" +
                               " * Post-Apocalyptic------------35-C\n" +
                               " * Purge Planet--------------C-500B");
            System.out.print("Please enter the dimension code: ");
            //----------------------------------------------------------------
            // 2. The program should then check if the code entered by Rick  |
            // is correct or not. If the code is correct, the portal gun     |
            // will transport Rick to the selected dimension. If the code is |
            // incorrect, the portal gun will malfunction and return an      |
            // error message.                                                |
            //----------------------------------------------------------------
            dimensionChoice = input.next();
            // Once receiving input, the dimensionChoice will be compared
            // using the enhanced switch statement. Inside each case, the user
            // input, dimensionChoice, is compared to all available codes. If
            // all codes do not match, the program will loop back to allow for
            // a correct input. The numAttempts is incremented to eventually
            // be shown when a successful attempt is made. If a code matches,
            // the program checks to see if the currentDimension is the same
            // as the dimension of choosing. If not, travelDimensionPrompt()
            // is called which provides the user with the information about
            // their successful travel attempt. The travelDimensionPrompt()
            // method will also return a boolean for whether to terminate or
            // continue the program. Finally, the loop will be broken out of
            // because the user made a correct input and chose to end the
            // program.
            switch (dimensionChoice) {
                case "C-137" -> {
                    if (!isCurrentDimension(dimensionChoice)) {
                        if (!travelDimensionPrompt("Cronenberg World",
                                                   "C-137")) {
                            break outer;
                        }
                    }
                }
                case "C-500A" -> {
                    if (!isCurrentDimension(dimensionChoice)) {
                        if (!travelDimensionPrompt("Citadel of Ricks",
                                                   "C-500A")) {
                            break outer;
                        }
                    }
                }
                case "D-99" -> {
                    if (!isCurrentDimension(dimensionChoice)) {
                        if (!travelDimensionPrompt("Froopyland",
                                                   "D-99")) {
                            break outer;
                        }
                    }
                }
                case "35-C" -> {
                    if (!isCurrentDimension(dimensionChoice)) {
                        if (!travelDimensionPrompt("Post-Apocalyptic",
                                                   "35-C")) {
                            break outer;
                        }
                    }
                }
                case "C-500B" -> {
                    if (!isCurrentDimension(dimensionChoice)) {
                        if (!travelDimensionPrompt("Purge Planet",
                                                   "C-500B")) {
                            break outer;
                        }
                    }
                }
                //------------------------------------------------------------
                // 3. The program should allow Rick to try again until he    |
                // enters the correct code for the desired dimension.        |
                //------------------------------------------------------------
                // If none of the codes match the user input, dimensionChoice,
                // then the default value case is called where it alerts the
                // user that they inputted an incorrect code. The numAttempts
                // is incremented to eventually be shown when a successful
                // attempt is made. The program will loop back to allow for a
                // correct input.
                default -> {
                    System.out.println("Error: code not recognized." +
                                       " Please try again.");
                    numAttempts++;
                }
            }
        }
    }
    //====================-Is-In-Desired-Dimension-Method-====================
    public static boolean isCurrentDimension(String chosenDimension) {
        // The method isCurrentDimension() checks to see if Rick is in the
        // dimension of choosing. If his current dimension is the same as his
        // chosenDimension, the user will receive a prompt from
        // printCurrentDimension() which tells the user Rick's current
        // location and to choose a different one. The method
        // isCurrentDimension() will also return true to inform the calling of
        // the method whether Rick is in the desired dimension. If he is not
        // in the desired dimension, it will return false.
        if (currentDimension.toString().equals(chosenDimension)) {
            switch (chosenDimension) {
                case "C-137" -> {
                    printCurrentDimension("Cronenberg World");
                }
                case "C-500A" -> {
                    printCurrentDimension("Citadel of Ricks");
                }
                case "D-99" -> {
                    printCurrentDimension("Froopyland");
                }
                case "35-C" -> {
                    printCurrentDimension("Post-Apocalyptic");
              }
                case "C-500B" -> {
                    printCurrentDimension("Purge Planet");
                }
            }
            return true;
        } else {
            return false;
        }
    }
    //==============-Print-Is-In-The-Desired-Dimension-Method-================
    public static void printCurrentDimension(String dimension) {
        // This method will print the dimension provided by the variable
        // dimension in informing the user to choose a different dimension.
        System.out.println("You are currently in " + dimension +
                ". Please choose a different dimension.");
    }
    //===================-Successful-Teleport-Prompt-Method-==================
    public static boolean travelDimensionPrompt(String dimension,
                                                String dimensionCode) {
        // This method modifies the current dimension by deleting the value of
        // currentDimension and adds the now empty StringBuilder with the
        // desired dimension using the dimensionCode parameter value. As a
        // successful attempt, numAttempts are incremented to later be
        // displayed. Next, the program prints the successful transportation
        // prompt showing their number of attempts and destination dimension.
        // Lastly, the method returns a value confirming or denying whether to
        // continue the program.
        int previousDimensionNameLen = currentDimension.length();
        currentDimension.delete(0, previousDimensionNameLen);
        currentDimension.append(dimensionCode);
        System.out.println(currentDimension);
        numAttempts++;
        System.out.println("Portal gun engaged. Traveling to "
                          + dimension + ".");
        //--------------------------------------------------------------------
        // 4. The program should also have a counter that keeps track of the |
        // number of tries it took Rick to enter the correct code.           |
        //--------------------------------------------------------------------
        // Checks to see if numAttempts equals one, and if so, it will print
        // "try" instead of "tries" to be grammatically correct.
        if (numAttempts == 1) {
            System.out.println("You arrive safely after " +
                                numAttempts + " try.");
        } else {
            System.out.println("You arrive safely after " +
                                numAttempts + " tries.");
        }
        // The program asks if the user would like to continue with the
        // program. If the user inputs 0, it will terminate by returning false
        // and therefore breaking the loop in travelDimension(). Otherwise, if
        // the user inputs 1, the loop will not break and the program will
        // continue. The program will also reset numAttempts to 0. If the user
        // inputs a number that is neither 0 or 1, they will be informed to
        // choose between the two options and loop back to allow the user to
        // make a correct input. If the user inputs a non-integer value, the
        // program will throw a NumberFormatException and will inform the user
        // to enter an integer and the program will loop back to allow for a
        // correct input.
        while (true) {
            System.out.println("Would like to continue?" +
                               " (0) No (1) Yes");
            try {
                int choiceContinue = Integer.parseInt(input.next());
                if (choiceContinue == 0) {
                    return false;
                } else if (choiceContinue == 1) {
                    numAttempts = 0;
                    return true;
                } else {
                    System.out.println("Please choose 0 or 1.");
                }
            } catch (NumberFormatException e) {
                System.err.println(e + ": Please input an integer.");
            }
        }
    }
    //=============================-Main-Method-==============================
    public static void main(String[] args) {
        // This method will run the entirety of the program while utilizing
        // other methods as well.
        travelDimension();
        // Read README.txt to run the program.
    }
}
