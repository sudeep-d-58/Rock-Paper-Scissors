package rule;

import move.Move;
import move.Paper;
import move.Rock;
import move.Scissors;
import org.junit.jupiter.api.Test;
import player.ComputerPlayer;
import player.HumanPlayer;
import player.Player;
import result.Result;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TestDefaultRuleEngine {

    @Test
    void determineWinnerWithRock() {
        Move[] moves = {new Rock(), new Paper(), new Scissors()};
        DefaultRuleEngine ruleEngine = new DefaultRuleEngine();
        Player humanPlayer = mock(HumanPlayer.class);
        Player computerPlayer = mock(ComputerPlayer.class);
        when(humanPlayer.makeMove()).thenReturn(moves[0]); // Rock
        when(computerPlayer.makeMove()).thenReturn(moves[2]); // Scissors

        Result result = ruleEngine.determineWinner(humanPlayer.makeMove(), computerPlayer.makeMove());

        assertEquals(Result.WIN, result);
        verify(humanPlayer, times(1)).makeMove();
        verify(computerPlayer, times(1)).makeMove();
    }

    @Test
    void determineWinnerWithRockCaseDraw() {
        Move[] moves = {new Rock(), new Paper(), new Scissors()};
        DefaultRuleEngine ruleEngine = new DefaultRuleEngine();
        Player humanPlayer = mock(HumanPlayer.class);
        Player computerPlayer = mock(ComputerPlayer.class);
        when(humanPlayer.makeMove()).thenReturn(moves[1]); // Rock
        when(computerPlayer.makeMove()).thenReturn(moves[1]); // Rock

        Result result = ruleEngine.determineWinner(humanPlayer.makeMove(), computerPlayer.makeMove());

        assertEquals(Result.DRAW, result);
        verify(humanPlayer, times(1)).makeMove();
        verify(computerPlayer, times(1)).makeMove();
    }
}
