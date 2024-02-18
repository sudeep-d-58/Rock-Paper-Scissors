package player;

import move.Move;

import java.util.Scanner;

public class HumanPlayer implements Player {

    private String name;
    private Scanner scanner;
    private Move[] availableMoves;

    public HumanPlayer(String name, Scanner scanner, Move[] availableMoves) {
        this.name = name;
        this.scanner = scanner;
        this.availableMoves = availableMoves;
    }

    @Override
    public Move makeMove() {
        System.out.println("Available moves:");
        for (int i = 0; i < availableMoves.length; i++) {
            System.out.println((i + 1) + ". " + availableMoves[i].getName());
        }
        System.out.println("Type 'exit' to quit the game.");

        String choice;
        do {
            System.out.print("Enter your move (1-" + availableMoves.length + "): ");
            choice = scanner.next();

            if ("exit".equalsIgnoreCase(choice)) {
                System.out.println("Exiting the game gracefully...");
                System.exit(0);
            }

        } while (!isValidInput(choice));

        return availableMoves[Integer.parseInt(choice) - 1];
    }

    private boolean isValidInput(String input) {
        try {
            int choice = Integer.parseInt(input);
            return choice >= 1 && choice <= availableMoves.length;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
