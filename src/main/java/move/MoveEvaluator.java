package move;

import result.Result;

public interface MoveEvaluator {

    Result evaluate(Move playerMove, Move computerMove);
}
