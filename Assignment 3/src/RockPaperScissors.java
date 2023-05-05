// Name: Oliver Sigwarth
// Program: Assignment 3 - RockPaperScissors.java
// Description:
// * Write a Java program that simulates a game of
// * rock-paper-scissors between the user and the computer. The program
// * should use a for loop to allow the user to play multiple rounds of the
// * game.
// Created: 4/18/2023
// Last Modified: 4/28/2023       ___________
/*                               | Objective |
//----------------------------------------------------------------------------
 | * Prompt the user for their choice of rock, paper, or scissors..........1 |
 | * Generate a random choice for the computer.............................2 |
 | * Use control statements to evaluate the game following these rules:....3 |
 |---------------------------------------------------------------------------|
 |                                                                           |
 |  *-Rock Beats Scissors-*  *-Scissors Beats paper-*  *-Paper Beats Rock-*  |
 |                                                                           |
 |---------------------------------------------------------------------------|
 | * Print outcome to the console..........................................4 |
 | * Ask if the user wants to continue the game up to five maximum rounds..5 |
 | * Print current winner and overall winner to the console................6 |
//----------------------------------------------------------------------------
*/
//----------An-Argument-in-Favor-of-an-Object-Oriented-Approach---------------
// A simple, yet important, part of programming is reading code. Esoteric    |
// code is functional but not optimal to live up to a high standard of       |
// programming. I took an object-oriented approach towards the rock paper    |
// scissors program for readability, and therefore, better understanding.    |
// Take the code, “PAPER.defeats = ROCK” for instance. It reads elegantly –  |
// almost like plain English. A non-object-oriented alternative would        |
// compare quite abstract and imperceptible. A random number, let’s say 3,   |
// would have to be compared in a conditional statement against another      |
// number representing the user’s choice between rock, paper, or scissors.   |
// The statement “if (userChoice == 1 && and computerChoice == 3)” is far    |
// less elegant than the “PAPER.defeats = ROCK” object-oriented alternative. |
// There are also benefits for the reusability of object orientation. We can |
// reuse methods and variables like the “wins” variable or “incrementWins()” |
// method. These shared and reusable mechanisms make reading the layout of   |
// the program succinct. From this approach, the only readability issues     |
// arise are the boilerplate getter-setter utilities. These are monotonous   |
// and therefore can be looked over. I label these sections with comments.   |
// When reading, you'll be able to know which code is boilerplate, and can   |
// be skipped over, and what is the important and elegant code               |
// object-orientation offers.                                                |
//----------------------------------------------------------------------------
import java.util.InputMismatchException;
import java.util.Scanner;
public class RockPaperScissors {
    //----------------------------Class-Variables-----------------------------
    // RockPaperScissors is the parent class representing the game. The class
    // has three player objects which designate if the round is won via the
    // computer, the user, or was a draw. RockPaperScissors keeps track of the
    // current gameRound and holds a constant GAME_ROUND_MAX which will
    // provide a limit to the number of games which can be played. The method
    // incrementRound() takes the current value of gameRound and increments it
    // up by one.
    Player human, computer, draw;
    int gameRound;
    final int GAME_ROUND_MAX;
    static Scanner input = new Scanner(System.in);
    //------------------------------Constructor-------------------------------
    //The RockPaperScissors constructor builds the three player objects using
    // enum constants from PlayerType defined later in the program. The names
    // of the types of these objects are held in the constants. The
    // constructor initializes gameRound to the first round and GAME_ROUND_MAX
    // to five rounds.
    public RockPaperScissors() {
        this.human = new Player(PlayerType.HUMAN);
        this.computer = new Player(PlayerType.COMPUTER);
        this.draw = new Player(PlayerType.DRAW);
        this.gameRound = 1;
        this.GAME_ROUND_MAX = 5;
    }
    //-------------------------Getter-Setter-Utilities------------------------
    public Player getHuman() {
        return this.human;
    }
    public Player getComputer() {
        return this.computer;
    }
    public Player getDraw() {
        return this.draw;
    }
    public int getGameRound() {
        return this.gameRound;
    }
    public void setGameRound(int gameRound) {
        this.gameRound = gameRound;
    }
    public int getGAME_ROUND_MAX() {
        return this.GAME_ROUND_MAX;
    }
    public void incrementRound() {
        this.setGameRound(this.getGameRound() + 1);
    }
    //------------------------------------------------------------------------
    public static class Player {
        //--------------------------Class-Variables---------------------------
        // Player is a child class of RockPaperScissors representing the
        // players. The class has a wins variable which designates how many
        // games a certain player has won. This is used to determine the
        // winner of the round and the overall winner. The class has a
        // playerType variable which is a constant from the PlayerType enum
        // designating a victory to a draw, human, or computer. The class has
        // a gameItem variable which is a constant from the GameItem enum
        // designating a move as rock, paper, or scissors. The method
        // incrementWins() takes the current value of wins for the called on
        // player and increments it up by one.
        int wins;
        PlayerType playerType;
        GameItem gameItem;
        //-----------------------------Constructor----------------------------
        // The Player constructor builds a player object by using PlayerType
        // enum constants passed by the RockPaperScissors constructor. The
        // constructor initializes gameItem to null as no move, represented
        // by GameMove, has been made. The constructor initializes wins to
        // zero.
        public Player(PlayerType playerType) {
            this.playerType = playerType;
            this.gameItem = null;
            this.wins = 0;
        }
        public PlayerType getPlayerType() {
            return this.playerType;
        }
        public GameItem getGameItem() {
            return this.gameItem;
        }
        public void setGameItem(GameItem gameItem) {
            this.gameItem = gameItem;
        }
        public int getWins() {
            return this.wins;
        }
        public void setWins(int wins) {
            this.wins = wins;
        }
        public void incrementWins() {
            this.setWins(this.getWins() + 1);
        }
    }
    //------------------------------------------------------------------------
    enum PlayerType {
        //---------------------------Class-Variables--------------------------
        // The PlayerType enum is a group of three constants HUMAN, COMPUTER,
        // and DRAW. Each constant has a playerID which identifies each
        // constant numerically. There is also a typeName variable for each
        // constant which identifies each constant by name.
        HUMAN(1, "human"),
        COMPUTER(2, "computer"),
        DRAW(3, "draw");
        final int playerID;
        final String typeName;
        PlayerType(int playerID, String typeName) {
            this.playerID = playerID;
            this.typeName = typeName;
        }
    }
    enum GameItem {
        //---------------------------Class-Variables--------------------------
        //The GameItem enum is a group of three constants ROCK, PAPER, and
        // SCISSORS. Each constant has an itemID which identifies each
        // constant numerically. This value will be used later in association
        // with a random number generated by getRandomItem(). There is also an
        // itemName variable for each constant which identifies each constant
        // by name. This will later be used to announce the moves made in the
        // game. Each GameItem has a property called defeats which holds a
        // GameItem of which the current one wins against.
        ROCK(1, "rock"),
        PAPER(2, "paper"),
        SCISSORS(3, "scissors");
        static {
            ROCK.defeats = SCISSORS;
            PAPER.defeats = ROCK;
            SCISSORS.defeats = PAPER;
        }
        final int itemID;
        final String itemName;
        GameItem defeats;
        GameItem(int itemID, String itemName) {
            this.itemID = itemID;
            this.itemName = itemName;
        }
        //-----------------------Getter-Setter-Utilities----------------------
        public GameItem getDefeats() {
            return this.defeats;
        }
        public String getItemName() {
            return this.itemName;
        }
        //--------------------------------------------------------------------
    }
    //------------------------------Core-Methods------------------------------

    //======================-Generate-Random-Item-Method-=====================
    public GameItem getRandomItem() {
        //--------------------------------------------------------------------
        // * 2. Generate a random choice for the computer.                   |
        //--------------------------------------------------------------------
        // This method returns a random item for the computer to use. The
        // variable rGeneratedNum is a random number between zero and three.
        // The Math.random() method is used in association with a cast to int
        // for whole numbers. The itemIDs associated with each choice range
        // from one to three. The randomizer will continue to roll if the
        // value is cast to zero. As to not tamper with even probability, the
        // randomizer rerolls instead of adding one when reaching zero. The
        // corresponding GameItem itemID will return the enum constant
        // associated with the value generated.
        int rGeneratedNum;
        do {
            rGeneratedNum = (int) (Math.random() * 3);
        } while (rGeneratedNum == 0);
        return switch (rGeneratedNum) {
            case 1 -> GameItem.ROCK;
            case 2 -> GameItem.PAPER;
            case 3 -> GameItem.SCISSORS;
            default -> throw new IllegalStateException(
                                 "Unexpected value: " + rGeneratedNum);
        };
    }
    //=====================-Evaluate-Round-Winner-Method-=====================
    public Player roundScenarioEval() {
        //--------------------------------------------------------------------
        // * 3. Use control statements to evaluate the game.                 |
        //--------------------------------------------------------------------
        // This method evaluates and returns the winner of the round. The
        // variables humanMove and computerMove hold the current GameItem
        // choices of the user and computer. With control statements, if a
        // GameItem’s defeats property is the opposing GameItem, the player
        // holding the item is the winner and their wins property is
        // incremented. If the GameItem of the computer and user are the same,
        // the evaluation is a draw and designates a game as a draw by
        // incrementing its win property.
        GameItem humanMove = this.getHuman().getGameItem();
        GameItem computerMove = this.getComputer().getGameItem();
        if (humanMove.getDefeats().equals(computerMove)) {
            this.getHuman().incrementWins();
            return this.getHuman();
        } else if (humanMove.equals(computerMove)) {
            this.getDraw().incrementWins();
            return this.getDraw();
        } else if (computerMove.getDefeats().equals(humanMove)) {
            this.getComputer().incrementWins();
            return this.getComputer();
        } else {
            this.getDraw().incrementWins();
            return this.getDraw();
        }
    }
    //=======================-Retrieve-User-Input-Method-=====================
    public int getUserInput() {
        // This method retrieves user input to select GameItem. The variable
        // choice designates the user’s choice of item and correctInput
        // designates whether the choice is valid. Inside a loop, a choice is
        // prompted to the user, if the user answers one, two, or three, the
        // loop will cease, and the program will continue. Otherwise, the
        // program will loop to allow for correct input. The program will act
        // the same if a non-integer is input and an NumberFormatException is
        // thrown. According to the case of each GameItem’s itemID, the
        // program will setGameItem() of the user to the chosen item.
        int choice = 0;
        boolean correctInput;
        do {
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.err.println(e + ": please input an integer");
            }
            correctInput = switch (choice) {
                case 1, 2, 3 -> true;
                default -> false;
            };
            if (!correctInput) {
                System.out.println("Please choose a number 1 - 3.");
            }
        } while (!correctInput);
        switch (choice) {
            case 1 -> {
                this.getHuman().setGameItem(GameItem.ROCK);
            }
            case 2 -> {
                this.getHuman().setGameItem(GameItem.PAPER);
            }
            case 3 -> {
               this.getHuman().setGameItem(GameItem.SCISSORS);
            }
        }
        this.getComputer().setGameItem(getRandomItem());
        return choice;
    }
//=========================-Round-Winner-Prompt-Method-=======================
    public String announceRoundWinner() {
        //--------------------------------------------------------------------
        // * 4. Print the outcome to the console.                            |
        //--------------------------------------------------------------------
        // This method will announce the winner of the round. It takes
        // PlayerType from the round evaluation in a switch to determine the
        // appropriate phrasing for each scenario.
        return switch (this.roundScenarioEval().getPlayerType()) {
            case HUMAN -> "You chose " +
                          this.getHuman().getGameItem().getItemName() +
                          " and the computer chose " +
                          this.getComputer().getGameItem().getItemName() +
                          ". You won!";
            case COMPUTER -> "You chose " +
                             this.getHuman().getGameItem().getItemName() +
                             " and the computer chose " +
                             this.getComputer().getGameItem().getItemName() +
                             ". You lost!";
            case DRAW -> "You chose and the computer chose " +
                         this.getHuman().getGameItem().getItemName() +
                         ". No winners!";
        };
    }
    //========================-Game-Winner-Prompt-Method-=====================
    public String announceGameWinner() {
        //--------------------------------------------------------------------
        // * 6. Print current winner and overall winner to the console.      |
        //--------------------------------------------------------------------
        // This method will announce the winner of the game. The variables
        // humanWins and computerWins tabulate their respective win counters.
        // The method navigates an if else block to determine the appropriate
        // phrasing for the player with the most wins or for a draw.
        String basePhrase = "Overall winner: ";
        int humanWins = this.getHuman().getWins();
        int computerWins = this.getComputer().getWins();
        if (humanWins == computerWins) {
            return basePhrase + "tie.";
        } else if (humanWins > computerWins) {
            return basePhrase + "you.";
        } else if (computerWins > humanWins) {
            return basePhrase + "computer.";
        } else {
            return basePhrase + "error.";
        }
    }
    //=======================-Current-Round-Prompt-Method-====================
    public String displayRoundCounter() {
        // This method displays the current round number starting from
        // gameRound and ending at GAME_ROUND_MAX.
        return "Round " + this.getGameRound() + ": ";
    }
    //======================-Continue-Game-Prompt-Method-=====================
    public boolean continueGame() {
        //--------------------------------------------------------------------
        // * 5. Ask if the user wants to continue the game up to five        |
        //      maximum rounds.                                              |
        //--------------------------------------------------------------------
        // This method retrieves user input to determine whether the user
        // wants to continue playing. The method enters a loop which prompts
        // the user for an integer corresponding to an affirmative or negative
        // to whether they want to continue playing. If responding with the
        // given choices, the choice is set and the loop will break to
        // continue with the method. If the user inputs a number out of range
        // or a non-integer number that throws a NumberFormatException, they
        // will be prompted to try again and the method will loop back to
        // allow for a correct input. Leaving the loop, a true or false is
        // returned based on the value of choice.
        System.out.println("Do you want to play again? Yes (1) No (2)");
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(input.nextLine());
                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.println(choice + " is not an option.");
                }
            } catch (NumberFormatException e) {
                System.err.println(e + ": please input an integer.");
            }
        }
        return switch (choice) {
            case 1 -> true;
            case 2 -> false;
            default -> throw new IllegalStateException(
                                 "Unexpected value: " + choice);
        };
    }
    //===========================-Play-Round-Method-==========================
    public void playRound() {
        //--------------------------------------------------------------------
        // * 1. Prompt the user for their choice of rock, paper, or scissors.|
        //--------------------------------------------------------------------
        // This method bundles and loops the methods of the program to run
        // RockPaperScissors. In a loop, the displayRoundCounter() is printed
        // with a statement prompting a choice of item. Using getUserInput(),
        // the data is taken from the user then tabulated as a win, loss, or
        // draw. It is announced by printing announceRoundWinner(). Once
        // completed, the round will increment with incrementRound(). The user
        // will be prompted if they want to continueGame(). If they do, the
        // program will proceed to the next iteration or break out otherwise.
        // The loop will continue until the gameRound is greater than the
        // GAME_ROUND_MAX.
        do {
            System.out.println(this.displayRoundCounter());
            System.out.println("* Please choose rock (1), paper (2)," +
                    " or scissors (3)! *");
            this.getUserInput();
            System.out.println(this.announceRoundWinner());
            this.incrementRound();
            if (this.getGameRound() > this.getGAME_ROUND_MAX()) {
                break;
            }
            if (!continueGame()) break;
        } while (this.getGameRound() <= this.getGAME_ROUND_MAX());
    }
    //===========================-Start-Game-Method-==========================
    public static void startRockPaperScissors() {
        // This method generates and begins a new game of rock, paper,
        // scissors. It calls playRound() to begin. After the game has ceased,
        // the final results of the game are printed with
        // announceGameWinner().
        RockPaperScissors game = new RockPaperScissors();
        game.playRound();
        System.out.println(game.announceGameWinner());
    }
    //=============================-Main-Method-==============================
    public static void main(String[] arg) {
        // This method will run the entirety of the program while utilizing
        // other methods as well.
        startRockPaperScissors();
        // Read README.txt to run the program.
    }
}
