import game.*;
import player.Player;
import rule.RuleEngine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameLogger.logInfo("game.Game initializing...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.print("Enter the number of rounds: ");
        int rounds = scanner.nextInt();

        GameLogger.logInfo("Creating game components...");
        GameFactory gameFactory = new RockPaperScissorsFactory();
        Player humanPlayer = gameFactory.createHumanPlayer(playerName, gameFactory.getAvailableMoves(), scanner);
        Player computerPlayer = gameFactory.createComputerPlayer("Computer", gameFactory.getAvailableMoves());
        RuleEngine ruleEngine = gameFactory.createRuleEngine();
        GameResultEvaluator gameResultEvaluator = gameFactory.createGameResultEvaluator();

        GameLogger.logInfo("Starting the game...");
        Game game = new Game(humanPlayer, computerPlayer, ruleEngine, gameResultEvaluator, rounds);
        game.play();
    }
}
