package move;

import result.Result;

public class RockMoveEvaluator implements MoveEvaluator {
    @Override
    public Result evaluate(Move playerMove, Move computerMove) {
        return ("SCISSORS".equals(computerMove.getName())) ? Result.WIN : Result.LOSE;
    }
}
