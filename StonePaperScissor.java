import java.util.*;

public class StonePaperScissor {

    void choice(int Choice, String ch) {
        switch (Choice) {
            case 1:
                System.out.println(ch + ": Rock");
                break;
            case 2:
                System.out.println(ch + ": Paper");
                break;
            case 3:
                System.out.println(ch + ": Scissor");
                break;
        }

    }

    void result(int userCount, int compCount) {
        if (userCount == compCount) {
            System.out.println("\nFinal result: Its a tie;)\n");
        } else if (userCount > compCount) {
            System.out.println("\nFinal result: Congratulations, you've won the game:)\n");
        } else {
            System.out.println("\nFinal result: Bad luck, The computer has won the game:(\n");
        }
    }

    void line() {
        for (int j = 0; j < 60; j++) {
            System.out.print("_");
        }
    }

    void point(int userCount, int compCount) {
        System.out.println("Your points: " + userCount);
        System.out.println("Computer's point: " + compCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();

        StonePaperScissor ob = new StonePaperScissor();

        int userChoice, compChoice, userCount = 0, compCount = 0;
        System.out.println("::Stone, paper, Scissor game::");

        ob.line();

        System.out.println("\nThere will be 5 rounds, whoever achieves more points will win the game");
        System.out.print("\nPress 1->Rock\nPress 2->Paper\nPress 3->Scissor\n");

        ob.line();

        for (int i = 0; i < 5; i++) {
            System.out.print("\n::Let's begin the " + (i + 1) + " round::");
            System.out.print("\nEnter your choice: ");
            userChoice = sc.nextInt();

            compChoice = rn.nextInt(3) + 1; // generating num from 1 to 3

            if (userChoice > 3 || userChoice < 1) {
                System.out.println("\nInvalid choice!\nResult of this round: Round is declined\n");
                // printing the points
                ob.point(userCount, compCount);

                // printing lines
                ob.line();
                continue;
            } else {
                System.out.print("\n");
                ob.choice(userChoice, "You");
                ob.choice(compChoice, "Comp");
                System.out.print("\n");
            }

            if (userChoice == compChoice) {
                System.out.println("Result of this round: Its a tie");
            } else if ((userChoice == 1 && compChoice == 3) || (userChoice == 2 && compChoice == 1)
                    || (userChoice == 3 && compChoice == 2)) {
                System.out.println("Result of this round: You won");
                userCount++;
            } else {
                System.out.println("Result of this round: Comp won");
                compCount++;
            }

            // printing the points
            ob.point(userCount, compCount);

            // printing lines
            ob.line();
        }

        ob.result(userCount, compCount);

        sc.close();
    }
}