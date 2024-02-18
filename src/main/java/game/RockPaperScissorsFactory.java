package game;

import move.Move;
import move.Paper;
import move.Rock;
import move.Scissors;
import player.ComputerPlayer;
import player.HumanPlayer;
import player.Player;
import rule.DefaultRuleEngine;
import rule.RuleEngine;

import java.util.Scanner;

public class RockPaperScissorsFactory implements GameFactory {

    private static final Move[] AVAILABLE_MOVES = new Move[]{new Rock(), new Paper(), new Scissors()};

    @Override
    public GameResultEvaluator createGameResultEvaluator() {
        return new DefaultGameResultEvaluator();
    }

    @Override
    public Move[] getAvailableMoves() {
        return AVAILABLE_MOVES;
    }

    @Override
    public Player createHumanPlayer(String name, Move[] availableMoves, Scanner scanner) {
        return new HumanPlayer(name, scanner, availableMoves);
    }

    @Override
    public RuleEngine createRuleEngine() {
        return new DefaultRuleEngine();
    }

    @Override
    public Player createComputerPlayer(String name, Move[] availableMoves) {
        return new ComputerPlayer(name, availableMoves);
    }

}
