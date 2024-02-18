package game;

import org.junit.jupiter.api.Test;
import result.Result;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDefaultGameResultEvaluator {

    @Test
    void evaluateGameResult() {
        DefaultGameResultEvaluator gameResultEvaluator = new DefaultGameResultEvaluator();
        List<GameOutcome> gameOutcomes = new ArrayList<>();
        gameOutcomes.add(new GameOutcome(Result.WIN, Result.LOSE));
        gameOutcomes.add(new GameOutcome(Result.LOSE, Result.WIN));
        gameOutcomes.add(new GameOutcome(Result.DRAW, Result.DRAW));
        gameOutcomes.add(new GameOutcome(Result.WIN, Result.LOSE));

        Result result = gameResultEvaluator.evaluateGameResult(gameOutcomes);

        assertEquals(Result.WIN, result);
    }
}
