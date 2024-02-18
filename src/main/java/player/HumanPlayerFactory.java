package player;

import move.Move;

import java.util.Scanner;

public interface HumanPlayerFactory {

    Player createHumanPlayer(String name, Move[] availableMoves, Scanner scanner);
}
