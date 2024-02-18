package rule;

import move.Move;
import result.Result;

public interface RuleEngine {

    Result determineWinner(Move playerMove, Move computerMove);
}
