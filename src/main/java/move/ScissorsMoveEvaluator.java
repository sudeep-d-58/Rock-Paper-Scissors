package move;

import result.Result;

public class ScissorsMoveEvaluator implements MoveEvaluator {

    @Override
    public Result evaluate(Move playerMove, Move computerMove) {
        return ("PAPER".equals(computerMove.getName())) ? Result.WIN : Result.LOSE;
    }
}
