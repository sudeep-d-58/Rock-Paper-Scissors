package game;

import result.Result;

public class GameOutcome {

    private final Result playerResult;
    private final Result computerResult;

    public GameOutcome(Result playerResult, Result computerResult) {
        this.playerResult = playerResult;
        this.computerResult = computerResult;
    }

    public Result getPlayerResult() {
        return playerResult;
    }

    public Result getComputerResult() {
        return computerResult;
    }
}
