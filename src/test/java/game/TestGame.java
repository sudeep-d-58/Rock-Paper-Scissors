package game;

import move.Rock;
import move.Scissors;
import org.junit.jupiter.api.Test;
import player.Player;
import result.Result;
import rule.RuleEngine;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TestGame {

    @Test
    void playGameAndPlayerWins() {
        Player mockPlayer = mock(Player.class);
        Player mockComputerPlayer = mock(Player.class);
        RuleEngine mockRuleEngine = mock(RuleEngine.class);
        GameResultEvaluator mockGameResultEvaluator = mock(GameResultEvaluator.class);

        when(mockPlayer.makeMove()).thenReturn(new Rock()); // Player chooses Rock
        when(mockComputerPlayer.makeMove()).thenReturn(new Scissors()); // Computer chooses Scissors
        when(mockRuleEngine.determineWinner(any(), any())).thenReturn(Result.WIN);
        when(mockGameResultEvaluator.evaluateGameResult(any())).thenReturn(Result.WIN);

        Game game = new Game(mockPlayer, mockComputerPlayer, mockRuleEngine, mockGameResultEvaluator, 3);
        game.play();

        verify(mockPlayer, times(3)).makeMove();
        verify(mockComputerPlayer, times(3)).makeMove();
        verify(mockRuleEngine, times(3)).determineWinner(any(), any());
        verify(mockGameResultEvaluator, times(1)).evaluateGameResult(any());
    }

    @Test
    void playGameAndGameEndsAfterSpecifiedRounds() {

        Player mockPlayer = mock(Player.class);
        Player mockComputerPlayer = mock(Player.class);
        RuleEngine mockRuleEngine = mock(RuleEngine.class);
        GameResultEvaluator mockGameResultEvaluator = mock(GameResultEvaluator.class);

        when(mockPlayer.makeMove()).thenReturn(new Rock());
        when(mockComputerPlayer.makeMove()).thenReturn(new Scissors());
        when(mockRuleEngine.determineWinner(any(), any())).thenReturn(Result.WIN);
        when(mockGameResultEvaluator.evaluateGameResult(any())).thenReturn(Result.WIN);

        Game game = new Game(mockPlayer, mockComputerPlayer, mockRuleEngine, mockGameResultEvaluator, 2);
        game.play();

        verify(mockPlayer, times(2)).makeMove();
        verify(mockComputerPlayer, times(2)).makeMove();
        verify(mockRuleEngine, times(2)).determineWinner(any(), any());
        verify(mockGameResultEvaluator, times(1)).evaluateGameResult(any());
    }

    @Test
    void playGameAndDraw() {

        Player mockPlayer = mock(Player.class);
        Player mockComputerPlayer = mock(Player.class);
        RuleEngine mockRuleEngine = mock(RuleEngine.class);
        GameResultEvaluator mockGameResultEvaluator = mock(GameResultEvaluator.class);

        when(mockPlayer.makeMove()).thenReturn(new Rock());
        when(mockComputerPlayer.makeMove()).thenReturn(new Rock()); // Computer chooses Rock
        when(mockRuleEngine.determineWinner(any(), any())).thenReturn(Result.DRAW);
        when(mockGameResultEvaluator.evaluateGameResult(any())).thenReturn(Result.DRAW);

        Game game = new Game(mockPlayer, mockComputerPlayer, mockRuleEngine, mockGameResultEvaluator, 3);
        game.play();

        verify(mockPlayer, times(3)).makeMove();
        verify(mockComputerPlayer, times(3)).makeMove();
        verify(mockRuleEngine, times(3)).determineWinner(any(), any());
        verify(mockGameResultEvaluator, times(1)).evaluateGameResult(any());
    }
}
