package rule;

import move.*;
import result.Result;

public class DefaultRuleEngine implements RuleEngine {
    @Override
    public Result determineWinner(Move playerMove, Move computerMove) {
        System.out.println("Player chose: " + playerMove.getName());
        System.out.println("Computer chose: " + computerMove.getName());

        if (playerMove.getName().equals(computerMove.getName())) {
            System.out.println("It's a tie!");
            return Result.DRAW;
        }

        MoveEvaluator moveEvaluator = getMoveEvaluator(playerMove);
        return moveEvaluator.evaluate(playerMove, computerMove);
    }

    private MoveEvaluator getMoveEvaluator(Move move) {
        if ("ROCK".equalsIgnoreCase(move.getName())) {
            return new RockMoveEvaluator();
        } else if ("PAPER".equalsIgnoreCase(move.getName())) {
            return new PaperMoveEvaluator();
        } else if ("SCISSORS".equalsIgnoreCase(move.getName())) {
            return new ScissorsMoveEvaluator();
        } else {
            throw new IllegalArgumentException("Unsupported move: " + move.getName());
        }
    }
}
