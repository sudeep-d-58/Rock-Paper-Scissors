package move;

import result.Result;

public class PaperMoveEvaluator implements MoveEvaluator {

    @Override
    public Result evaluate(Move playerMove, Move computerMove) {
        return ("ROCK".equals(computerMove.getName())) ? Result.WIN : Result.LOSE;
    }
}
