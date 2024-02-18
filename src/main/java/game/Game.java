package game;

import move.Move;
import player.Player;
import result.Result;
import rule.RuleEngine;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player humanPlayer;
    private Player computerPlayer;
    private RuleEngine ruleEngine;
    private GameResultEvaluator gameResultEvaluator;
    private int rounds;

    public Game(Player humanPlayer, Player computerPlayer, RuleEngine ruleEngine,
                GameResultEvaluator gameResultEvaluator, int rounds) {
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;
        this.ruleEngine = ruleEngine;
        this.gameResultEvaluator = gameResultEvaluator;
        this.rounds = rounds;
    }

    public void play() {
        List<GameOutcome> gameOutcomes = new ArrayList<>();

        for (int i = 0; i < rounds; i++) {
            GameOutcome outcome = playRound();
            displayRoundResult(outcome);
            gameOutcomes.add(outcome);
        }
        displayGameResult(gameOutcomes);
    }

    private GameOutcome playRound() {
        Move humanMove = humanPlayer.makeMove();
        Move computerMove = computerPlayer.makeMove();

        Result roundResult = ruleEngine.determineWinner(humanMove, computerMove);

        return new GameOutcome(
                getResultForPlayer(humanPlayer, roundResult),
                getResultForPlayer(computerPlayer, roundResult));
    }

    private Result getResultForPlayer(Player player, Result roundResult) {
        if (player == humanPlayer && roundResult == Result.WIN) {
            return Result.WIN;
        } else if (player == computerPlayer && roundResult == Result.LOSE) {
            return Result.WIN;
        } else if (roundResult == Result.DRAW) {
            return Result.DRAW;
        } else {
            return Result.LOSE;
        }
    }

    private void displayRoundResult(GameOutcome outcome) {
        System.out.println("Round Result:");
        System.out.println(humanPlayer.getName() + ": " + outcome.getPlayerResult());
        System.out.println(computerPlayer.getName() + ": " + outcome.getComputerResult());
        System.out.println();
    }

    private void displayGameResult(List<GameOutcome> gameOutcomes) {
        System.out.println("game.Game Result:");
        System.out.println(getResultSummary(humanPlayer, computerPlayer, gameOutcomes));
        System.out.println("Overall Result for " + humanPlayer.getName() + ": "
                + gameResultEvaluator.evaluateGameResult(gameOutcomes));
    }

    private String getResultSummary(Player humanPlayer, Player computerPlayer, List<GameOutcome> gameOutcomes) {
        long playerWins = gameOutcomes.stream().filter(outcome -> outcome.getPlayerResult() == Result.WIN).count();
        long computerWins = gameOutcomes.stream().filter(outcome -> outcome.getComputerResult() == Result.WIN).count();
        long draws = gameOutcomes.stream().filter(outcome -> outcome.getPlayerResult() == Result.DRAW).count();

        return humanPlayer.getName() + " won " + playerWins + " rounds, " + computerPlayer.getName() + " won " + computerWins +
                " rounds, and " +
                +draws + " draws";
    }
}
