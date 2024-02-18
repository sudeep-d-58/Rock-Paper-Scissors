package game;

import result.Result;

import java.util.List;

public class DefaultGameResultEvaluator implements GameResultEvaluator {
    @Override
    public Result evaluateGameResult(List<GameOutcome> gameOutcomes) {
        long playerWins = gameOutcomes.stream().filter(outcome -> outcome.getPlayerResult() == Result.WIN).count();
        long computerWins = gameOutcomes.stream().filter(outcome -> outcome.getComputerResult() == Result.WIN).count();

        if (playerWins > computerWins) {
            return Result.WIN;
        } else if (playerWins < computerWins) {
            return Result.LOSE;
        } else {
            return Result.DRAW;
        }
    }
}

