package game;

import result.Result;

import java.util.List;

public interface GameResultEvaluator {

    Result evaluateGameResult(List<GameOutcome> gameOutcomes);

}
